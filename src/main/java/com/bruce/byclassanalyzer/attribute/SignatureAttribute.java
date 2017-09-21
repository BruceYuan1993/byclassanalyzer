package com.bruce.byclassanalyzer.attribute;

import com.bruce.byclassanalyzer.Element;
import com.bruce.byclassanalyzer.U2;

/**
 * Created by bruceyuan on 17-9-21.
 */
public class SignatureAttribute extends Attribute {
    @Element(index = 3)
    private U2 signatureIndex;
}
