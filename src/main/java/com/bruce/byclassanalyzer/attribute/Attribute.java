package com.bruce.byclassanalyzer.attribute;

import com.bruce.byclassanalyzer.ClassElement;
import com.bruce.byclassanalyzer.Element;
import com.bruce.byclassanalyzer.U2;
import com.bruce.byclassanalyzer.U4;

public class Attribute extends ClassElement{
	public static final String CONSTANTVALUE = "ConstantValue";
	public static final String CODE = "Code";
	public static final String LINENUMBERTABLE = "LineNumberTable";
	public static final String LOCALVARIABLETABLE = "LocalVariableTable";
	public static final String EXCEPTIONS = "Exceptions";
	public static final String SOURCEFILE = "SourceFile";
    public static final String InnerClasses = "InnerClasses";
    public static final String Deprecated = "Deprecated";
    public static final String Synthetic = "Synthetic";
    public static final String StackMapTable = "StackMapTable";
    public static final String Signature = "Signature";

	@Element(index = 1)
	protected U2 attributeNameIndex;

	@Element(index = 2)
	protected U4 attributeLength;

	public U2 getAttributeNameIndex() {
		return attributeNameIndex;
	}
	public void setAttributeNameIndex(U2 attributeNameIndex) {
		this.attributeNameIndex = attributeNameIndex;
	}
	public U4 getAttributeLength() {
		return attributeLength;
	}
	public void setAttributeLength(U4 attributeLength) {
		this.attributeLength = attributeLength;
	}
}
