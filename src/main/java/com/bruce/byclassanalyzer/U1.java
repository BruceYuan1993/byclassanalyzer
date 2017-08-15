package com.bruce.byclassanalyzer;

/**
 * Created by bruceyuan on 17-8-12.
 */
public class U1 {
    private byte data;
    private int value;

    public U1(byte data) {
        super();
        this.data = data;
        this.value = Byte.toUnsignedInt(data);
    }

    public int getValue()
    {
        return value;
    }

    public String toHexString()
    {
        return Integer.toHexString(value);
    }

}

