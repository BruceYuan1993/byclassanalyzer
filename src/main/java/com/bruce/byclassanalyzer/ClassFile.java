package com.bruce.byclassanalyzer;

import com.bruce.byclassanalyzer.attribute.Attribute;
import com.bruce.byclassanalyzer.constant.ConstantInfo;

import java.util.List;

/**
 * Created by bruceyuan on 17-8-15.
 */
public class ClassFile extends ClassElement{
    /*
        ClassFile {
            u4             magic;
            u2             minor_version;
            u2             major_version;
            u2             constant_pool_count;
            cp_info        constant_pool[constant_pool_count-1];
            u2             access_flags;
            u2             this_class;
            u2             super_class;
            u2             interfaces_count;
            u2             interfaces[interfaces_count];
            u2             fields_count;
            field_info     fields[fields_count];
            u2             methods_count;
            method_info    methods[methods_count];
            u2             attributes_count;
            attribute_info attributes[attributes_count];
        }
    */
    @Element(index = 1)
    private ClassVersion version;

    @Element(index = 2)
    private U2 cpCount;

    @Element(index = 3)
    public List<ConstantInfo> constantPool;

    @Element(index = 4)
    private U2 accessFlags;

    @Element(index = 5)
    private U2 thisClass;

    @Element(index = 6)
    private U2 superClass;

    @Element(index = 7)
    private U2 interfacesCount;

    @Element(index = 8)
    private List<U2> interfaces;

    @Element(index = 9)
    private U2 fieldsCount;

    @Element(index = 10)
    private List<ClassMember> fields;

    @Element(index = 11)
    private U2 methodsCount;

    @Element(index = 12)
    private List<ClassMember> methods;

    @Element(index = 13)
    private U2 attributesCount;

//    @Element(index = 14)
//    private List<Attribute> attributes;

}
