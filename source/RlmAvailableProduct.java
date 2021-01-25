package com.reprisesoftware.rlm;


public class RlmAvailableProduct
  implements RlmConstants
{
  private String name;
  
  private String version;
  
  private String actKey;
  
  private int count;
  
  private String contract;
  
  private String customer;
  
  private int expDays;
  
  private String expiration;
  
  private int inUse;
  
  private int resInUse;
  
  private int hostBased;
  
  private String hostId;
  
  private int hold;
  
  private String issuer;
  
  private int maxRoam;
  
  private int maxRoamCount;
  
  private int maxShare;
  
  private int minRemove;
  
  private int minCheckout;
  
  private int minTimeout;
  
  private int nRes;
  
  private int nRoamAllowed;
  
  private String options;
  private int currentRoam;
  private String server;
  private int share;
  private int softLimit;
  private int timeout;
  private int timezone;
  private boolean isRoaming;
  private boolean isTokenBased;
  private int type;
  private int userBased;
  private int clientCache;
  private long prodHandle;
  private int index;
  
  RlmAvailableProduct() {}
  
  protected void setName(String name)
  {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  protected void setVersion(String version) {
    this.version = version;
  }
  
  public String getVersion() {
    return version;
  }
  
  protected void setActKey(String actKey) {
    this.actKey = actKey;
  }
  
  public String getActKey() {
    return actKey;
  }
  
  protected void setCount(int count) {
    this.count = count;
  }
  
  public int getCount() {
    return count;
  }
  
  protected void setContract(String contract) {
    this.contract = contract;
  }
  
  public String getContract() {
    return contract;
  }
  
  protected void setCustomer(String customer) {
    this.customer = customer;
  }
  
  public String getCustomer() {
    return customer;
  }
  
  protected void setExpiration(String expiration) {
    this.expiration = expiration;
  }
  
  public String getExpiration() {
    return expiration;
  }
  
  protected void setExpDays(int expDays) {
    this.expDays = expDays;
  }
  
  public int getExpDays() {
    return expDays;
  }
  
  protected void setCurrentInUse(int count) {
    inUse = count;
  }
  
  public int getCurrentInUse() {
    return inUse;
  }
  
  protected void setCurrentResUse(int count) {
    resInUse = count;
  }
  
  public int getCurrentResUse() {
    return resInUse;
  }
  
  protected void setHostBased(int count) {
    hostBased = count;
  }
  
  public int getHostBased() {
    return hostBased;
  }
  
  protected void setHostId(String hostId) {
    this.hostId = hostId;
  }
  
  public String getHostId() {
    return hostId;
  }
  
  protected void setHold(int count) {
    hold = count;
  }
  
  public int getHold() {
    return hold;
  }
  
  protected void setIssuer(String issuer) {
    this.issuer = issuer;
  }
  
  public String getIssuer() {
    return issuer;
  }
  
  protected void setMaxRoam(int count) {
    maxRoam = count;
  }
  
  public int getMaxRoam() {
    return maxRoam;
  }
  
  protected void setMaxRoamCount(int count) {
    maxRoamCount = count;
  }
  
  public int getMaxRoamCount() {
    return maxRoamCount;
  }
  
  protected void setMaxShare(int count) {
    maxShare = count;
  }
  
  public int getMaxShare() {
    return maxShare;
  }
  
  protected void setMinCheckout(int count) {
    minCheckout = count;
  }
  
  public int getMinCheckout() {
    return minCheckout;
  }
  
  protected void setMinTimeout(int count) {
    minTimeout = count;
  }
  
  public int getMinTimeout() {
    return minTimeout;
  }
  
  protected void setMinRemove(int count) {
    minRemove = count;
  }
  
  public int getMinRemove() {
    return minRemove;
  }
  
  protected void setNRes(int count) {
    nRes = count;
  }
  
  public int getNRes() {
    return nRes;
  }
  
  protected void setNRoamAllowed(int count) {
    nRoamAllowed = count;
  }
  
  public int getNRoamAllowed() {
    return nRoamAllowed;
  }
  
  protected void setCurrentRoam(int count) {
    currentRoam = count;
  }
  
  public int getCurrentRoam() {
    return currentRoam;
  }
  
  protected void setOptions(String options) {
    this.options = options;
  }
  
  public String getOptions() {
    return options;
  }
  
  protected void setServer(String server) {
    this.server = server;
  }
  
  public String getServer() {
    return server;
  }
  
  protected void setShare(int count) {
    share = count;
  }
  
  public int getShare() {
    return share;
  }
  
  protected void setSoftLimit(int count) {
    softLimit = count;
  }
  
  public int getSoftLimit() {
    return softLimit;
  }
  
  protected void setTimeout(int count) {
    timeout = count;
  }
  
  public int getTimeout() {
    return timeout;
  }
  
  protected void setTimezone(int count) {
    timezone = count;
  }
  
  public int getTimezone() {
    return timezone;
  }
  
  protected void setIsRoaming(boolean roaming) {
    isRoaming = roaming;
  }
  
  protected void setIsRoaming(int roaming) {
    if (roaming == 0) {
      isRoaming = false;
    }
    else {
      isRoaming = true;
    }
  }
  
  public boolean getIsRoaming() {
    return isRoaming;
  }
  
  protected void setIsTokenBased(boolean tokenBased) {
    isTokenBased = tokenBased;
  }
  
  protected void setIsTokenBased(int tokenBased) {
    if (tokenBased == 0) {
      isTokenBased = false;
    }
    else {
      isTokenBased = true;
    }
  }
  
  public boolean getIsTokenBased() {
    return isTokenBased;
  }
  
  protected void setType(int count) {
    type = count;
  }
  
  public int getType() {
    return type;
  }
  
  protected void setUserBased(int count) {
    userBased = count;
  }
  
  public int getUserBased() {
    return userBased;
  }
  
  protected void setClientCache(int cache) {
    clientCache = cache;
  }
  
  protected int getClientCache() {
    return clientCache;
  }
  
  protected void setProdHandle(long prodHandle) {
    this.prodHandle = prodHandle;
  }
  
  protected long getProdHandle() {
    return prodHandle;
  }
  
  protected void setIndex(int index) {
    this.index = index;
  }
  
  protected int getIndex() {
    return index;
  }
}
