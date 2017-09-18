package com.bruce.byclassanalyzer.constant;

import com.bruce.byclassanalyzer.ClassMember;
import com.bruce.byclassanalyzer.U1;
import com.bruce.byclassanalyzer.U2;

public class ConstantMethodHandleInfo extends ConstantInfo{
	@ClassMember(index = 2)
	private U1 referenceKind;
	@ClassMember(index = 3)
	private U2 referenceIndex;

	public ConstantMethodHandleInfo(U1 referenceKind, U2 referenceIndex) {
		this();
		this.referenceKind = referenceKind;
		this.referenceIndex = referenceIndex;
	}
	
	public ConstantMethodHandleInfo() {

	}

	public U1 getReferenceKind() {
		return referenceKind;
	}

	public void setReferenceKind(U1 referenceKind) {
		this.referenceKind = referenceKind;
	}

	public U2 getReferenceIndex() {
		return referenceIndex;
	}

	public void setReferenceIndex(U2 referenceIndex) {
		this.referenceIndex = referenceIndex;
	}
}
