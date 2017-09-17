package com.bruce.byclassanalyzer.constant;

import com.bruce.byclassanalyzer.U4;

public class ConstantFloatInfo extends ConstantInfo{
	private U4 data;

	public ConstantFloatInfo(U4 data) {
		this();
		this.data = data;
	}
	public ConstantFloatInfo() {
		this.tag = ConstantInfo.CONSTANT_FLOAT_INFO;
	}
	
	public double getValue(){
		return Double.longBitsToDouble(data.getValue());
	}
}
