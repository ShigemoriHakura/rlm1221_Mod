// 
// Decompiled by Procyon v0.5.36
// 

package com.reprisesoftware.rlm;

public class RlmTempHandle implements RlmConstants
{
    private static int RLM_TEMP_HANDLE_AKEY;
    private static int RLM_TEMP_HANDLE_COUNT;
    private static int RLM_TEMP_HANDLE_DURATION;
    private static int RLM_TEMP_HANDLE_LICENSE;
    private static int RLM_TEMP_HANDLE_NEW_DURATION;
    private static int RLM_TEMP_HANDLE_SOURCE;
    private static int RLM_TEMP_HANDLE_TYPE;
    private static int RLM_TEMP_HANDLE_URL;
    private static int RLM_TEMP_HANDLE_WINDOW;
    private long tempHandleL;
    private long rlmHandleL;
    private RlmHandle rlmHandle;
    
    private static native long rlmTempNewHandle(final long p0);
    
    private static native void rlmTempDestroyHandle(final long p0);
    
    private static native int rlmTempSetHandle(final long p0, final int p1, final String p2);
    
    private static native int rlmTempSetHandleInt(final long p0, final int p1, final int p2);
    
    private static native int rlmTempSetHandleLong(final long p0, final int p1, final long p2);
    
    private static native int rlmTempCreateLicense(final long p0, final long p1);
    
    private static native int rlmTempReturnLicense(final long p0);
    
    public RlmTempHandle(final RlmHandle rh) {
        this.rlmHandle = rh;
        this.rlmHandleL = rh.getHandle();
        this.tempHandleL = rlmTempNewHandle(this.rlmHandleL);
    }
    
    public void create() throws RlmException {
        final int stat = rlmTempCreateLicense(this.rlmHandleL, this.tempHandleL);
        if (stat != 0) {
            throw new RlmException(stat, this.rlmHandle);
        }
    }
    
    public void returnLicense(final RlmLicense tempLicense) throws RlmException {
        final int stat = rlmTempReturnLicense(tempLicense.getLicenseHandle());
        if (stat != 0) {
            throw new RlmException(stat, this.rlmHandle);
        }
    }
    
    public void setNewDuration(final int minutes) throws RlmException {
        final int stat = rlmTempSetHandleInt(this.tempHandleL, RlmTempHandle.RLM_TEMP_HANDLE_NEW_DURATION, minutes);
        if (stat != 0) {
            throw new RlmException(stat, this.rlmHandle);
        }
    }
    
    public void setDuration(final int minutes) throws RlmException {
        final int stat = rlmTempSetHandleInt(this.tempHandleL, RlmTempHandle.RLM_TEMP_HANDLE_DURATION, minutes);
        if (stat != 0) {
            throw new RlmException(stat, this.rlmHandle);
        }
    }
    
    public void setLicense(final RlmLicense license) throws RlmException {
        final int stat = rlmTempSetHandleLong(this.tempHandleL, RlmTempHandle.RLM_TEMP_HANDLE_LICENSE, license.getLicenseHandle());
        if (stat != 0) {
            throw new RlmException(stat, this.rlmHandle);
        }
    }
    
    public void setLicenseType(final int type) throws RlmException {
        final int stat = rlmTempSetHandleInt(this.tempHandleL, RlmTempHandle.RLM_TEMP_HANDLE_TYPE, type);
        if (stat != 0) {
            throw new RlmException(stat, this.rlmHandle);
        }
    }
    
    public void setWindow(final int minutes) throws RlmException {
        final int stat = rlmTempSetHandleInt(this.tempHandleL, RlmTempHandle.RLM_TEMP_HANDLE_WINDOW, minutes);
        if (stat != 0) {
            throw new RlmException(stat, this.rlmHandle);
        }
    }
    
    protected long getHandle() {
        return this.tempHandleL;
    }
    
    @Override
    protected void finalize() {
        rlmTempDestroyHandle(this.tempHandleL);
    }
    
    static {
        RlmTempHandle.RLM_TEMP_HANDLE_AKEY = 1;
        RlmTempHandle.RLM_TEMP_HANDLE_COUNT = 2;
        RlmTempHandle.RLM_TEMP_HANDLE_DURATION = 3;
        RlmTempHandle.RLM_TEMP_HANDLE_LICENSE = 4;
        RlmTempHandle.RLM_TEMP_HANDLE_NEW_DURATION = 5;
        RlmTempHandle.RLM_TEMP_HANDLE_SOURCE = 6;
        RlmTempHandle.RLM_TEMP_HANDLE_TYPE = 7;
        RlmTempHandle.RLM_TEMP_HANDLE_URL = 8;
        RlmTempHandle.RLM_TEMP_HANDLE_WINDOW = 9;
    }
}
