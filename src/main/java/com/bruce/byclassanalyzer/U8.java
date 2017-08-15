package com.bruce.byclassanalyzer;

import java.nio.ByteBuffer;

/**
 * Created by bruceyuan on 17-8-15.
 */
public class U8 {
    private byte[] data;
    private long value;

    public U8(byte[] data) {
        if (data != null && data.length != 8){
            throw new RuntimeException();
        }
        this.data = data;
        this.value = ByteBuffer.wrap(data).getLong();
    }

    public long getValue(){
        return value;
    }

    public String toHexString(){
        return Long.toHexString(value);
    }

}
