package com.bruce.byclassanalyzer;

/**
 * 表示class文件中各项元素。最大为class文件本身，最小为U1
 *
 */
public abstract class ClassElement {
    // 表示该元素在class文件byte流中的起始位置
    private long offset;
    // 表示该元素所占byte的长度
    private int length;

    // getter and setter
    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
