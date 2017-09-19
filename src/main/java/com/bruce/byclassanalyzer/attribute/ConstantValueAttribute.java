package com.bruce.byclassanalyzer.attribute;

import com.bruce.byclassanalyzer.Element;
import com.bruce.byclassanalyzer.U2;
import com.bruce.byclassanalyzer.U4;

public class ConstantValueAttribute extends Attribute{

	@Element(index = 3)
	private U2 constantValueIndex;

	public U2 getConstantValueIndex() {
		return constantValueIndex;
	}

	public void setConstantValueIndex(U2 constantValueIndex) {
		this.constantValueIndex = constantValueIndex;
	}


}
