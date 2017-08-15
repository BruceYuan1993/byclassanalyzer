package com.bruce.byclassanalyzer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruceyuan on 17-8-15.
 */
public class ConstantPool {
    private U2 count;
    private List<ConstantInfo> data;

    public ConstantPool(U2 count) {
        this.count = count;
        data = new ArrayList<>(count.getValue()-1);
    }
}
