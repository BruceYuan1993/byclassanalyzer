package com.bruce.byclassanalyzer.constant;

import com.bruce.byclassanalyzer.U8;

public class ConstantLongInfo extends ConstantInfo{
	private U8 data;

	public ConstantLongInfo(U8 data) {
		this();
		this.data = data;
	}
	public ConstantLongInfo() {
		this.tag = ConstantInfo.CONSTANT_LONG_INFO;
	}
	
	public long getValue(){
		return data.getValue();
	}
}
