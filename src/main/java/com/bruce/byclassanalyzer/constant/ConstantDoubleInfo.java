package com.bruce.byclassanalyzer.constant;

import com.bruce.byclassanalyzer.Element;
import com.bruce.byclassanalyzer.U8;

public class ConstantDoubleInfo extends ConstantInfo{
	@Element(index = 2)
	private U8 data;

	public ConstantDoubleInfo(U8 data) {
		this();
		this.data = data;
	}
	
	public ConstantDoubleInfo() {
		
	}
	
	public double getValue(){
		return Double.longBitsToDouble(data.getValue());
	}
	
}
