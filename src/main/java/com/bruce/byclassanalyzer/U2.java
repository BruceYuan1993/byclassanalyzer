package com.bruce.byclassanalyzer;

import java.nio.ByteBuffer;

/**
 * Created by bruceyuan on 17-8-12.
 */
public class U2 extends UBase{
    public U2(byte[] data) {
        super(data, 2);
    }

    @Override
    public long read(byte[] data) {
        return ByteBuffer.wrap(data).getChar();
    }
}

