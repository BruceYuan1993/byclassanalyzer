package com.bruce.byclassanalyzer;

import com.bruce.byclassanalyzer.constant.*;
import com.sun.org.apache.bcel.internal.classfile.ConstantUtf8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
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
        basicTypes.add(byte[].class);

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
        ClassFile o = (ClassFile)parseChild(ClassFile.class);
        for (ConstantInfo con: o.constantPool.getItems()
             ) {
            if (con.getClass() == ConstantUtf8Info.class){
                ConstantUtf8
                System.out.println(con);
            }
        }

    }

    public static Object parseChild(Class<? extends ClassElement> c) throws Exception {
        ClassElement result = c.newInstance();
        result.setOffset(provider.getPosition());
        Object[] fields = getDeclaredField(c).stream().
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
                }else if (f.getType() == Table.class){
                    Class genericType = (Class) ((ParameterizedType)f.getGenericType()).
                            getActualTypeArguments()[0];
                    Table table = new Table<>();
                    List list = new ArrayList<>();
                    for (int i = 1; i < lastCount.getValue(); i++){
                        U1 tag = provider.readU1(true);
                        Class actualtype = getConstantInfo(tag);
                        list.add(parseChild((Class<? extends ClassElement>)actualtype));

                        if (actualtype == ConstantDoubleInfo.class || actualtype == ConstantLongInfo.class){
                            i++;
                        }
                        System.out.println(i);
                    }
                    table.setItems(list);
                    f.set(result, table);
                    continue;
                } else if (f.getType() == byte[].class) {
                    f.set(result, provider.readBytes((int)lastCount.getValue()));
                    continue;
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

    public static List<Field> getDeclaredField(Class<?> clazz){
        List<Field> fields = new ArrayList<>();
        for(; clazz != Object.class ; clazz = clazz.getSuperclass()) {
            try {
                for (Field field : clazz.getDeclaredFields()) {
                    fields.add(field);
                }

            } catch (Exception e) {
                //这里甚么都不能抛出去。
                //如果这里的异常打印或者往外抛，则就不会进入
            }
        }

        return fields;
    }

    private static Class<? extends ConstantInfo> getConstantInfo(U1 tag) {
        Class<? extends ConstantInfo> result = null;
        switch ((int)tag.getValue()) {
            case ConstantInfo.CONSTANT_UTF8_INFO:
                result = ConstantUtf8Info.class;
                break;
            case ConstantInfo.CONSTANT_INTEGER_INFO:
                result = ConstantIntegerInfo.class;
                break;
            case ConstantInfo.CONSTANT_FLOAT_INFO:
                result = ConstantFloatInfo.class;
                break;
            case ConstantInfo.CONSTANT_LONG_INFO:
                result = ConstantLongInfo.class;
                break;
            case ConstantInfo.CONSTANT_DOUBLE_INFO:
                result = ConstantDoubleInfo.class;
                break;
            case ConstantInfo.CONSTANT_CLASS_INFO:
                result = ConstantClassInfo.class;
                break;
            case ConstantInfo.CONSTANT_STRING_INFO:
                result = ConstantStringInfo.class;
                break;
            case ConstantInfo.CONSTANT_FIELDREF_INFO:
                result = ConstantFieldRefInfo.class;
                break;
            case ConstantInfo.CONSTANT_METHODREF_INFO:
                result = ConstantMethodRefInfo.class;
                break;
            case ConstantInfo.CONSTANT_INTERFACEMETHODREF_INFO:
                result = ConstantInterfaceMethodRefInfo.class;
                break;
            case ConstantInfo.CONSTANT_NAMEANDTYPE_INFO:
                result = ConstantNameAndTypeInfo.class;
                break;
            case ConstantInfo.CONSTANT_METHODHANDLE_INFO:
                result = ConstantMethodHandleInfo.class;
                break;
            case ConstantInfo.CONSTANT_METHODTYPE_INFO:
                result = ConstantMethodTypeInfo.class;
                break;
            case ConstantInfo.CONSTANT_INVOKEDYNAMIC_INFO:
                break;
            default:
                break;
        }
        return result;
    }

}
