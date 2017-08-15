package com.bruce.byclassanalyzer;

/**
 * Created by bruceyuan on 17-7-29.
 */
public abstract class BytesReader {
    protected byte[] bytes;
    public abstract int readU1();
    public abstract char readU2();
    public abstract long readU4();
    public abstract String readU8();
    public abstract String readU8Hex();
}
