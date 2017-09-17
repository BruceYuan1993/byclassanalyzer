package com.bruce.byclassanalyzer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static List<Class> basicTypes =new ArrayList<>();
    public static ClassDataProvider provider;
    public static final int MAGIC_NUMBER = 0xCAFEBABE;
    public static void main( String[] args ) throws Exception {
        basicTypes.add(U1.class);
        basicTypes.add(U2.class);
        basicTypes.add(U4.class);
        basicTypes.add(U8.class);
        basicTypes.add(Table.class);

        byte[] result = null;
        try (FileChannel fc = new FileInputStream("/home/bruceyuan/ClassFileTest.class").getChannel()){
            ByteBuffer buff = ByteBuffer.allocate((int) fc.size());
            fc.read(buff);
            buff.flip();
            result = buff.array();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        provider = new DefaultClassDataProvider(result);
        U4 magic = provider.readU4();
        if (magic.getValue() != Integer.toUnsignedLong(MAGIC_NUMBER)) {
            throw new ClassFormatError("Invaild magic number: " + magic.getValue());
        }
        System.out.print(magic.toHexString());
        Object o = parseChild(ClassFile.class);
    }

    public static Object parseChild(Class<? extends ClassElement> c) throws Exception {
        ClassElement result = c.newInstance();
        result.setOffset(provider.getPosition());
        Object[] fields = Arrays.stream(c.getDeclaredFields()).
                filter(x -> x.isAnnotationPresent(ClassMember.class)).
                sorted((x,y) -> x.getAnnotation(ClassMember.class).index() -
                        y.getAnnotation(ClassMember.class).index()
                ).toArray();
        UBase lastCount = null;
        for (Object a : fields){
            Field f = (Field) a;
            f.setAccessible(true);
            if (basicTypes.contains(f.getType())){
                UBase x = null;
                long offset = provider.getPosition();
                if (f.getType() == U1.class){
                    x = provider.readU1();
                }else if (f.getType() == U2.class){
                    x = provider.readU2();
                }else if (f.getType() == U4.class){
                    x = provider.readU4();
                }else if (f.getType() == U8.class){
                    x = provider.readU8();
                }else {
                    String  genericTypeName = f.getGenericType().getTypeName();
                    genericTypeName = genericTypeName.substring(genericTypeName.indexOf("<") + 1 ,
                            genericTypeName.indexOf(">"));
                    Class genericType = Class.forName(genericTypeName);
                    System.out.print(lastCount.getValue());

                    for (int i = 0; i < lastCount.getValue(); i++){
                        f.set(result, parseChild((Class<? extends ClassElement>)f.getType()));
                    }
                }

                long length = provider.getPosition() - offset;
                x.setOffset((int)offset);
                x.setLength((int)length);
                lastCount = x;
                f.set(result, x);
            } else {
                f.set(result, parseChild((Class<? extends ClassElement>)f.getType()));
            }
        }
        result.setLength((int)(provider.getPosition() - result.getOffset()));
        return result;
    }
}
