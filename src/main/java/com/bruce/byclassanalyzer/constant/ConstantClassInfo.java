package com.bruce.byclassanalyzer.constant;


import com.bruce.byclassanalyzer.U2;

public class ConstantClassInfo extends ConstantInfo{
	private U2 nameIndex;
	
	public ConstantClassInfo(U2 nameIndex) {
		this();
		this.nameIndex = nameIndex;
	}

	public ConstantClassInfo() {
		this.tag = ConstantInfo.CONSTANT_CLASS_INFO;
	}

	public U2 getNameIndex() {
		return nameIndex;
	}

	public void setNameIndex(U2 nameIndex) {
		this.nameIndex = nameIndex;
	}
}
