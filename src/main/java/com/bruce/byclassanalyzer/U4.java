package com.bruce.byclassanalyzer;

import java.nio.ByteBuffer;

/**
 * Created by bruceyuan on 17-8-15.
 */
public class U4 extends UBase{
    public U4(byte[] data) {
        super(data, 4);
    }

    @Override
    public long read(byte[] data) {
        return Integer.toUnsignedLong(ByteBuffer.wrap(data).getInt());
    }
}