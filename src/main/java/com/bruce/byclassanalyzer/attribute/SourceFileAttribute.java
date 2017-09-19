package com.bruce.byclassanalyzer.attribute;

import com.bruce.byclassanalyzer.Element;
import com.bruce.byclassanalyzer.U2;
import com.bruce.byclassanalyzer.U4;

public class SourceFileAttribute extends Attribute{

    @Element(index = 3)
	private U2 sourceIndex;

	public U2 getSourceIndex() {
		return sourceIndex;
	}

	public void setSourceIndex(U2 sourceIndex) {
		this.sourceIndex = sourceIndex;
	}
}
