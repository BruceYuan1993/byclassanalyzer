package com.bruce.byclassanalyzer.constant;

import com.bruce.byclassanalyzer.ClassElement;
import com.bruce.byclassanalyzer.Element;
import com.bruce.byclassanalyzer.Table;
import com.bruce.byclassanalyzer.U2;

/**
 * Created by bruceyuan on 17-9-17.
 */

/*
    cp_info {
        u1 tag;
        u1 info[];
    }
 */
public class ConstantPool extends ClassElement{
    @Element(index = 1)
    private U2 count;

    @Element(index = 2)
    private Table<ConstantInfo> items;
}
