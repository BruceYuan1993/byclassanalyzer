package com.bruce.byclassanalyzer;

import java.nio.ByteBuffer;

/**
 * Created by bruceyuan on 17-8-12.
 */
public class U2 {
    private byte[] data;
    private int value;

    public U2(byte[] data) {
        if (data != null && data.length != 2){
            throw new RuntimeException();
        }
        this.data = data;
        this.value = ByteBuffer.wrap(data).getChar();
    }

    public int getValue(){
        //Byte.toUnsignedInt(data)
        return value;
    }

    public String toHexString(){
        return Integer.toHexString(value);
    }

}

