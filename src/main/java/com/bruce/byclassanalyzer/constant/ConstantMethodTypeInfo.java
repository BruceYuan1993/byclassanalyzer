package com.bruce.byclassanalyzer.constant;

import com.bruce.byclassanalyzer.Element;
import com.bruce.byclassanalyzer.U2;

public class ConstantMethodTypeInfo extends ConstantInfo{
	@Element(index = 2)
	private U2 descriptorIndex;
	
	public ConstantMethodTypeInfo(U2 nameIndex, U2 descriptorIndex) {
		this();
		this.descriptorIndex = descriptorIndex;
	}

	public ConstantMethodTypeInfo() {

	}

	public U2 getDescriptorIndex() {
		return descriptorIndex;
	}

	public void setDescriptorIndex(U2 descriptorIndex) {
		this.descriptorIndex = descriptorIndex;
	}
	
	
}
