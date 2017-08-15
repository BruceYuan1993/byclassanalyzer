package com.bruce.byclassanalyzer;

/**
 * Created by bruceyuan on 17-8-15.
 */
public class ClassReader {
    private byte[] classData;
    private int pos;

    public ClassReader(byte[] classData) {
        this.classData = classData;
    }

    U1 readU1(){
        byte data = classData[pos];
        return new U1(data);
    }

    U2 readU2(){
        byte[] data = new byte[2];
        System.arraycopy(classData, pos, data, 0, 2);
        pos+=2;
        return new U2(data);
    }


    U4 readU4(){
        byte[] data = new byte[4];
        System.arraycopy(classData, pos, data, 0, 4);
        pos+=4;
        return new U4(data);
    }

    U8 readU8(){
        byte[] data = new byte[8];
        System.arraycopy(classData, pos, data, 0, 8);
        pos+=8;
        return new U8(data);
    }

    ClassFile read(){
        ClassFile cls = new ClassFile();
        readAndCheckMagic();
        cls.setVersion(readAndCheckVersion());
        cls.setConstantPool(readConstantPool());
        return cls;
    }

    void readAndCheckMagic(){
        U4 magic = readU4();
        if (magic.getValue() != Integer.toUnsignedLong(ClassFile.MAGIC_NUMBER)){
            throw new ClassFormatError("Invaild magic number: " + magic.getValue());
        }
    }

    ClassFile.ClassVersion readAndCheckVersion(){
        U2 major = readU2();
        U2 minor = readU2();
        boolean flag = false;

        switch (major.getValue()){
            case 45:
                flag = true;
                break;
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
                if (minor.getValue() == 0){
                    flag = true;
                }
                break;
            default:
                break;
        }
        if (flag){
            return new ClassFile.ClassVersion(major,minor);
        } else {
            throw new UnsupportedClassVersionError(major +"." + minor);
        }
    }

    ConstantPool readConstantPool(){
        U2 count = readU2();
        ConstantPool pool = new ConstantPool(count);

        return pool;
    }

}
