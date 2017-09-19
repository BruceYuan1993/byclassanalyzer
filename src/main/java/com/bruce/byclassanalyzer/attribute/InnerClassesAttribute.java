package com.bruce.byclassanalyzer.attribute;

import com.bruce.byclassanalyzer.Element;
import com.bruce.byclassanalyzer.U2;
import com.bruce.byclassanalyzer.U4;

public class InnerClassesAttribute extends Attribute{
	@Element(index = 3)
	private U2 classSize;
	
	static class InnerClass{
		
	}
}
