package com.bruce.byclassanalyzer.constant;

import com.bruce.byclassanalyzer.U8;

public class ConstantDoubleInfo extends ConstantInfo{
	private U8 data;

	public ConstantDoubleInfo(U8 data) {
		this();
		this.data = data;
	}
	
	public ConstantDoubleInfo() {
		this.tag = ConstantInfo.CONSTANT_DOUBLE_INFO;
	}
	
	public double getValue(){
		return Double.longBitsToDouble(data.getValue());
	}
	
}
