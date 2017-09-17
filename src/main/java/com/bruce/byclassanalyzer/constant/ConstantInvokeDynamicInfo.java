package com.bruce.byclassanalyzer.constant;

import com.bruce.byclassanalyzer.U2;

public class ConstantInvokeDynamicInfo extends ConstantInfo{
	U2 bootstrapMethodAttrIndex;
	U2 nameAndTypeIndex;
	
	public ConstantInvokeDynamicInfo(U2 bootstrapMethodAttrIndex, U2 nameAndValueIndex) {
		this();
		this.bootstrapMethodAttrIndex = bootstrapMethodAttrIndex;
		this.nameAndTypeIndex = nameAndValueIndex;
	}

	public ConstantInvokeDynamicInfo() {
		this.tag = ConstantInfo.CONSTANT_INVOKEDYNAMIC_INFO;
	}

	public U2 getBootstrapMethodAttrIndex() {
		return bootstrapMethodAttrIndex;
	}

	public void setBootstrapMethodAttrIndex(U2 bootstrapMethodAttrIndex) {
		this.bootstrapMethodAttrIndex = bootstrapMethodAttrIndex;
	}

	public U2 getNameAndTypeIndex() {
		return nameAndTypeIndex;
	}

	public void setNameAndTypeIndex(U2 nameAndTypeIndex) {
		this.nameAndTypeIndex = nameAndTypeIndex;
	}
	
	
}
