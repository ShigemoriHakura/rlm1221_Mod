// 
// Decompiled by Procyon v0.5.36
// 

package com.reprisesoftware.rlm;

public class RlmException extends Exception
{
    private int code;
    RlmHandle handle;
    RlmLicense license;
    String message;
    
    private native void rlmErrstring(final long p0, final long p1, final byte[] p2);
    
    protected RlmException(final int code) {
        this.code = code;
    }
    
    protected RlmException(final int code, final RlmHandle handle, final RlmLicense license) {
        this.handle = handle;
        this.license = license;
        this.code = code;
    }
    
    protected RlmException(final int code, final RlmHandle handle) {
        this.handle = handle;
        this.license = null;
        this.code = code;
    }
    
    public int getCode() {
        return this.code;
    }
    
    @Override
    public String getMessage() {
        String ret = null;
        if (this.handle == null && this.license == null) {
            ret = new String("RlmException " + this.code);
        }
        else {
            final byte[] errString = new byte[513];
            long h = 0L;
            long l = 0L;
            if (this.handle != null) {
                h = this.handle.getHandle();
            }
            if (this.license != null) {
                l = this.license.getLicenseHandle();
            }
            this.rlmErrstring(h, l, errString);
            ret = new String(errString).trim();
        }
        return ret;
    }
}
