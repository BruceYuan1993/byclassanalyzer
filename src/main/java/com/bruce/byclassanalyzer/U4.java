package com.bruce.byclassanalyzer;

import java.nio.ByteBuffer;

/**
 * Created by bruceyuan on 17-8-15.
 */
public class U4 {
    private byte[] data;
    private long value;

    public U4(byte[] data) {
        if (data != null && data.length != 4){
            throw new RuntimeException();
        }
        this.data = data;
        this.value = Integer.toUnsignedLong(ByteBuffer.wrap(data).getInt());
    }

    public long getValue(){
        return value;
    }

    public String toHexString(){
        return Long.toHexString(value);
    }

}