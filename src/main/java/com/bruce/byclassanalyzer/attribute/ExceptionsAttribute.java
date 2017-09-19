package com.bruce.byclassanalyzer.attribute;

import java.util.List;

import com.bruce.byclassanalyzer.Element;
import com.bruce.byclassanalyzer.U2;
import com.bruce.byclassanalyzer.U4;

public class ExceptionsAttribute extends Attribute{
    @Element(index = 3)
	private U2 length;
    @Element(index = 4)
	private List<U2> exceptionIndexs;

	public U2 getLength() {
		return length;
	}
	public void setLength(U2 length) {
		this.length = length;
	}
	public List<U2> getExceptionIndexs() {
		return exceptionIndexs;
	}
	public void setExceptionIndexs(List<U2> exceptionIndexs) {
		this.exceptionIndexs = exceptionIndexs;
	}
}
