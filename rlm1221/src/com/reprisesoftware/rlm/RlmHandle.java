// 
// Decompiled by Procyon v0.5.36
// 

package com.reprisesoftware.rlm;

import java.util.Vector;

public class RlmHandle implements RlmConstants
{
    private long handle;
    private boolean previouslyActivated;
    private static final String defaultLibName = "rlm1221";
    
    private static native void rlmPutenv(final String p0);
    
    private native long rlmInit(final String p0, final String p1, final String p2);
    
    private native long rlmInitDisconn(final String p0, final String p1, final String p2, final int p3);
    
    private native int rlmClose(final long p0);
    
    private native int rlmStat(final long p0);
    
    private native int rlmHostID(final long p0, final int p1, final byte[] p2);
    
    private native void rlmAllHostIDs(final long p0, final int p1, final byte[] p2);
    
    private native int rlmRlog(final long p0, final String p1);
    
    private native int rlmDlog(final long p0, final String p1);
    
    private native int rlmDetachedDemo(final long p0, final int p1, final String p2);
    
    private native int rlmDetachedDemoX(final long p0, final String p1, final String p2);
    
    private native void rlmDiagnostics(final long p0, final String p1);
    
    private native long rlmProducts(final long p0, final String p1, final String p2);
    
    private native void rlmProductFirst(final long p0);
    
    private native int rlmProductNext(final long p0);
    
    private native String rlmProductName(final long p0);
    
    private native String rlmProductVersion(final long p0);
    
    private native String rlmProductActKey(final long p0);
    
    private native int rlmProductCount(final long p0);
    
    private native String rlmProductContract(final long p0);
    
    private native String rlmProductCustomer(final long p0);
    
    private native int rlmProductCurrentInUse(final long p0);
    
    private native int rlmProductCurrentResUse(final long p0);
    
    private native int rlmProductExpDays(final long p0);
    
    private native String rlmProductExpiration(final long p0);
    
    private native int rlmProductHostBased(final long p0);
    
    private native String rlmProductHostId(final long p0);
    
    private native int rlmProductHold(final long p0);
    
    private native int rlmProductIsRoaming(final long p0);
    
    private native String rlmProductIssuer(final long p0);
    
    private native int rlmMaxRoam(final long p0);
    
    private native int rlmMaxRoamCount(final long p0);
    
    private native int rlmMaxShare(final long p0);
    
    private native int rlmMinRemove(final long p0);
    
    private native int rlmMinCheckout(final long p0);
    
    private native int rlmMinTimeout(final long p0);
    
    private native int rlmNRes(final long p0);
    
    private native int rlmNRoamAllowed(final long p0);
    
    private native String rlmOptions(final long p0);
    
    private native int rlmCurrentRoam(final long p0);
    
    private native String rlmServer(final long p0);
    
    private native int rlmShare(final long p0);
    
    private native int rlmSoftLimit(final long p0);
    
    private native int rlmTimeout(final long p0);
    
    private native int rlmTimezone(final long p0);
    
    private native int rlmIsTokenBased(final long p0);
    
    private native int rlmType(final long p0);
    
    private native int rlmUserBased(final long p0);
    
    private native int rlmClientCache(final long p0);
    
    private native void rlmSetUser(final long p0, final String p1);
    
    private native void rlmSetHost(final long p0, final String p1);
    
    private native void rlmSetIsvData(final long p0, final String p1);
    
    private native void rlmSkipIsvDown(final long p0);
    
    private native void rlmForgetIsvDown(final long p0);
    
    private native void rlmKeepConn(final long p0);
    
    private native void rlmErrstringNum(final int p0, final byte[] p1);
    
    private native void rlmEnableLogging(final long p0, final int p1);
    
    private native void rlmSetPassword(final long p0, final String p1);
    
    private native void rlmSetRequiredOption(final long p0, final String p1);
    
    private native int rlmActRequest(final long p0, final String p1, final String p2, final String p3, final String p4, final String p5, final int p6, final String p7, final byte[] p8);
    
    private native int rlmActivate(final long p0, final String p1, final String p2, final int p3, final byte[] p4, final long p5);
    
    private native int rlmActRevoke(final long p0, final String p1, final String p2);
    
    private native int rlmActRevokeReference(final long p0, final String p1, final String p2);
    
    private native int rlmActRevokeDisconn(final long p0, final String p1, final String p2, final byte[] p3);
    
    private native int rlmActKeyvalid(final long p0, final String p1, final String p2, final String p3);
    
    private native int rlmActKeyvalidLicense(final long p0, final String p1, final String p2, final String p3, final byte[] p4);
    
    private native int rlmGetRehost(final long p0, final String p1, final byte[] p2);
    
    public void loadLib(final String libName) {
        System.loadLibrary(libName);
    }
    
    private void createHandle(String licLoc, String appPath, String license, final String libName, final String[] env, final int promise) throws RlmException {
        this.loadLib(libName);
        if (env != null) {
            for (int i = 0; i < env.length; ++i) {
                rlmPutenv(env[i]);
            }
        }
        if (licLoc == null) {
            licLoc = "";
        }
        if (appPath == null) {
            appPath = "";
        }
        if (license == null) {
            license = "";
        }
        if (promise > 0) {
            this.handle = this.rlmInitDisconn(licLoc, appPath, license, promise);
        }
        else {
            this.handle = this.rlmInit(licLoc, appPath, license);
        }
        final int stat = this.rlmStat(this.handle);
        if (stat != 0 && stat != -102) {
            throw new RlmException(stat, this);
        }
    }
    
    public RlmHandle(final String licLoc, final String appPath, final String license) throws RlmException {
        this.createHandle(licLoc, appPath, license, "rlm1221", null, 0);
    }
    
    public RlmHandle(final String licLoc, final String appPath, final String license, final int promise) throws RlmException {
        this.createHandle(licLoc, appPath, license, "rlm1221", null, promise);
    }
    
    public RlmHandle(final String licLoc, final String appPath, final String license, final String[] env) throws RlmException {
        this.createHandle(licLoc, appPath, license, "rlm1221", env, 0);
    }
    
    public RlmHandle(final String licLoc, final String appPath, final String license, final String libName) throws RlmException {
        String lib = null;
        if (libName != null && libName.length() > 0) {
            lib = libName;
        }
        else {
            lib = "rlm1221";
        }
        this.createHandle(licLoc, appPath, license, lib, null, 0);
    }
    
    public RlmHandle(final String licLoc, final String appPath, final String license, final String libName, final String[] env) throws RlmException {
        String lib = null;
        if (libName != null && libName.length() > 0) {
            lib = libName;
        }
        else {
            lib = "rlm1221";
        }
        this.createHandle(licLoc, appPath, license, lib, env, 0);
    }
    
    protected long getHandle() {
        return this.handle;
    }
    
    public void close() {
        if (this.handle != 0L) {
            this.rlmClose(this.handle);
        }
        this.handle = 0L;
    }
    
    @Deprecated
    public String getHostID(final int type) {
        final byte[] buf = new byte[76];
        String hid = null;
        final int stat = this.rlmHostID(this.handle, type, buf);
        if (stat == 0) {
            hid = new String(buf);
        }
        return hid;
    }
    
    public String[] getAllHostIDs(final int type) {
        final byte[] buf = new byte[1900];
        this.rlmAllHostIDs(this.handle, type, buf);
        final String all = new String(buf).trim();
        final String[] split = all.split(" ");
        return split;
    }
    
    public void writeReportLog(final String logString) throws RlmException {
        final int stat = this.rlmRlog(this.handle, logString);
        if (stat != 0) {
            throw new RlmException(stat, this);
        }
    }
    
    public void writeDebugLog(final String logString) throws RlmException {
        final int stat = this.rlmDlog(this.handle, logString);
        if (stat != 0) {
            throw new RlmException(stat, this);
        }
    }
    
    public void createDetachedDemo(final int days, final String license) throws RlmException {
        final int stat = this.rlmDetachedDemo(this.handle, days, license);
        if (stat != 0) {
            throw new RlmException(stat, this);
        }
    }
    
    public void removeDetachedDemo(final String product, final String version) throws RlmException {
        final int stat = this.rlmDetachedDemoX(this.handle, product, version);
        if (stat != 0) {
            throw new RlmException(stat, this);
        }
    }
    
    private void addProduct(final long prodHandle, final Vector v, final int index) {
        final RlmAvailableProduct prod = new RlmAvailableProduct();
        prod.setName(this.rlmProductName(prodHandle));
        prod.setVersion(this.rlmProductVersion(prodHandle));
        prod.setActKey(this.rlmProductActKey(prodHandle));
        prod.setCount(this.rlmProductCount(prodHandle));
        prod.setCurrentInUse(this.rlmProductCurrentInUse(prodHandle));
        prod.setCurrentResUse(this.rlmProductCurrentResUse(prodHandle));
        prod.setContract(this.rlmProductContract(prodHandle));
        prod.setCustomer(this.rlmProductCustomer(prodHandle));
        prod.setExpDays(this.rlmProductExpDays(prodHandle));
        prod.setExpiration(this.rlmProductExpiration(prodHandle));
        prod.setHostBased(this.rlmProductHostBased(prodHandle));
        prod.setHostId(this.rlmProductHostId(prodHandle));
        prod.setHold(this.rlmProductHold(prodHandle));
        prod.setIsRoaming(this.rlmProductIsRoaming(prodHandle));
        prod.setIssuer(this.rlmProductIssuer(prodHandle));
        prod.setMaxRoam(this.rlmMaxRoam(prodHandle));
        prod.setMaxRoamCount(this.rlmMaxRoamCount(prodHandle));
        prod.setMaxShare(this.rlmMaxShare(prodHandle));
        prod.setMinRemove(this.rlmMinRemove(prodHandle));
        prod.setMinCheckout(this.rlmMinCheckout(prodHandle));
        prod.setMinTimeout(this.rlmMinTimeout(prodHandle));
        prod.setNRes(this.rlmNRes(prodHandle));
        prod.setNRoamAllowed(this.rlmNRoamAllowed(prodHandle));
        prod.setOptions(this.rlmOptions(prodHandle));
        prod.setCurrentRoam(this.rlmCurrentRoam(prodHandle));
        prod.setServer(this.rlmServer(prodHandle));
        prod.setShare(this.rlmShare(prodHandle));
        prod.setSoftLimit(this.rlmSoftLimit(prodHandle));
        prod.setTimeout(this.rlmTimeout(prodHandle));
        prod.setTimezone(this.rlmTimezone(prodHandle));
        prod.setIsTokenBased(this.rlmIsTokenBased(prodHandle));
        prod.setType(this.rlmType(prodHandle));
        prod.setUserBased(this.rlmUserBased(prodHandle));
        prod.setClientCache(this.rlmClientCache(prodHandle));
        prod.setProdHandle(prodHandle);
        prod.setIndex(index);
        v.add(prod);
    }
    
    public Vector getAvailableProducts(final String product, final String version) {
        Vector v = null;
        final long prodHandle = this.rlmProducts(this.handle, product, version);
        if (prodHandle != 0L) {
            v = new Vector();
            this.rlmProductFirst(prodHandle);
            int i = 0;
            this.addProduct(prodHandle, v, i++);
            while (this.rlmProductNext(prodHandle) == 0) {
                this.addProduct(prodHandle, v, i++);
            }
        }
        return v;
    }
    
    protected void positionProdHandle(final long prodHandle, final int index) {
        this.rlmProductFirst(prodHandle);
        for (int i = 0; i < index; ++i) {
            this.rlmProductNext(prodHandle);
        }
    }
    
    public void setUser(final String user) {
        this.rlmSetUser(this.handle, user);
    }
    
    public void setHost(final String host) {
        this.rlmSetHost(this.handle, host);
    }
    
    public void setIsvData(final String isvData) {
        this.rlmSetIsvData(this.handle, isvData);
    }
    
    public void enableLogging(final int enable) {
        this.rlmEnableLogging(this.handle, enable);
    }
    
    public void setPassword(final String password) {
        this.rlmSetPassword(this.handle, password);
    }
    
    public void setOption(final String option) {
        this.rlmSetRequiredOption(this.handle, option);
    }
    
    public void skipIsvDown() {
        this.rlmSkipIsvDown(this.handle);
    }
    
    public void forgetIsvDown() {
        this.rlmForgetIsvDown(this.handle);
    }
    
    public void keepConn() {
        this.rlmKeepConn(this.handle);
    }
    
    public String actRequest(final String url, String isv, final String key, String hostidList, String hostName, final int count, String extra) throws RlmException {
        final byte[] buf = new byte[102400];
        if (isv == null) {
            isv = "";
        }
        if (hostidList == null) {
            hostidList = "";
        }
        if (hostName == null) {
            hostName = "";
        }
        if (extra == null) {
            extra = "";
        }
        final int stat = this.rlmActRequest(this.handle, url, isv, key, hostidList, hostName, count, extra, buf);
        if (stat < 0) {
            throw new RlmException(stat, this);
        }
        this.previouslyActivated = (stat == 1);
        return new String(buf).trim();
    }
    
    public String activateLicense(final String url, final String key, final int count, final RlmActHandle actHandle) throws RlmException {
        final byte[] buf = new byte[102400];
        long ah;
        if (actHandle == null) {
            ah = 0L;
        }
        else {
            ah = actHandle.getHandle();
        }
        final int stat = this.rlmActivate(this.handle, url, key, count, buf, ah);
        if (stat < 0) {
            throw new RlmException(stat, this);
        }
        this.previouslyActivated = (stat == 1);
        return new String(buf).trim();
    }
    
    public void revokeLicense(final String url, final String product) throws RlmException {
        final int stat = this.rlmActRevoke(this.handle, url, product);
        if (stat != 0) {
            throw new RlmException(stat, this);
        }
    }
    
    public void revokeLicenseReference(final String url, final String product) throws RlmException {
        final int stat = this.rlmActRevokeReference(this.handle, url, product);
        if (stat != 0) {
            throw new RlmException(stat, this);
        }
    }
    
    public String disconnectedRevoke(final String product) throws RlmException {
        final byte[] retval = new byte[1025];
        final int stat = this.rlmActRevokeDisconn(this.handle, "", product, retval);
        if (stat != 0) {
            throw new RlmException(stat, this);
        }
        return new String(retval).trim();
    }
    
    public void processDisconnectedRevoke(final String url, final String verifyCode) throws RlmException {
        final int stat = this.rlmActRevokeDisconn(this.handle, url, verifyCode, null);
        if (stat != 0) {
            throw new RlmException(stat, this);
        }
    }
    
    public boolean actKeyValid(final String url, final String actKey, final String hostID) throws RlmException {
        final int stat = this.rlmActKeyvalid(this.handle, url, actKey, hostID);
        if (stat != 0) {
            throw new RlmException(stat, this);
        }
        return true;
    }
    
    public String actKeyValidLicense(final String url, final String actKey, final String hostID) throws RlmException {
        final byte[] buf = new byte[102400];
        final int stat = this.rlmActKeyvalidLicense(this.handle, url, actKey, hostID, buf);
        if (stat != 0) {
            throw new RlmException(stat, this);
        }
        return new String(buf).trim();
    }
    
    public boolean previouslyActivated() {
        return this.previouslyActivated;
    }
    
    public String getRehost(final String product) {
        String ret = null;
        final byte[] hostid = new byte[77];
        final int stat = this.rlmGetRehost(this.handle, product, hostid);
        if (stat == 0) {
            ret = new String(hostid).trim();
        }
        return ret;
    }
    
    public void doClientSideDiagnostics(final String diagFile) {
        this.rlmDiagnostics(this.handle, diagFile);
    }
    
    @Override
    protected void finalize() {
        this.close();
    }
    
    public String getMessageByCode(final int code) {
        String ret = null;
        final byte[] errString = new byte[513];
        this.rlmErrstringNum(code, errString);
        ret = new String(errString).trim();
        return ret;
    }
}
