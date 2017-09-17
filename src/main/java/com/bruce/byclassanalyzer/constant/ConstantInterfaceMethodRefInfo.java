package com.bruce.byclassanalyzer.constant;

import com.bruce.byclassanalyzer.U2;

public class ConstantInterfaceMethodRefInfo extends ConstantMemberRefInfo{
	public ConstantInterfaceMethodRefInfo(U2 classIndex, U2 nameAndValueIndex) {
		this();
		this.classIndex = classIndex;
		this.nameAndTypeIndex = nameAndValueIndex;
	}

	public ConstantInterfaceMethodRefInfo() {
		this.tag = ConstantInfo.CONSTANT_METHODREF_INFO;
	}
}
