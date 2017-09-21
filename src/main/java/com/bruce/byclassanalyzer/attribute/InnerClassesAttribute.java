package com.bruce.byclassanalyzer.attribute;

import com.bruce.byclassanalyzer.ClassElement;
import com.bruce.byclassanalyzer.Element;
import com.bruce.byclassanalyzer.U2;
import com.bruce.byclassanalyzer.U4;

import java.util.List;

public class InnerClassesAttribute extends Attribute{
	@Element(index = 3)
	private U2 length;

    @Element(index = 4)
	private List<InnerClass>  innerClasses;
	public static class InnerClass extends ClassElement{
        @Element(index = 1)
		private U2 innerClassInfoIndex;
        @Element(index = 2)
		private U2 outerClassInfoIndex;
        @Element(index = 3)
		private U2 innerNameIndex;
        @Element(index = 4)
		private U2 innerClassAccessFlags;
	}
}
