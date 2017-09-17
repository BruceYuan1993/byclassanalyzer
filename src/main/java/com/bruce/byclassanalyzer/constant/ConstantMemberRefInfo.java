package com.bruce.byclassanalyzer.constant;

import com.bruce.byclassanalyzer.U2;

public abstract class ConstantMemberRefInfo extends ConstantInfo{
	protected U2 classIndex;
	protected U2 nameAndTypeIndex;
	
	public U2 getClassIndex() {
		return classIndex;
	}
	public void setClassIndex(U2 classIndex) {
		this.classIndex = classIndex;
	}
	public U2 getNameAndValueIndex() {
		return nameAndTypeIndex;
	}
	public void setNameAndValueIndex(U2 nameAndValueIndex) {
		this.nameAndTypeIndex = nameAndValueIndex;
	}
}
