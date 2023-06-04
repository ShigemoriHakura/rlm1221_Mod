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
    }
}
