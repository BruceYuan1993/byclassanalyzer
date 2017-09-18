package com.bruce.byclassanalyzer.constant;

import com.bruce.byclassanalyzer.ClassMember;
import com.bruce.byclassanalyzer.U8;

public class ConstantLongInfo extends ConstantInfo{
	@ClassMember(index = 2)
	private U8 data;

	public ConstantLongInfo(U8 data) {
		this();
		this.data = data;
	}
	public ConstantLongInfo() {

	}
	
	public long getValue(){
		return data.getValue();
	}
}
