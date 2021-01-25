package com.reprisesoftware.rlm;

import java.util.Vector;

public class RlmHandle implements RlmConstants { private static native void rlmPutenv(String paramString);
  
  private native long rlmInit(String paramString1, String paramString2, String paramString3);
  
  private native long rlmInitDisconn(String paramString1, String paramString2, String paramString3, int paramInt);
  
  private native int rlmClose(long paramLong);
  
  private native int rlmStat(long paramLong);
  
  private native int rlmHostID(long paramLong, int paramInt, byte[] paramArrayOfByte);
  
  private native void rlmAllHostIDs(long paramLong, int paramInt, byte[] paramArrayOfByte);
  
  private native int rlmRlog(long paramLong, String paramString);
  
  private native int rlmDlog(long paramLong, String paramString);
  
  private native int rlmDetachedDemo(long paramLong, int paramInt, String paramString);
  
  private native int rlmDetachedDemoX(long paramLong, String paramString1, String paramString2);
  
  private native void rlmDiagnostics(long paramLong, String paramString);
  
  private native long rlmProducts(long paramLong, String paramString1, String paramString2);
  
  private native void rlmProductFirst(long paramLong);
  
  private native int rlmProductNext(long paramLong);
  
  private native String rlmProductName(long paramLong);
  
  private native String rlmProductVersion(long paramLong);
  
  private native String rlmProductActKey(long paramLong);
  
  private native int rlmProductCount(long paramLong);
  
  private native String rlmProductContract(long paramLong);
  
  private native String rlmProductCustomer(long paramLong);
  
  private native int rlmProductCurrentInUse(long paramLong);
  
  private native int rlmProductCurrentResUse(long paramLong);
  
  private native int rlmProductExpDays(long paramLong);
  
  private native String rlmProductExpiration(long paramLong);
  
  private native int rlmProductHostBased(long paramLong);
  
  private native String rlmProductHostId(long paramLong);
  
  private native int rlmProductHold(long paramLong);
  
  private native int rlmProductIsRoaming(long paramLong);
  
  private native String rlmProductIssuer(long paramLong);
  
  private native int rlmMaxRoam(long paramLong);
  
  private native int rlmMaxRoamCount(long paramLong);
  
  private native int rlmMaxShare(long paramLong);
  
  private native int rlmMinRemove(long paramLong);
  
  private native int rlmMinCheckout(long paramLong);
  
  private native int rlmMinTimeout(long paramLong);
  
  private native int rlmNRes(long paramLong);
  
  private native int rlmNRoamAllowed(long paramLong);
  
  private native String rlmOptions(long paramLong);
  
  private native int rlmCurrentRoam(long paramLong);
  
  private native String rlmServer(long paramLong);
  
  private native int rlmShare(long paramLong);
  
  private native int rlmSoftLimit(long paramLong);
  
  private native int rlmTimeout(long paramLong);
  
  private native int rlmTimezone(long paramLong);
  
  private native int rlmIsTokenBased(long paramLong);
  
  private native int rlmType(long paramLong);
  
  private native int rlmUserBased(long paramLong);
  
  private native int rlmClientCache(long paramLong);
  
  private native void rlmSetUser(long paramLong, String paramString);
  
  private native void rlmSetHost(long paramLong, String paramString);
  
  private native void rlmSetIsvData(long paramLong, String paramString);
  
  private native void rlmSkipIsvDown(long paramLong);
  
  private native void rlmForgetIsvDown(long paramLong);
  
  private native void rlmKeepConn(long paramLong);
  
  private native void rlmErrstringNum(int paramInt, byte[] paramArrayOfByte);
  
  private native void rlmEnableLogging(long paramLong, int paramInt);
  
  private native void rlmSetPassword(long paramLong, String paramString);
  
  private native void rlmSetRequiredOption(long paramLong, String paramString);
  
  private native int rlmActRequest(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, byte[] paramArrayOfByte);
  
  private native int rlmActivate(long paramLong1, String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte, long paramLong2);
  
  private native int rlmActRevoke(long paramLong, String paramString1, String paramString2);
  
  private native int rlmActRevokeReference(long paramLong, String paramString1, String paramString2);
  
  private native int rlmActRevokeDisconn(long paramLong, String paramString1, String paramString2, byte[] paramArrayOfByte);
  
  private native int rlmActKeyvalid(long paramLong, String paramString1, String paramString2, String paramString3);
  
  private native int rlmActKeyvalidLicense(long paramLong, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte);
  
  private native int rlmGetRehost(long paramLong, String paramString, byte[] paramArrayOfByte);
  
  public void loadLib(String libName) { System.loadLibrary(libName); }
  
  private void createHandle(String licLoc, String appPath, String license, String libName, String[] env, int promise)
    throws RlmException
  {
    loadLib(libName);
    




    if (env != null) {
      for (int i = 0; i < env.length; i++) {
        rlmPutenv(env[i]);
      }
    }
    if (licLoc == null)
      licLoc = "";
    if (appPath == null)
      appPath = "";
    if (license == null)
      license = "";
    if (promise > 0) {
      handle = rlmInitDisconn(licLoc, appPath, license, promise);
    }
    else
      handle = rlmInit(licLoc, appPath, license);
    int stat = rlmStat(handle);
    if ((stat != 0) && (stat != -102)) {
      throw new RlmException(stat, this);
    }
  }
  














  public RlmHandle(String licLoc, String appPath, String license)
    throws RlmException
  {
    createHandle(licLoc, appPath, license, "rlm1221", null, 0);
  }
  




















  public RlmHandle(String licLoc, String appPath, String license, int promise)
    throws RlmException
  {
    createHandle(licLoc, appPath, license, "rlm1221", null, promise);
  }
  























  public RlmHandle(String licLoc, String appPath, String license, String[] env)
    throws RlmException
  {
    createHandle(licLoc, appPath, license, "rlm1221", env, 0);
  }
  














  private long handle;
  












  public RlmHandle(String licLoc, String appPath, String license, String libName)
    throws RlmException
  {
    String lib = null;
    if ((libName != null) && (libName.length() > 0)) {
      lib = libName;
    } else
      lib = "rlm1221";
    createHandle(licLoc, appPath, license, lib, null, 0);
  }
  












  private boolean previouslyActivated;
  










  private static final String defaultLibName = "rlm1221";
  










  public RlmHandle(String licLoc, String appPath, String license, String libName, String[] env)
    throws RlmException
  {
    String lib = null;
    if ((libName != null) && (libName.length() > 0)) {
      lib = libName;
    } else
      lib = "rlm1221";
    createHandle(licLoc, appPath, license, lib, env, 0);
  }
  
  protected long getHandle()
  {
    return handle;
  }
  



  public void close()
  {
    if (handle != 0L) {
      rlmClose(handle);
    }
    handle = 0L;
  }
  












  /**
   * @deprecated
   */
  public String getHostID(int type)
  {
    byte[] buf = new byte[76];
    String hid = null;
    int stat = rlmHostID(handle, type, buf);
    if (stat == 0) {
      hid = new String(buf);
    }
    return hid;
  }
  




  public String[] getAllHostIDs(int type)
  {
    byte[] buf = new byte['ݬ'];
    rlmAllHostIDs(handle, type, buf);
    String all = new String(buf).trim();
    String[] split = all.split(" ");
    return split;
  }
  



  public void writeReportLog(String logString)
    throws RlmException
  {
    int stat = rlmRlog(handle, logString);
    if (stat != 0) {
      throw new RlmException(stat, this);
    }
  }
  



  public void writeDebugLog(String logString)
    throws RlmException
  {
    int stat = rlmDlog(handle, logString);
    if (stat != 0) {
      throw new RlmException(stat, this);
    }
  }
  





  public void createDetachedDemo(int days, String license)
    throws RlmException
  {
    int stat = rlmDetachedDemo(handle, days, license);
    if (stat != 0) {
      throw new RlmException(stat, this);
    }
  }
  







  public void removeDetachedDemo(String product, String version)
    throws RlmException
  {
    int stat = rlmDetachedDemoX(handle, product, version);
    if (stat != 0) {
      throw new RlmException(stat, this);
    }
  }
  
  private void addProduct(long prodHandle, Vector v, int index) {
    RlmAvailableProduct prod = new RlmAvailableProduct();
    
    /*
    prod.setName(rlmProductName(prodHandle));
    prod.setVersion(rlmProductVersion(prodHandle));
    prod.setActKey(rlmProductActKey(prodHandle));
    prod.setCount(rlmProductCount(prodHandle));
    prod.setCurrentInUse(rlmProductCurrentInUse(prodHandle));
    prod.setCurrentResUse(rlmProductCurrentResUse(prodHandle));
    prod.setContract(rlmProductContract(prodHandle));
    prod.setCustomer(rlmProductCustomer(prodHandle));
    prod.setExpDays(rlmProductExpDays(prodHandle));
    prod.setExpiration(rlmProductExpiration(prodHandle));
    prod.setHostBased(rlmProductHostBased(prodHandle));
    prod.setHostId(rlmProductHostId(prodHandle));
    prod.setHold(rlmProductHold(prodHandle));
    prod.setIsRoaming(rlmProductIsRoaming(prodHandle));
    prod.setIssuer(rlmProductIssuer(prodHandle));
    prod.setMaxRoam(rlmMaxRoam(prodHandle));
    prod.setMaxRoamCount(rlmMaxRoamCount(prodHandle));
    prod.setMaxShare(rlmMaxShare(prodHandle));
    prod.setMinRemove(rlmMinRemove(prodHandle));
    prod.setMinCheckout(rlmMinCheckout(prodHandle));
    prod.setMinTimeout(rlmMinTimeout(prodHandle));
    prod.setNRes(rlmNRes(prodHandle));
    prod.setNRoamAllowed(rlmNRoamAllowed(prodHandle));
    prod.setOptions(rlmOptions(prodHandle));
    prod.setCurrentRoam(rlmCurrentRoam(prodHandle));
    prod.setServer(rlmServer(prodHandle));
    prod.setShare(rlmShare(prodHandle));
    prod.setSoftLimit(rlmSoftLimit(prodHandle));
    prod.setTimeout(rlmTimeout(prodHandle));
    prod.setTimezone(rlmTimezone(prodHandle));
    prod.setIsTokenBased(rlmIsTokenBased(prodHandle));
    prod.setType(rlmType(prodHandle));
    prod.setUserBased(rlmUserBased(prodHandle));
    prod.setClientCache(rlmClientCache(prodHandle));
    prod.setProdHandle(prodHandle);
    prod.setIndex(index);*/
    
    System.out.println("addProduct当然是直接加PRO版本~");
    prod.setName("live2d_editorc-3");
    prod.setVersion("3.0");
    prod.setActKey("CHCC-1234-5678-9012-1234");
    prod.setCount(0);
    prod.setCurrentInUse(0);
    prod.setCurrentResUse(0);
    //prod.setContract(rlmProductContract(prodHandle));
    //prod.setCustomer(rlmProductCustomer(prodHandle));
    prod.setExpDays(0);
    prod.setExpiration("permanent");
    prod.setHostBased(0);
    prod.setHostId("ANY");
    prod.setHold(0);
    prod.setIsRoaming(0);
    prod.setIssuer("Hakura");
    prod.setMaxRoam(0);
    prod.setMaxRoamCount(0);
    prod.setMaxShare(3);
    prod.setMinRemove(0);
    prod.setMinCheckout(0);
    prod.setMinTimeout(0);
    prod.setNRes(0);
    //prod.setNRoamAllowed(rlmNRoamAllowed(prodHandle));
    //prod.setOptions(rlmOptions(prodHandle));
    //prod.setCurrentRoam(rlmCurrentRoam(prodHandle));
    //prod.setServer(rlmServer(prodHandle));
    //prod.setShare(rlmShare(prodHandle));
    //prod.setSoftLimit(rlmSoftLimit(prodHandle));
    prod.setTimeout(0);
    prod.setTimezone(0);
    //prod.setIsTokenBased(rlmIsTokenBased(prodHandle));
    prod.setType(0);
    //prod.setUserBased(rlmUserBased(prodHandle));
    //prod.setClientCache(rlmClientCache(prodHandle));
    //prod.setProdHandle(prodHandle);
    prod.setIndex(index);
    
    v.add(prod);
  }
  


















  public Vector getAvailableProducts(String product, String version)
  {
    System.out.println("getAvailableProducts已经被窝干掉啦~");
    Vector v = null;
    v = new Vector();
    long prodHandle = 1;
    addProduct(prodHandle, v, 1);
    
    /*long prodHandle = rlmProducts(handle, product, version);
    System.out.println(prodHandle);
    //1784620080
    if (prodHandle != 0L) {
      v = new Vector();
      rlmProductFirst(prodHandle);
      int i = 0;
      addProduct(prodHandle, v, i++);
      while (rlmProductNext(prodHandle) == 0) {
        addProduct(prodHandle, v, i++);
      }
    }*/
    return v;
  }
  
  protected void positionProdHandle(long prodHandle, int index) {
    rlmProductFirst(prodHandle);
    for (int i = 0; i < index; i++) {
      rlmProductNext(prodHandle);
    }
  }
  






  public void setUser(String user)
  {
    rlmSetUser(handle, user);
  }
  







  public void setHost(String host)
  {
    rlmSetHost(handle, host);
  }
  






  public void setIsvData(String isvData)
  {
    rlmSetIsvData(handle, isvData);
  }
  






  public void enableLogging(int enable)
  {
    rlmEnableLogging(handle, enable);
  }
  






  public void setPassword(String password)
  {
    rlmSetPassword(handle, password);
  }
  







  public void setOption(String option)
  {
    rlmSetRequiredOption(handle, option);
  }
  




  public void skipIsvDown()
  {
    rlmSkipIsvDown(handle);
  }
  


  public void forgetIsvDown()
  {
    rlmForgetIsvDown(handle);
  }
  






  public void keepConn()
  {
    rlmKeepConn(handle);
  }
  





















  public String actRequest(String url, String isv, String key, String hostidList, String hostName, int count, String extra)
    throws RlmException
  {
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
    

    int stat = rlmActRequest(handle, url, isv, key, hostidList, hostName, count, extra, buf);
    
    if (stat < 0) {
      throw new RlmException(stat, this);
    }
    previouslyActivated = (stat == 1);
    return new String(buf).trim();
  }
  










  public String activateLicense(String url, String key, int count, RlmActHandle actHandle)
    throws RlmException
  {
    /*byte[] buf = new byte[102400];
    long ah;
    if (actHandle == null) {
      ah = 0L;
    } else {
      ah = actHandle.getHandle();
    }
    int stat = rlmActivate(handle, url, key, count, buf, ah);
    if (stat < 0)
      throw new RlmException(stat, this);
    previouslyActivated = (stat == 1);
    System.out.println("我返回了null");
    System.out.println(url);
    System.out.println(key);
    System.out.println(new String(buf).trim());
    //return new String(buf).trim();*/
    return "Cracked";
}
  





  public void revokeLicense(String url, String product)
    throws RlmException
  {
    int stat = rlmActRevoke(handle, url, product);
    if (stat != 0) {
      throw new RlmException(stat, this);
    }
  }
  






  public void revokeLicenseReference(String url, String product)
    throws RlmException
  {
    int stat = rlmActRevokeReference(handle, url, product);
    if (stat != 0) {
      throw new RlmException(stat, this);
    }
  }
  










  public String disconnectedRevoke(String product)
    throws RlmException
  {
    byte[] retval = new byte['Ё'];
    int stat = rlmActRevokeDisconn(handle, "", product, retval);
    if (stat != 0)
      throw new RlmException(stat, this);
    return new String(retval).trim();
  }
  








  public void processDisconnectedRevoke(String url, String verifyCode)
    throws RlmException
  {
    int stat = rlmActRevokeDisconn(handle, url, verifyCode, null);
    if (stat != 0) {
      throw new RlmException(stat, this);
    }
  }
  










  public boolean actKeyValid(String url, String actKey, String hostID)
    throws RlmException
  {
    int stat = rlmActKeyvalid(handle, url, actKey, hostID);
    
    if (stat != 0)
      throw new RlmException(stat, this);
    return true;
  }
  












  public String actKeyValidLicense(String url, String actKey, String hostID)
    throws RlmException
  {
    byte[] buf = new byte[102400];
    int stat = rlmActKeyvalidLicense(handle, url, actKey, hostID, buf);
    
    if (stat != 0)
      throw new RlmException(stat, this);
    return new String(buf).trim();
  }
  







  public boolean previouslyActivated()
  {
    return previouslyActivated;
  }
  






  public String getRehost(String product)
  {
    String ret = null;
    byte[] hostid = new byte[77];
    int stat = rlmGetRehost(handle, product, hostid);
    if (stat == 0)
      ret = new String(hostid).trim();
    return ret;
  }
  



  public void doClientSideDiagnostics(String diagFile)
  {
    rlmDiagnostics(handle, diagFile);
  }
  
  protected void finalize() {
    close();
  }
  







  public String getMessageByCode(int code)
  {
    String ret = null;
    byte[] errString = new byte['ȁ'];
    rlmErrstringNum(code, errString);
    ret = new String(errString).trim();
    return ret;
  }
}
