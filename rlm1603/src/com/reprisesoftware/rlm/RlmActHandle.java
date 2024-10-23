package com.reprisesoftware.rlm;

public class RlmActHandle implements RlmConstants {
    private static int RLM_ACT_HANDLE_ISV = 1;
    private static int RLM_ACT_HANDLE_HOSTID_LIST = 2;
    private static int RLM_ACT_HANDLE_HOSTNAME = 3;
    private static int RLM_ACT_HANDLE_EXTRA = 4;
    private static int RLM_ACT_HANDLE_LOG = 5;
    private static int RLM_ACT_HANDLE_REHOST = 6;
    private static int RLM_ACT_HANDLE_DISCONN = 7;
    private static int RLM_ACT_HANDLE_PRODUCT = 8;
    private static int RLM_ACT_HANDLE_CONTACT = 10;
    private static int RLM_ACT_HANDLE_COMPANY = 11;
    private static int RLM_ACT_HANDLE_EMAIL = 12;
    private static int RLM_ACT_HANDLE_STATE = 13;
    private static int RLM_ACT_HANDLE_COUNTRY = 14;
    private static int RLM_ACT_HANDLE_U1 = 15;
    private static int RLM_ACT_HANDLE_U2 = 16;
    private long actHandleL;
    private long rlmHandleL;
    private RlmHandle rlmHandle;

    private static native long rlmActNewHandle(long var0);

    private static native void rlmActDestroyHandle(long var0);

    private static native int rlmActSetHandle(long var0, int var2, String var3);

    private static native int rlmActSetHandleInt(long var0, int var2, int var3);

    public RlmActHandle(RlmHandle rh) {
        this.rlmHandle = rh;
        this.rlmHandleL = rh.getHandle();
        this.actHandleL = rlmActNewHandle(this.rlmHandleL);
    }

    public void setExtra(String extra) throws RlmException {
        int stat = rlmActSetHandle(this.actHandleL, RLM_ACT_HANDLE_EXTRA, extra);
        if (stat != 0) {
            throw new RlmException(stat, this.rlmHandle);
        }
    }

    public void setHostidList(String hostidList) throws RlmException {
        int stat = rlmActSetHandle(this.actHandleL, RLM_ACT_HANDLE_HOSTID_LIST, hostidList);
        if (stat != 0) {
            throw new RlmException(stat, this.rlmHandle);
        }
    }

    public void setHostname(String hostname) throws RlmException {
        int stat = rlmActSetHandle(this.actHandleL, RLM_ACT_HANDLE_HOSTNAME, hostname);
        if (stat != 0) {
            throw new RlmException(stat, this.rlmHandle);
        }
    }

    public void setLogString(String logString) throws RlmException {
        int stat = rlmActSetHandle(this.actHandleL, RLM_ACT_HANDLE_LOG, logString);
        if (stat != 0) {
            throw new RlmException(stat, this.rlmHandle);
        }
    }

    public void setISV(String ISV) throws RlmException {
        int stat = rlmActSetHandle(this.actHandleL, RLM_ACT_HANDLE_ISV, ISV);
        if (stat != 0) {
            throw new RlmException(stat, this.rlmHandle);
        }
    }

    public void setRehostable(boolean rehostable) {
        rlmActSetHandleInt(this.actHandleL, RLM_ACT_HANDLE_REHOST, rehostable ? 1 : 0);
    }

    public void setCustomerInfo(String contact, String company, String email, String state, String country, String u1, String u2) throws RlmException {
        int stat = rlmActSetHandle(this.actHandleL, RLM_ACT_HANDLE_CONTACT, contact);
        if (stat != 0) {
            throw new RlmException(stat, this.rlmHandle);
        } else {
            stat = rlmActSetHandle(this.actHandleL, RLM_ACT_HANDLE_COMPANY, company);
            if (stat != 0) {
                throw new RlmException(stat, this.rlmHandle);
            } else {
                if (email != null) {
                    stat = rlmActSetHandle(this.actHandleL, RLM_ACT_HANDLE_EMAIL, email);
                    if (stat != 0) {
                        throw new RlmException(stat, this.rlmHandle);
                    }
                }

                if (state != null) {
                    stat = rlmActSetHandle(this.actHandleL, RLM_ACT_HANDLE_STATE, state);
                    if (stat != 0) {
                        throw new RlmException(stat, this.rlmHandle);
                    }
                }

                if (country != null) {
                    stat = rlmActSetHandle(this.actHandleL, RLM_ACT_HANDLE_COUNTRY, country);
                    if (stat != 0) {
                        throw new RlmException(stat, this.rlmHandle);
                    }
                }

                if (u1 != null) {
                    stat = rlmActSetHandle(this.actHandleL, RLM_ACT_HANDLE_U1, u1);
                    if (stat != 0) {
                        throw new RlmException(stat, this.rlmHandle);
                    }
                }

                if (u2 != null) {
                    stat = rlmActSetHandle(this.actHandleL, RLM_ACT_HANDLE_U2, u2);
                    if (stat != 0) {
                        throw new RlmException(stat, this.rlmHandle);
                    }
                }

            }
        }
    }

    protected long getHandle() {
        return this.actHandleL;
    }

    protected void finalize() {
        rlmActDestroyHandle(this.actHandleL);
    }
}
