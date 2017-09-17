package com.bruce.byclassanalyzer;

public abstract class ClassDataProvider {
	private long position;

	protected abstract byte[] readBytesInternal(int len);

	public byte[] readBytes(int len){
        byte[] result = readBytesInternal(len);
        position += len;
		return result;
	}

	U1 readU1() {
		return new U1(readBytes(1));
	}

	U2 readU2() {
		return new U2(readBytes(2));
	}
	
	U4 readU4() {
		return new U4(readBytes(4));
	}
	
	U8 readU8() {
		return new U8(readBytes(8));
	}

	public long getPosition() {
		return position;
	}
}
