package com.reprisesoftware.rlm;

public class RlmException extends Exception {
    private int code;
    RlmHandle handle;
    RlmLicense license;
    String message;

    private native void rlmErrstring(long var1, long var3, byte[] var5);

    protected RlmException(int code) {
        this.code = code;
    }

    protected RlmException(int code, RlmHandle handle, RlmLicense license) {
        this.handle = handle;
        this.license = license;
        this.code = code;
    }

    protected RlmException(int code, RlmHandle handle) {
        this.handle = handle;
        this.license = null;
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        String ret = null;
        if (this.handle == null && this.license == null) {
            ret = new String("RlmException " + this.code);
        } else {
            byte[] errString = new byte[513];
            long h = 0L;
            long l = 0L;
            if (this.handle != null) {
                h = this.handle.getHandle();
            }

            if (this.license != null) {
                l = this.license.getLicenseHandle();
            }

            this.rlmErrstring(h, l, errString);
            ret = (new String(errString)).trim();
        }

        return ret;
    }
}
