package com.reprisesoftware.rlm;




public class RlmActInfo
  implements RlmConstants
{
  private String actKey;
  


  private String url;
  

  private String product;
  

  private String version;
  

  private String upgradeVersion;
  

  private int dateBased;
  

  private int licType;
  

  private int count;
  

  private int fulfilled;
  

  private int rehosts;
  

  private int revoked;
  

  private String exp;
  

  private String hostid;
  


  private native int rlmActInfo(long paramLong, String paramString1, String paramString2);
  


  public RlmActInfo(RlmHandle rh, String url, String actKey)
    throws RlmException
  {
    System.out.println("这里的联网也干掉啦~~~");
    /*long longHandle = rh.getHandle();
    int stat = rlmActInfo(longHandle, url, actKey);
    if (stat != 0) {
      throw new RlmException(stat);
    }*/
    this.url = url;
    this.actKey = actKey;
  }
  


  public String getActKey()
  {
    return actKey;
  }
  


  public String getURL()
  {
    return url;
  }
  


  public String getProduct()
  {
    return product;
  }
  


  public String getVersion()
  {
    return version;
  }
  



  public String getUpgradeVersion()
  {
    return upgradeVersion;
  }
  



  public int getDateBased()
  {
    return dateBased;
  }
  



  public int getLicenseType()
  {
    return licType;
  }
  


  public int getCount()
  {
    return count;
  }
  


  public int getFulfilled()
  {
    return fulfilled;
  }
  


  public int getRehosts()
  {
    return rehosts;
  }
  


  public int getRevoked()
  {
    return revoked;
  }
  


  public String getExpiration()
  {
    return exp;
  }
  


  public String getHostid()
  {
    return hostid;
  }
}
