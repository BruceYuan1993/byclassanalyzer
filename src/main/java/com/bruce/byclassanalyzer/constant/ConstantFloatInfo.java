package com.bruce.byclassanalyzer.constant;

import com.bruce.byclassanalyzer.ClassMember;
import com.bruce.byclassanalyzer.U4;

public class ConstantFloatInfo extends ConstantInfo{
	@ClassMember(index = 2)
	private U4 data;

	public ConstantFloatInfo(U4 data) {
		this();
		this.data = data;
	}
	public ConstantFloatInfo() {

	}
	
	public double getValue(){
		return Double.longBitsToDouble(data.getValue());
	}
}
