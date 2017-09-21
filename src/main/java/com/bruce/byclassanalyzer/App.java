package com.bruce.byclassanalyzer;

import com.bruce.byclassanalyzer.attribute.*;
import com.bruce.byclassanalyzer.constant.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
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
    private static List<ConstantInfo> constantPool= null;
    public static void main( String[] args ) throws Exception {
        basicTypes.add(U1.class);
        basicTypes.add(U2.class);
        basicTypes.add(U4.class);
        basicTypes.add(U8.class);

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
        for (ConstantInfo con: o.constantPool) {
            if (con!= null && con.getClass() == ConstantUtf8Info.class){
                System.out.println(con);
            }
        }
        System.out.println("--"+ (ConstantUtf8Info)constantPool.get(64));
       ;

    }

    public static Object parseChild(Class<? extends ClassElement> cls) throws Exception {
        ClassElement result;
        long offset = provider.getPosition();
        if (basicTypes.contains(cls))
        {
            result = readUInt(cls);
        } else {
            result = cls.newInstance();

            Object[] fields = getDeclaredField(cls).stream().
                    filter(x -> x.isAnnotationPresent(Element.class)).
                    sorted((x,y) -> x.getAnnotation(Element.class).index() -
                            y.getAnnotation(Element.class).index()
                    ).toArray();

            Object lastResult = null;

            for (Object o : fields){
                Object value = null;
                Field field = (Field) o;
                field.setAccessible(true);
                Class<?> fieldType= field.getType();
                if (fieldType == byte[].class){
                    if (lastResult != null && UBase.class.isInstance(lastResult)){
                        UBase count = (UBase) lastResult;
                        value = provider.readBytes((int)count.getValue());
                    }
                }else if (fieldType == List.class) {
                    Class genericType = (Class) ((ParameterizedType)field.getGenericType()).
                            getActualTypeArguments()[0];
                    if (lastResult != null && UBase.class.isInstance(lastResult)){
                        UBase count = (UBase) lastResult;
                        List list = parseTable(genericType, count);
                        value = list;
                    }
                } else {
                    value = parseChild((Class<? extends ClassElement>)fieldType);
                }
                lastResult = value;
                field.set(result, value);
            }
        }
        result.setOffset(offset);
        result.setElementLength((int)(provider.getPosition() - result.getOffset()));
        return result;
    }

    private static List parseTable(Class genericType, UBase count) throws Exception {
        List list = new ArrayList<>();
        int index = 0;
        if (genericType == ConstantInfo.class){
            index = 1;
            list.add(null);
            constantPool = list;
        }
        for (; index < count.getValue(); index++){
            Class actualtype = null;
            if (genericType == ConstantInfo.class)
            {
                U1 tag = provider.readU1(true);
                actualtype = getConstantInfo(tag);
            }
            else if (genericType == Attribute.class){
                U2 type = provider.readU2(true);
                actualtype = getAttributeInfo(type);
            }
            else
            {
                actualtype = genericType;
            }
            System.out.println(actualtype);
            list.add(parseChild((Class<? extends ClassElement>)actualtype));

            if (actualtype == ConstantDoubleInfo.class
                    || actualtype == ConstantLongInfo.class){
                index++;
                list.add(null);
            }
        }
        return list;
    }

    public static UBase readUInt(Class<?> c){
        UBase result = null;
        if (c == U1.class){
            result = provider.readU1();
        }else if (c == U2.class){
            result = provider.readU2();
        }else if (c == U4.class){
            result = provider.readU4();
        }else if (c == U8.class){
            result = provider.readU8();
        }else {

        }
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

    private static Class<? extends  Attribute> getAttributeInfo(U2 type){
        Class<? extends  Attribute> result = null;
        switch (readStringFromConstantPool(type)) {
            case Attribute.CONSTANTVALUE:
                result = ConstantValueAttribute.class;
                break;
            case Attribute.CODE:
                result = CodeAttribute.class;
                break;
            case Attribute.LINENUMBERTABLE:
                result = LineNumberTableAttribute.class;
                break;
            case Attribute.LOCALVARIABLETABLE:
                result = LocalVariableTableAttribute.class;
                break;
            case Attribute.EXCEPTIONS:
                result = ExceptionsAttribute.class;
                break;
            case Attribute.SOURCEFILE:
                result = SourceFileAttribute.class;
                break;
            case Attribute.InnerClasses:
                result = InnerClassesAttribute.class;
                break;
            default:
                break;
        }
        return result;
    }

    private static String readStringFromConstantPool(U2 index){
        ConstantUtf8Info val = (ConstantUtf8Info)constantPool.get((int)index.getValue());
        return val.toString();
    }


}
