package com.bruce.byclassanalyzer;

import com.bruce.byclassanalyzer.attribute.Attribute;

import java.util.List;

/**
 * Created by bruceyuan on 17-9-19.
 */
public class ClassMember extends ClassElement{
    @Element(index = 1)
    private U2 accessFlag;
    @Element(index = 2)
    private U2 nameIndex;
    @Element(index = 3)
    private U2 descriptorIndex;
    @Element(index = 4)
    private U2 attributesCount;
    @Element(index = 5)
    private List<Attribute> attributes;

    public U2 getAccessFlag() {
        return accessFlag;
    }
    public void setAccessFlag(U2 accessFlag) {
        this.accessFlag = accessFlag;
    }

    public U2 getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(U2 nameIndex) {
        this.nameIndex = nameIndex;
    }

    public U2 getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(U2 descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    public U2 getAttributesCount() {
        return attributesCount;
    }
}
