package com.bruce.byclassanalyzer.constant;

import com.bruce.byclassanalyzer.Element;
import com.bruce.byclassanalyzer.U4;

public class ConstantIntegerInfo extends ConstantInfo{
	@Element(index = 2)
	private U4 data;

	public ConstantIntegerInfo(U4 data) {
		this();
		this.data = data;
	}
	public ConstantIntegerInfo() {

	}
	
	public long getValue(){
		return data.getValue();
	}
}