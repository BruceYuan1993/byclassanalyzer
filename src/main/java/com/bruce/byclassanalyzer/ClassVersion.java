package com.bruce.byclassanalyzer;

/**
 * Created by bruceyuan on 17-9-17.
 */
public class ClassVersion extends ClassElement{

    @ClassMember(index = 1)
    private U2 minorVersion;

    @ClassMember(index = 2)
    private U2 majorVersion;

    public ClassVersion() {

    }

    public ClassVersion(U2 majorVersion, U2 minorVersion) {
        this.majorVersion = majorVersion;
        this.minorVersion = minorVersion;
    }

    public void setMinorVersion(U2 minorVersion) {
        this.minorVersion = minorVersion;
    }

    public void setMajorVersion(U2 majorVersion) {
        this.majorVersion = majorVersion;
    }

    public U2 getMinorVersion() {
        return minorVersion;
    }

    public U2 getMajorVersion() {
        return majorVersion;
    }




    @Override
    public String toString() {
        return majorVersion + "." + minorVersion;
    }
}
