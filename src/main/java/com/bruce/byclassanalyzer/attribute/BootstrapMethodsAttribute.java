package com.bruce.byclassanalyzer.attribute;

import com.bruce.byclassanalyzer.ClassElement;
import com.bruce.byclassanalyzer.Element;
import com.bruce.byclassanalyzer.U2;

import java.util.List;

/**
 * Created by bruceyuan on 17-9-21.
 */
public class BootstrapMethodsAttribute extends Attribute{
    @Element(index = 3)
    private U2 length;
    @Element(index = 4)
    private List<BootstrapMethod> bootstrapMethods;

    public static class BootstrapMethod extends ClassElement{
        private U2 bootstrapMethodRef;
        //private
    }
}
