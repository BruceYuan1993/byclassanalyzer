package com.bruce.byclassanalyzer.constant;

import java.util.Arrays;

import com.bruce.byclassanalyzer.U2;

public class ConstantUtf8Info extends ConstantInfo{
	private U2 length;
	private byte[] data;
	private String value;
	
	
	
	public ConstantUtf8Info(U2 length, byte[] data) {
		this();
		this.length = length;
		this.data = data;
		try {
			value = new String(decodeMUtf8(data), "utf8");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public ConstantUtf8Info() {
		this.tag = ConstantInfo.CONSTANT_UTF8_INFO;
	}
	
	public String getValue(){
		return value;
	}


	private byte[] decodeMUtf8(byte[] src) {
		// TODO Auto-generated method stub
		if (src != null && src.length > 0){
			byte[] bytes = new byte[src.length];
			int skip = 0;
			for (int i = 0; i < src.length; i++) {
				if (src[i] == (byte)0xC0 &&
						i + 1 < src.length && src[i+1] == (byte)0x80){
					bytes[i] = ((byte)0);
					i++;
					skip++;
				}
				else {
					bytes[i] = src[i];
				}
			}
			return Arrays.copyOf(bytes, bytes.length - skip);
		}
		return null;
	}
}
