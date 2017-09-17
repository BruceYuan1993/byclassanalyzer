package com.bruce.byclassanalyzer;

/**
 * Created by bruceyuan on 17-9-17.
 */
public class DefaultClassDataProvider extends ClassDataProvider{
    private byte[] classData;

    public DefaultClassDataProvider(byte[] classData) {
        this.classData = classData;
    }

    @Override
    protected byte[] readBytesInternal(int len) {
        byte[] data = new byte[len];
        System.arraycopy(classData, (int)getPosition(), data, 0, len);
        return data;
    }
}
