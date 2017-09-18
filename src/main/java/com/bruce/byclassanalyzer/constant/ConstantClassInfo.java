package com.bruce.byclassanalyzer.constant;


import com.bruce.byclassanalyzer.ClassMember;
import com.bruce.byclassanalyzer.U2;

public class ConstantClassInfo extends ConstantInfo{
	@ClassMember(index = 2)
	private U2 nameIndex;
	
	public ConstantClassInfo(U2 nameIndex) {
		this();
		this.nameIndex = nameIndex;
	}

	public ConstantClassInfo() { }

	public U2 getNameIndex() {
		return nameIndex;
	}

	public void setNameIndex(U2 nameIndex) {
		this.nameIndex = nameIndex;
	}
}
