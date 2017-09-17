package com.bruce.byclassanalyzer.constant;

import com.bruce.byclassanalyzer.U4;

public class ConstantIntegerInfo extends ConstantInfo{
	private U4 data;

	public ConstantIntegerInfo(U4 data) {
		this();
		this.data = data;
	}
	public ConstantIntegerInfo() {
		this.tag = ConstantInfo.CONSTANT_INTEGER_INFO;
	}
	
	public long getValue(){
		return data.getValue();
	}
}