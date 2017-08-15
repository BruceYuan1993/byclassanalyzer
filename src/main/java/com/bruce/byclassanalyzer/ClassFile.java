package com.bruce.byclassanalyzer;

/**
 * Created by bruceyuan on 17-8-15.
 */
public class ClassFile {
    public static final int MAGIC_NUMBER = 0xCAFEBABE;
    private ClassVersion version;
    private ConstantPool constantPool;
    public ClassVersion getVersion() {
        return version;
    }

    public void setVersion(ClassVersion version) {
        this.version = version;
    }

    public ConstantPool getConstantPool() {
        return constantPool;
    }

    public void setConstantPool(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    static class ClassVersion{
        private U2 majorVersion;

        private U2 minorVersion;


        ClassVersion(U2 majorVersion, U2 minorVersion) {
            this.majorVersion = majorVersion;
            this.minorVersion = minorVersion;
        }

        public U2 getMajorVersion() {
            return majorVersion;
        }

        public U2 getMinorVersion() {
            return minorVersion;
        }


        @Override
        public String toString() {
            return majorVersion + "." + minorVersion;
        }
    }
}
