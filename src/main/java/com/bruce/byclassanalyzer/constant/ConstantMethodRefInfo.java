package com.bruce.byclassanalyzer.constant;

import com.bruce.byclassanalyzer.U2;

public class ConstantMethodRefInfo extends ConstantMemberRefInfo{
	public ConstantMethodRefInfo(U2 classIndex, U2 nameAndValueIndex) {
		this();
		this.classIndex = classIndex;
		this.nameAndTypeIndex = nameAndValueIndex;
	}

	public ConstantMethodRefInfo() {
		this.tag = ConstantInfo.CONSTANT_METHODREF_INFO;
	}
}
