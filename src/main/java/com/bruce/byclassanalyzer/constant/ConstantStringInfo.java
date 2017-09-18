package com.bruce.byclassanalyzer.constant;

import com.bruce.byclassanalyzer.ClassMember;
import com.bruce.byclassanalyzer.U2;

public class ConstantStringInfo extends ConstantInfo{
	@ClassMember(index = 2)
	private U2 nameIndex;
	
	public ConstantStringInfo(U2 nameIndex) {
		this();
		this.nameIndex = nameIndex;
	}

	public ConstantStringInfo() {

	}

	public U2 getNameIndex() {
		return nameIndex;
	}

	public void setNameIndex(U2 nameIndex) {
		this.nameIndex = nameIndex;
	}
}
