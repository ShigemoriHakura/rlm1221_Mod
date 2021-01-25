package com.reprisesoftware.rlm;


public class RlmLicense
  implements RlmConstants
{
  private long licHandle;
  
  private boolean valid;
  
  private native long rlmCheckout(long paramLong, String paramString1, String paramString2, int paramInt);
  
  private native long rlmCheckoutProduct(long paramLong1, long paramLong2, String paramString, int paramInt);
  
  private native int rlmLicenseStat(long paramLong);
  
  private native int rlmCheckin(long paramLong);
  
  private native int rlmGetAttrHealth(long paramLong);
  
  private native int rlmGoodOnce(long paramLong);
  
  private native String rlmLicenseActKey(long paramLong);
  
  private native String rlmLicenseContract(long paramLong);
  
  private native String rlmLicenseCustomer(long paramLong);
  
  private native int rlmLicenseCount(long paramLong);
  
  private native int rlmLicenseDetachedDemo(long paramLong);
  
  private native String rlmLicenseExp(long paramLong);
  
  private native int rlmLicenseHold(long paramLong);
  
  private native int rlmLicenseHostBased(long paramLong);
  
  private native String rlmLicenseHostid(long paramLong);
  
  private native String rlmLicenseIssued(long paramLong);
  
  private native String rlmLicenseIssuer(long paramLong);
  
  private native String rlmLicenseLineItem(long paramLong);
  
  private native int rlmLicenseMaxRoam(long paramLong);
  
  private native int rlmLicenseMaxRoamCount(long paramLong);
  
  private native int rlmLicenseMinRemove(long paramLong);
  
  private native int rlmLicenseMinTimeout(long paramLong);
  
  private native int rlmLicenseMinCheckout(long paramLong);
  
  private native String rlmLicensePlatforms(long paramLong);
  
  private native String rlmLicenseProduct(long paramLong);
  
  private native String rlmLicenseServer(long paramLong);
  
  private native int rlmLicenseSingle(long paramLong);
  
  private native int rlmLicenseShare(long paramLong);
  
  private native int rlmLicenseSoftLimit(long paramLong);
  
  private native String rlmLicenseStart(long paramLong);
  
  private native int rlmLicenseType(long paramLong);
  
  private native int rlmLicenseTimezone(long paramLong);
  
  private native int rlmLicenseUncounted(long paramLong);
  
  private native int rlmLicenseUserBased(long paramLong);
  
  private native String rlmLicenseVersion(long paramLong);
  
  private native int rlmLicenseNamedUserCount(long paramLong);
  
  private native int rlmLicenseNamedUserMinHours(long paramLong);
  
  private native String rlmLicenseGetLFPath(long paramLong);
  
  private native int rlmLicenseExpDays(long paramLong);
  
  private native int rlmLicenseRoaming(long paramLong);
  
  private native int rlmLicenseMaxShare(long paramLong);
  
  private native String rlmLicenseOptions(long paramLong);
  
  private native int rlmLicenseClientCache(long paramLong);
  
  private native int rlmLicenseIsCached(long paramLong);
  
  private native int rlmAuthCheck(long paramLong, String paramString);
  
  public RlmLicense(RlmHandle handle, String product, String version, int count)
    throws RlmException
  {
    System.out.println("验证许可证自然也要永远是True~");
    /*licHandle = rlmCheckout(handle.getHandle(), product, version, count);
    
    int stat = rlmLicenseStat(licHandle);
    
    if ((stat != 0) && (stat != -25) && (stat != -39)) {
      throw new RlmException(stat, handle, this);
    }*/
    valid = true;
  }
  



















  public RlmLicense(RlmHandle handle, RlmAvailableProduct product, String version, int count)
    throws RlmException
  {
    long prodHandle = product.getProdHandle();
    handle.positionProdHandle(prodHandle, product.getIndex());
    
    licHandle = rlmCheckoutProduct(handle.getHandle(), prodHandle, version, count);
    
    int stat = rlmLicenseStat(licHandle);
    
    if ((stat != 0) && (stat != -25) && (stat != -39)) {
      throw new RlmException(stat, handle, this);
    }
    valid = true;
  }
  
  protected long getLicenseHandle() {
    return licHandle;
  }
  




  public int status()
    throws RlmException
  {
    int stat;
    



    if (valid) {
      stat = rlmLicenseStat(licHandle);
    }
    else
      throw new RlmException(-19);
  
    System.out.println("许可证状态自然要是1~");
    
    //return stat;
    return 0;
  }
  




  public void checkin()
  {
    if (valid) {
      rlmCheckin(licHandle);
      valid = false;
    }
  }
  





















  public int getAttrHealth()
    throws RlmException
  {
    int stat = 0;
    if (valid) {
      stat = rlmGetAttrHealth(licHandle);
    }
    else
      throw new RlmException(-19);
    return stat;
  }
  





  public String getActKey()
  {
    return rlmLicenseActKey(licHandle);
  }
  







  public boolean goodOnce()
  {
    boolean ret = false;
    int stat = rlmGoodOnce(licHandle);
    if (stat != 0) {
      ret = true;
    }
    return ret;
  }
  





  public int getCLientCache()
  {
    return rlmLicenseClientCache(licHandle);
  }
  





  public String getContract()
  {
    return rlmLicenseContract(licHandle);
  }
  



  public int getDetachedDemo()
  {
    return rlmLicenseDetachedDemo(licHandle);
  }
  





  public String getCustomer()
  {
    return rlmLicenseCustomer(licHandle);
  }
  





  public int getCount()
  {
    return rlmLicenseCount(licHandle);
  }
  





  public String getExpiration()
  {
    return rlmLicenseExp(licHandle);
  }
  





  public int getHold()
  {
    return rlmLicenseHold(licHandle);
  }
  





  public int hostBased()
  {
    return rlmLicenseHostBased(licHandle);
  }
  





  public String getHostID()
  {
    return rlmLicenseHostid(licHandle);
  }
  





  public String getIssued()
  {
    return rlmLicenseIssued(licHandle);
  }
  





  public String getIssuer()
  {
    return rlmLicenseIssuer(licHandle);
  }
  




  public boolean isCached()
  {
    int cached = rlmLicenseIsCached(licHandle);
    return cached != 0;
  }
  





  public String getLineItem()
  {
    return rlmLicenseLineItem(licHandle);
  }
  





  public int getMaxRoam()
  {
    return rlmLicenseMaxRoam(licHandle);
  }
  





  public int getMaxRoamCount()
  {
    return rlmLicenseMaxRoamCount(licHandle);
  }
  





  public int getMinRemove()
  {
    return rlmLicenseMinRemove(licHandle);
  }
  





  public int getMinTimeout()
  {
    return rlmLicenseMinTimeout(licHandle);
  }
  





  public String getPlatforms()
  {
    return rlmLicensePlatforms(licHandle);
  }
  





  public String getProduct()
  {
    return rlmLicenseProduct(licHandle);
  }
  





  public String getServer()
  {
    return rlmLicenseServer(licHandle);
  }
  






  public int getShare()
  {
    return rlmLicenseShare(licHandle);
  }
  





  public int getSoftLimit()
  {
    return rlmLicenseSoftLimit(licHandle);
  }
  





  public String getStart()
  {
    return rlmLicenseStart(licHandle);
  }
  






  public int getType()
  {
    return rlmLicenseType(licHandle);
  }
  





  public int getTimezone()
  {
    return rlmLicenseTimezone(licHandle);
  }
  





  public int userBased()
  {
    return rlmLicenseUserBased(licHandle);
  }
  






  public String getVersion()
  {
    return rlmLicenseVersion(licHandle);
  }
  




  public String getLFPath()
  {
    return rlmLicenseGetLFPath(licHandle);
  }
  







  public int daysToExpiration()
  {
    return rlmLicenseExpDays(licHandle);
  }
  




  public boolean isRoaming()
  {
    boolean roaming = false;
    if (rlmLicenseRoaming(licHandle) != 0)
      roaming = true;
    return roaming;
  }
  





  public int getMaxShare()
  {
    return rlmLicenseMaxShare(licHandle);
  }
  





  public int getNamedUserCount()
  {
    return rlmLicenseNamedUserCount(licHandle);
  }
  





  public int getNamedUserMinHours()
  {
    return rlmLicenseNamedUserMinHours(licHandle);
  }
  




  public String getOptions()
  {
    return rlmLicenseOptions(licHandle);
  }
  





  public int getMinCheckout()
  {
    return rlmLicenseMinCheckout(licHandle);
  }
  















  public boolean authCheck(String license)
    throws RlmException
  {
    int stat = rlmAuthCheck(licHandle, license);
    if (stat != 0)
      throw new RlmException(stat);
    return true;
  }
  


  public boolean isSingle()
  {
    boolean single = false;
    if (rlmLicenseSingle(licHandle) != 0)
      single = true;
    return single;
  }
  


  public boolean isUncounted()
  {
    boolean uncounted = false;
    if (rlmLicenseUncounted(licHandle) != 0)
      uncounted = true;
    return uncounted;
  }
}
