package com.reprisesoftware.rlm;

import java.util.Vector;

public class RlmHandle implements RlmConstants {
    private long handle;
    private boolean previouslyActivated;
    private static final String defaultLibName = "rlm1603";
    private Vector productHandleList = null;

    private static native void rlmPutenv(String var0);

    private native long rlmInit(String var1, String var2, String var3);

    private native long rlmInitDisconn(String var1, String var2, String var3, int var4);

    private native int rlmClose(long var1);

    private native int rlmStat(long var1);

    private native int rlmHostID(long var1, int var3, byte[] var4);

    private native void rlmAllHostIDs(long var1, int var3, byte[] var4);

    private native int rlmRlog(long var1, String var3);

    private native int rlmDlog(long var1, String var3);

    private native int rlmDetachedDemo(long var1, int var3, String var4);

    private native int rlmDetachedDemoX(long var1, String var3, String var4);

    private native void rlmDiagnostics(long var1, String var3);

    private native long rlmProducts(long var1, String var3, String var4);

    private native void rlmProductFirst(long var1);

    private native int rlmProductNext(long var1);

    private native void rlmProductFree(long var1);

    private native String rlmProductName(long var1);

    private native String rlmProductVersion(long var1);

    private native String rlmProductActKey(long var1);

    private native int rlmProductCount(long var1);

    private native String rlmProductContract(long var1);

    private native String rlmProductCustomer(long var1);

    private native int rlmProductCurrentInUse(long var1);

    private native int rlmProductCurrentResUse(long var1);

    private native int rlmProductExpDays(long var1);

    private native String rlmProductExpTime(long var1);

    private native String rlmProductExpiration(long var1);

    private native int rlmProductHostBased(long var1);

    private native String rlmProductHostId(long var1);

    private native int rlmProductHold(long var1);

    private native int rlmProductIsAlias(long var1);

    private native int rlmProductIsFloating(long var1);

    private native int rlmProductIsNodelocked(long var1);

    private native int rlmProductIsRoaming(long var1);

    private native int rlmProductIsMetered(long var1);

    private native int rlmProductIsSingle(long var1);

    private native String rlmProductIssuer(long var1);

    private native int rlmMaxRoam(long var1);

    private native int rlmMaxRoamCount(long var1);

    private native int rlmProductMeterCounter(long var1);

    private native int rlmMeterCurCount(long var1);

    private native int rlmMaxShare(long var1);

    private native int rlmMinRemove(long var1);

    private native int rlmMinCheckout(long var1);

    private native int rlmMinTimeout(long var1);

    private native int rlmProductNamedUserCount(long var1);

    private native int rlmNRes(long var1);

    private native int rlmNRoamAllowed(long var1);

    private native String rlmOptions(long var1);

    private native int rlmCurrentRoam(long var1);

    private native String rlmServer(long var1);

    private native int rlmShare(long var1);

    private native int rlmSoftLimit(long var1);

    private native String rlmProductStart(long var1);

    private native int rlmTimeout(long var1);

    private native int rlmTimezone(long var1);

    private native int rlmIsTokenBased(long var1);

    private native int rlmType(long var1);

    private native int rlmUserBased(long var1);

    private native int rlmClientCache(long var1);

    private native void rlmSetUser(long var1, String var3);

    private native void rlmSetHost(long var1, String var3);

    private native void rlmSetIsvData(long var1, String var3);

    private native void rlmSkipIsvDown(long var1);

    private native void rlmForgetIsvDown(long var1);

    private native void rlmKeepConn(long var1);

    private native void rlmErrstringNum(int var1, byte[] var2);

    private native void rlmEnableLogging(long var1, int var3);

    private native void rlmSetPassword(long var1, String var3);

    private native void rlmSetRequiredOption(long var1, String var3);

    private native int rlmActRequest(long var1, String var3, String var4, String var5, String var6, String var7, int var8, String var9, byte[] var10);

    private native int rlmActivate(long var1, String var3, String var4, int var5, byte[] var6, long var7);

    private native int rlmActRevoke(long var1, String var3, String var4);

    private native int rlmActRevokeReference(long var1, String var3, String var4);

    private native int rlmActRevokeDisconn(long var1, String var3, String var4, byte[] var5);

    private native int rlmActRevokeRehost(long var1, String var3, String var4, int var5);

    private native int rlmActKeyvalid(long var1, String var3, String var4, String var5);

    private native int rlmActKeyvalidLicense(long var1, String var3, String var4, String var5, byte[] var6);

    private native int rlmGetRehost(long var1, String var3, byte[] var4);

    private native void rlmSetReferenceHostid(long var1, String var3);

    public void loadLib(String libName) {
        System.loadLibrary(libName);
    }

    private void createHandle(String licLoc, String appPath, String license, String libName, String[] env, int promise) throws RlmException {
        this.loadLib(libName);
        int stat;
        if (env != null) {
            for (stat = 0; stat < env.length; ++stat) {
                rlmPutenv(env[stat]);
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
        } else {
            this.handle = this.rlmInit(licLoc, appPath, license);
        }

        stat = this.rlmStat(this.handle);
        if (stat != 0 && stat != -102) {
            throw new RlmException(stat, this);
        }
    }

    public RlmHandle(String licLoc, String appPath, String license) throws RlmException {
        this.createHandle(licLoc, appPath, license, "rlm1603", (String[]) null, 0);
    }

    public RlmHandle(String licLoc, String appPath, String license, int promise) throws RlmException {
        this.createHandle(licLoc, appPath, license, "rlm1603", (String[]) null, promise);
    }

    public RlmHandle(String licLoc, String appPath, String license, String[] env) throws RlmException {
        this.createHandle(licLoc, appPath, license, "rlm1603", env, 0);
    }

    public RlmHandle(String licLoc, String appPath, String license, String libName) throws RlmException {
        String lib = null;
        if (libName != null && libName.length() > 0) {
            lib = libName;
        } else {
            lib = "rlm1603";
        }

        this.createHandle(licLoc, appPath, license, lib, (String[]) null, 0);
    }

    public RlmHandle(String licLoc, String appPath, String license, String libName, String[] env) throws RlmException {
        String lib = null;
        if (libName != null && libName.length() > 0) {
            lib = libName;
        } else {
            lib = "rlm1603";
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

    public static void putenv(String nvp) {
        rlmPutenv(nvp);
    }

    public String getHostID(int type) {
        byte[] buf = new byte[76];
        String hid = null;
        int stat = this.rlmHostID(this.handle, type, buf);
        if (stat == 0) {
            hid = new String(buf);
        }

        return hid;
    }

    public String[] getAllHostIDs(int type) {
        byte[] buf = new byte[1900];
        this.rlmAllHostIDs(this.handle, type, buf);
        String all = (new String(buf)).trim();
        String[] split = all.split(" ");
        return split;
    }

    public void writeReportLog(String logString) throws RlmException {
        int stat = this.rlmRlog(this.handle, logString);
        if (stat != 0) {
            throw new RlmException(stat, this);
        }
    }

    public void writeDebugLog(String logString) throws RlmException {
        int stat = this.rlmDlog(this.handle, logString);
        if (stat != 0) {
            throw new RlmException(stat, this);
        }
    }

    public void createDetachedDemo(int days, String license) throws RlmException {
        int stat = this.rlmDetachedDemo(this.handle, days, license);
        if (stat != 0) {
            throw new RlmException(stat, this);
        }
    }

    public void removeDetachedDemo(String product, String version) throws RlmException {
        int stat = this.rlmDetachedDemoX(this.handle, product, version);
        if (stat != 0) {
            throw new RlmException(stat, this);
        }
    }

    private void addProduct(final long prodHandle, final Vector v, final int index) {
        RlmAvailableProduct prod = new RlmAvailableProduct();
        System.out.println("[ShiroSaki] addProduct also RIP~");
        prod.setName("live2d_editorc-3");
        prod.setVersion("3.0");
        prod.setActKey("CHCC-1234-5678-9012-1234");
        prod.setCount(0);
        prod.setCurrentInUse(0);
        prod.setCurrentResUse(0);
        prod.setContract("LiveDDDDDDDDD");
        prod.setCustomer("My love~");
        prod.setExpDays(0);
        //prod.setExpTime("");
        prod.setExpiration("permanent");
        prod.setHostBased(0);
        prod.setHostId("ANY");
        prod.setHold(0);
        prod.setIsAlias(0);
        prod.setIsFloating(0);
        prod.setIsMetered(0);
        prod.setIsNodelocked(0);
        prod.setIsRoaming(0);
        prod.setIsSingle(0);
        prod.setIssuer("ShiroSaki");
        prod.setMaxRoam(0);
        prod.setMaxRoamCount(0);
        prod.setMeterCounter(0);
        prod.setMeterCurCount(0);
        prod.setMaxShare(99);
        prod.setMinRemove(0);
        prod.setMinCheckout(0);
        prod.setMinTimeout(0);
        prod.setNamedUserCount(0);
        prod.setNRes(0);
        prod.setNRoamAllowed(0);
        prod.setOptions("");
        prod.setCurrentRoam(0);
        prod.setServer("127.0.0.1");
        prod.setShare(0);
        prod.setSoftLimit(0);
        prod.setStart("");
        prod.setTimeout(0);
        prod.setTimezone(0);
        prod.setIsTokenBased(0);
        prod.setType(0);
        prod.setUserBased(0);
        prod.setClientCache(0);
        prod.setProdHandle(prodHandle);
        prod.setIndex(index);
        v.add(prod);
        /*
      RlmAvailableProduct prod = new RlmAvailableProduct();
      prod.setName(this.rlmProductName(prodHandle));
      prod.setVersion(this.rlmProductVersion(prodHandle));
      prod.setActKey(this.rlmProductActKey(prodHandle));
      prod.setCount(this.rlmProductCount(prodHandle));
      prod.setCurrentInUse(this.rlmProductCurrentInUse(prodHandle));
      prod.setCurrentResUse(this.rlmProductCurrentResUse(prodHandle));
      prod.setContract(this.rlmProductContract(prodHandle));
      prod.setCustomer(this.rlmProductCustomer(prodHandle));
      prod.setExpDays(this.rlmProductExpDays(prodHandle));
      prod.setExpTime(this.rlmProductExpTime(prodHandle));
      prod.setExpiration(this.rlmProductExpiration(prodHandle));
      prod.setHostBased(this.rlmProductHostBased(prodHandle));
      prod.setHostId(this.rlmProductHostId(prodHandle));
      prod.setHold(this.rlmProductHold(prodHandle));
      prod.setIsAlias(this.rlmProductIsAlias(prodHandle));
      prod.setIsFloating(this.rlmProductIsFloating(prodHandle));
      prod.setIsMetered(this.rlmProductIsMetered(prodHandle));
      prod.setIsNodelocked(this.rlmProductIsNodelocked(prodHandle));
      prod.setIsRoaming(this.rlmProductIsRoaming(prodHandle));
      prod.setIsSingle(this.rlmProductIsSingle(prodHandle));
      prod.setIssuer(this.rlmProductIssuer(prodHandle));
      prod.setMaxRoam(this.rlmMaxRoam(prodHandle));
      prod.setMaxRoamCount(this.rlmMaxRoamCount(prodHandle));
      prod.setMeterCounter(this.rlmProductMeterCounter(prodHandle));
      prod.setMeterCurCount(this.rlmMeterCurCount(prodHandle));
      prod.setMaxShare(this.rlmMaxShare(prodHandle));
      prod.setMinRemove(this.rlmMinRemove(prodHandle));
      prod.setMinCheckout(this.rlmMinCheckout(prodHandle));
      prod.setMinTimeout(this.rlmMinTimeout(prodHandle));
      prod.setNamedUserCount(this.rlmProductNamedUserCount(prodHandle));
      prod.setNRes(this.rlmNRes(prodHandle));
      prod.setNRoamAllowed(this.rlmNRoamAllowed(prodHandle));
      prod.setOptions(this.rlmOptions(prodHandle));
      prod.setCurrentRoam(this.rlmCurrentRoam(prodHandle));
      prod.setServer(this.rlmServer(prodHandle));
      prod.setShare(this.rlmShare(prodHandle));
      prod.setSoftLimit(this.rlmSoftLimit(prodHandle));
      prod.setStart(this.rlmProductStart(prodHandle));
      prod.setTimeout(this.rlmTimeout(prodHandle));
      prod.setTimezone(this.rlmTimezone(prodHandle));
      prod.setIsTokenBased(this.rlmIsTokenBased(prodHandle));
      prod.setType(this.rlmType(prodHandle));
      prod.setUserBased(this.rlmUserBased(prodHandle));
      prod.setClientCache(this.rlmClientCache(prodHandle));
      prod.setProdHandle(prodHandle);
      prod.setIndex(index);
      v.add(prod);*/
    }

    public Vector getAvailableProducts(String product, String version) {
        System.out.println("[ShiroSaki] getAvailableProducts has gone, RIP~");
        Vector vector = null;
        vector = new Vector();
        long l = 1L;
        addProduct(l, vector, 1);
        return vector;
       /*
      Vector v = null;
      long prodHandle = this.rlmProducts(this.handle, product, version);
      if (prodHandle != 0L) {
         v = new Vector();
         this.rlmProductFirst(prodHandle);
         int i = 0;
         int var8 = i + 1;
         this.addProduct(prodHandle, v, i);

         while(this.rlmProductNext(prodHandle) == 0) {
            this.addProduct(prodHandle, v, var8++);
         }

         if (this.productHandleList == null) {
            this.productHandleList = new Vector();
         }

         Long l = new Long(prodHandle);
         this.productHandleList.add(l);
      }

      return v;*/
    }

    protected void positionProdHandle(long prodHandle, int index) {
        this.rlmProductFirst(prodHandle);

        for (int i = 0; i < index; ++i) {
            this.rlmProductNext(prodHandle);
        }

    }

    public void setUser(String user) {
        this.rlmSetUser(this.handle, user);
    }

    public void setHost(String host) {
        this.rlmSetHost(this.handle, host);
    }

    public void setIsvData(String isvData) {
        this.rlmSetIsvData(this.handle, isvData);
    }

    public void enableLogging(int enable) {
        this.rlmEnableLogging(this.handle, enable);
    }

    public void setPassword(String password) {
        this.rlmSetPassword(this.handle, password);
    }

    public void setOption(String option) {
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

    public String actRequest(String url, String isv, String key, String hostidList, String hostName, int count, String extra) throws RlmException {
        byte[] buf = new byte[102400];
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

        int stat = this.rlmActRequest(this.handle, url, isv, key, hostidList, hostName, count, extra, buf);
        if (stat < 0) {
            throw new RlmException(stat, this);
        } else {
            this.previouslyActivated = stat == 1;
            return (new String(buf)).trim();
        }
    }

    public String activateLicense(String url, String key, int count, RlmActHandle actHandle) throws RlmException {
        return "[ShiroSaki] Cracked";
      /*byte[] buf = new byte[102400];
      long ah;
      if (actHandle == null) {
         ah = 0L;
      } else {
         ah = actHandle.getHandle();
      }

      int stat = this.rlmActivate(this.handle, url, key, count, buf, ah);
      if (stat < 0) {
         throw new RlmException(stat, this);
      } else {
         this.previouslyActivated = stat == 1;
         return (new String(buf)).trim();
      }*/
    }

    public void revokeRehostable(String url, String product, int flags) throws RlmException {
        int stat = this.rlmActRevokeRehost(this.handle, url, product, flags);
        if (stat != 0) {
            throw new RlmException(stat, this);
        }
    }

    /**
     * @deprecated
     */
    public void revokeLicense(String url, String product) throws RlmException {
        int stat = this.rlmActRevoke(this.handle, url, product);
        if (stat != 0) {
            throw new RlmException(stat, this);
        }
    }

    /**
     * @deprecated
     */
    public void revokeLicenseReference(String url, String product) throws RlmException {
        int stat = this.rlmActRevokeReference(this.handle, url, product);
        if (stat != 0) {
            throw new RlmException(stat, this);
        }
    }

    public String disconnectedRevoke(String product) throws RlmException {
        byte[] retval = new byte[1025];
        int stat = this.rlmActRevokeDisconn(this.handle, "", product, retval);
        if (stat != 0) {
            throw new RlmException(stat, this);
        } else {
            return (new String(retval)).trim();
        }
    }

    public void processDisconnectedRevoke(String url, String verifyCode) throws RlmException {
        int stat = this.rlmActRevokeDisconn(this.handle, url, verifyCode, (byte[]) null);
        if (stat != 0) {
            throw new RlmException(stat, this);
        }
    }

    public boolean actKeyValid(String url, String actKey, String hostID) throws RlmException {
        int stat = this.rlmActKeyvalid(this.handle, url, actKey, hostID);
        if (stat != 0) {
            throw new RlmException(stat, this);
        } else {
            return true;
        }
    }

    public String actKeyValidLicense(String url, String actKey, String hostID) throws RlmException {
        byte[] buf = new byte[102400];
        int stat = this.rlmActKeyvalidLicense(this.handle, url, actKey, hostID, buf);
        if (stat != 0) {
            throw new RlmException(stat, this);
        } else {
            return (new String(buf)).trim();
        }
    }

    public boolean previouslyActivated() {
        return this.previouslyActivated;
    }

    public String getRehost(String product) {
        String ret = null;
        byte[] hostid = new byte[77];
        int stat = this.rlmGetRehost(this.handle, product, hostid);
        if (stat == 0) {
            ret = (new String(hostid)).trim();
        }

        return ret;
    }

    public void setReferenceHostid(String hostid) {
        this.rlmSetReferenceHostid(this.handle, hostid);
    }

    public void doClientSideDiagnostics(String diagFile) {
        this.rlmDiagnostics(this.handle, diagFile);
    }

    protected void finalize() {
        int n = this.productHandleList.size();

        for (int i = 0; i < n; ++i) {
            Long l = (Long) ((Long) this.productHandleList.get(i));
            long prodHandle = l;
            this.rlmProductFree(prodHandle);
        }

        this.close();
    }

    public String getMessageByCode(int code) {
        String ret = null;
        byte[] errString = new byte[513];
        this.rlmErrstringNum(code, errString);
        ret = (new String(errString)).trim();
        return ret;
    }
}
