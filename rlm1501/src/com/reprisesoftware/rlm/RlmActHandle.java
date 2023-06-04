// 
// Decompiled by Procyon v0.5.36
// 

package com.reprisesoftware.rlm;

public class RlmActHandle implements RlmConstants
{
    private static int RLM_ACT_HANDLE_ISV;
    private static int RLM_ACT_HANDLE_HOSTID_LIST;
    private static int RLM_ACT_HANDLE_HOSTNAME;
    private static int RLM_ACT_HANDLE_EXTRA;
    private static int RLM_ACT_HANDLE_LOG;
    private static int RLM_ACT_HANDLE_REHOST;
    private static int RLM_ACT_HANDLE_DISCONN;
    private static int RLM_ACT_HANDLE_PRODUCT;
    private static int RLM_ACT_HANDLE_CONTACT;
    private static int RLM_ACT_HANDLE_COMPANY;
    private static int RLM_ACT_HANDLE_EMAIL;
    private static int RLM_ACT_HANDLE_STATE;
    private static int RLM_ACT_HANDLE_COUNTRY;
    private static int RLM_ACT_HANDLE_U1;
    private static int RLM_ACT_HANDLE_U2;
    private long actHandleL;
    private long rlmHandleL;
    private RlmHandle rlmHandle;
    
    private static native long rlmActNewHandle(final long p0);
    
    private static native void rlmActDestroyHandle(final long p0);
    
    private static native int rlmActSetHandle(final long p0, final int p1, final String p2);
    
    private static native int rlmActSetHandleInt(final long p0, final int p1, final int p2);
    
    public RlmActHandle(final RlmHandle rh) {
        this.rlmHandle = rh;
        this.rlmHandleL = rh.getHandle();
        this.actHandleL = rlmActNewHandle(this.rlmHandleL);
    }
    
    public void setExtra(final String extra) throws RlmException {
        final int stat = rlmActSetHandle(this.actHandleL, RlmActHandle.RLM_ACT_HANDLE_EXTRA, extra);
        if (stat != 0) {
            throw new RlmException(stat, this.rlmHandle);
        }
    }
    
    public void setHostidList(final String hostidList) throws RlmException {
        final int stat = rlmActSetHandle(this.actHandleL, RlmActHandle.RLM_ACT_HANDLE_HOSTID_LIST, hostidList);
        if (stat != 0) {
            throw new RlmException(stat, this.rlmHandle);
        }
    }
    
    public void setHostname(final String hostname) throws RlmException {
        final int stat = rlmActSetHandle(this.actHandleL, RlmActHandle.RLM_ACT_HANDLE_HOSTNAME, hostname);
        if (stat != 0) {
            throw new RlmException(stat, this.rlmHandle);
        }
    }
    
    public void setLogString(final String logString) throws RlmException {
        final int stat = rlmActSetHandle(this.actHandleL, RlmActHandle.RLM_ACT_HANDLE_LOG, logString);
        if (stat != 0) {
            throw new RlmException(stat, this.rlmHandle);
        }
    }
    
    public void setISV(final String ISV) throws RlmException {
        final int stat = rlmActSetHandle(this.actHandleL, RlmActHandle.RLM_ACT_HANDLE_ISV, ISV);
        if (stat != 0) {
            throw new RlmException(stat, this.rlmHandle);
        }
    }
    
    public void setRehostable(final boolean rehostable) {
        rlmActSetHandleInt(this.actHandleL, RlmActHandle.RLM_ACT_HANDLE_REHOST, rehostable ? 1 : 0);
    }
    
    public void setCustomerInfo(final String contact, final String company, final String email, final String state, final String country, final String u1, final String u2) throws RlmException {
        int stat = rlmActSetHandle(this.actHandleL, RlmActHandle.RLM_ACT_HANDLE_CONTACT, contact);
        if (stat != 0) {
            throw new RlmException(stat, this.rlmHandle);
        }
        stat = rlmActSetHandle(this.actHandleL, RlmActHandle.RLM_ACT_HANDLE_COMPANY, company);
        if (stat != 0) {
            throw new RlmException(stat, this.rlmHandle);
        }
        if (email != null) {
            stat = rlmActSetHandle(this.actHandleL, RlmActHandle.RLM_ACT_HANDLE_EMAIL, email);
            if (stat != 0) {
                throw new RlmException(stat, this.rlmHandle);
            }
        }
        if (state != null) {
            stat = rlmActSetHandle(this.actHandleL, RlmActHandle.RLM_ACT_HANDLE_STATE, state);
            if (stat != 0) {
                throw new RlmException(stat, this.rlmHandle);
            }
        }
        if (country != null) {
            stat = rlmActSetHandle(this.actHandleL, RlmActHandle.RLM_ACT_HANDLE_COUNTRY, country);
            if (stat != 0) {
                throw new RlmException(stat, this.rlmHandle);
            }
        }
        if (u1 != null) {
            stat = rlmActSetHandle(this.actHandleL, RlmActHandle.RLM_ACT_HANDLE_U1, u1);
            if (stat != 0) {
                throw new RlmException(stat, this.rlmHandle);
            }
        }
        if (u2 != null) {
            stat = rlmActSetHandle(this.actHandleL, RlmActHandle.RLM_ACT_HANDLE_U2, u2);
            if (stat != 0) {
                throw new RlmException(stat, this.rlmHandle);
            }
        }
    }
    
    protected long getHandle() {
        return this.actHandleL;
    }
    
    @Override
    protected void finalize() {
        rlmActDestroyHandle(this.actHandleL);
    }
    
    static {
        RlmActHandle.RLM_ACT_HANDLE_ISV = 1;
        RlmActHandle.RLM_ACT_HANDLE_HOSTID_LIST = 2;
        RlmActHandle.RLM_ACT_HANDLE_HOSTNAME = 3;
        RlmActHandle.RLM_ACT_HANDLE_EXTRA = 4;
        RlmActHandle.RLM_ACT_HANDLE_LOG = 5;
        RlmActHandle.RLM_ACT_HANDLE_REHOST = 6;
        RlmActHandle.RLM_ACT_HANDLE_DISCONN = 7;
        RlmActHandle.RLM_ACT_HANDLE_PRODUCT = 8;
        RlmActHandle.RLM_ACT_HANDLE_CONTACT = 10;
        RlmActHandle.RLM_ACT_HANDLE_COMPANY = 11;
        RlmActHandle.RLM_ACT_HANDLE_EMAIL = 12;
        RlmActHandle.RLM_ACT_HANDLE_STATE = 13;
        RlmActHandle.RLM_ACT_HANDLE_COUNTRY = 14;
        RlmActHandle.RLM_ACT_HANDLE_U1 = 15;
        RlmActHandle.RLM_ACT_HANDLE_U2 = 16;
    }
}
