// 
// Decompiled by Procyon v0.5.36
// 

package com.reprisesoftware.rlm;

public class RlmAvailableProduct implements RlmConstants
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
    
    RlmAvailableProduct() {
    }
    
    protected void setName(final String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    protected void setVersion(final String version) {
        this.version = version;
    }
    
    public String getVersion() {
        return this.version;
    }
    
    protected void setActKey(final String actKey) {
        this.actKey = actKey;
    }
    
    public String getActKey() {
        return this.actKey;
    }
    
    protected void setCount(final int count) {
        this.count = count;
    }
    
    public int getCount() {
        return this.count;
    }
    
    protected void setContract(final String contract) {
        this.contract = contract;
    }
    
    public String getContract() {
        return this.contract;
    }
    
    protected void setCustomer(final String customer) {
        this.customer = customer;
    }
    
    public String getCustomer() {
        return this.customer;
    }
    
    protected void setExpiration(final String expiration) {
        this.expiration = expiration;
    }
    
    public String getExpiration() {
        return this.expiration;
    }
    
    protected void setExpDays(final int expDays) {
        this.expDays = expDays;
    }
    
    public int getExpDays() {
        return this.expDays;
    }
    
    protected void setCurrentInUse(final int count) {
        this.inUse = count;
    }
    
    public int getCurrentInUse() {
        return this.inUse;
    }
    
    protected void setCurrentResUse(final int count) {
        this.resInUse = count;
    }
    
    public int getCurrentResUse() {
        return this.resInUse;
    }
    
    protected void setHostBased(final int count) {
        this.hostBased = count;
    }
    
    public int getHostBased() {
        return this.hostBased;
    }
    
    protected void setHostId(final String hostId) {
        this.hostId = hostId;
    }
    
    public String getHostId() {
        return this.hostId;
    }
    
    protected void setHold(final int count) {
        this.hold = count;
    }
    
    public int getHold() {
        return this.hold;
    }
    
    protected void setIssuer(final String issuer) {
        this.issuer = issuer;
    }
    
    public String getIssuer() {
        return this.issuer;
    }
    
    protected void setMaxRoam(final int count) {
        this.maxRoam = count;
    }
    
    public int getMaxRoam() {
        return this.maxRoam;
    }
    
    protected void setMaxRoamCount(final int count) {
        this.maxRoamCount = count;
    }
    
    public int getMaxRoamCount() {
        return this.maxRoamCount;
    }
    
    protected void setMaxShare(final int count) {
        this.maxShare = count;
    }
    
    public int getMaxShare() {
        return this.maxShare;
    }
    
    protected void setMinCheckout(final int count) {
        this.minCheckout = count;
    }
    
    public int getMinCheckout() {
        return this.minCheckout;
    }
    
    protected void setMinTimeout(final int count) {
        this.minTimeout = count;
    }
    
    public int getMinTimeout() {
        return this.minTimeout;
    }
    
    protected void setMinRemove(final int count) {
        this.minRemove = count;
    }
    
    public int getMinRemove() {
        return this.minRemove;
    }
    
    protected void setNRes(final int count) {
        this.nRes = count;
    }
    
    public int getNRes() {
        return this.nRes;
    }
    
    protected void setNRoamAllowed(final int count) {
        this.nRoamAllowed = count;
    }
    
    public int getNRoamAllowed() {
        return this.nRoamAllowed;
    }
    
    protected void setCurrentRoam(final int count) {
        this.currentRoam = count;
    }
    
    public int getCurrentRoam() {
        return this.currentRoam;
    }
    
    protected void setOptions(final String options) {
        this.options = options;
    }
    
    public String getOptions() {
        return this.options;
    }
    
    protected void setServer(final String server) {
        this.server = server;
    }
    
    public String getServer() {
        return this.server;
    }
    
    protected void setShare(final int count) {
        this.share = count;
    }
    
    public int getShare() {
        return this.share;
    }
    
    protected void setSoftLimit(final int count) {
        this.softLimit = count;
    }
    
    public int getSoftLimit() {
        return this.softLimit;
    }
    
    protected void setTimeout(final int count) {
        this.timeout = count;
    }
    
    public int getTimeout() {
        return this.timeout;
    }
    
    protected void setTimezone(final int count) {
        this.timezone = count;
    }
    
    public int getTimezone() {
        return this.timezone;
    }
    
    protected void setIsRoaming(final boolean roaming) {
        this.isRoaming = roaming;
    }
    
    protected void setIsRoaming(final int roaming) {
        if (roaming == 0) {
            this.isRoaming = false;
        }
        else {
            this.isRoaming = true;
        }
    }
    
    public boolean getIsRoaming() {
        return this.isRoaming;
    }
    
    protected void setIsTokenBased(final boolean tokenBased) {
        this.isTokenBased = tokenBased;
    }
    
    protected void setIsTokenBased(final int tokenBased) {
        if (tokenBased == 0) {
            this.isTokenBased = false;
        }
        else {
            this.isTokenBased = true;
        }
    }
    
    public boolean getIsTokenBased() {
        return this.isTokenBased;
    }
    
    protected void setType(final int count) {
        this.type = count;
    }
    
    public int getType() {
        return this.type;
    }
    
    protected void setUserBased(final int count) {
        this.userBased = count;
    }
    
    public int getUserBased() {
        return this.userBased;
    }
    
    protected void setClientCache(final int cache) {
        this.clientCache = cache;
    }
    
    protected int getClientCache() {
        return this.clientCache;
    }
    
    protected void setProdHandle(final long prodHandle) {
        this.prodHandle = prodHandle;
    }
    
    protected long getProdHandle() {
        return this.prodHandle;
    }
    
    protected void setIndex(final int index) {
        this.index = index;
    }
    
    protected int getIndex() {
        return this.index;
    }
}
