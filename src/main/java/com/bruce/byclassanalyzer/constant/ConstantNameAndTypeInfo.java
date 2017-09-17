package com.bruce.byclassanalyzer.constant;

import com.bruce.byclassanalyzer.U2;

public class ConstantNameAndTypeInfo extends ConstantInfo{
	private U2 nameIndex;
	private U2 descriptorIndex;
	
	public ConstantNameAndTypeInfo(U2 nameIndex, U2 descriptorIndex) {
		this();
		this.nameIndex = nameIndex;
		this.descriptorIndex = descriptorIndex;
	}

	public ConstantNameAndTypeInfo() {
		this.tag = ConstantInfo.CONSTANT_NAMEANDTYPE_INFO;
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
	
}
