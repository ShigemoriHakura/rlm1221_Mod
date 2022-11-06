// 
// Decompiled by Procyon v0.5.36
// 

package com.reprisesoftware.rlm;

public class RlmActInfo implements RlmConstants
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
    
    private native int rlmActInfo(final long p0, final String p1, final String p2);
    
    public RlmActInfo(final RlmHandle rh, final String url, final String actKey) throws RlmException {
        final long longHandle = rh.getHandle();
        final int stat = this.rlmActInfo(longHandle, url, actKey);
        if (stat != 0) {
            throw new RlmException(stat);
        }
        this.url = url;
        this.actKey = actKey;
    }
    
    public String getActKey() {
        return this.actKey;
    }
    
    public String getURL() {
        return this.url;
    }
    
    public String getProduct() {
        return this.product;
    }
    
    public String getVersion() {
        return this.version;
    }
    
    public String getUpgradeVersion() {
        return this.upgradeVersion;
    }
    
    public int getDateBased() {
        return this.dateBased;
    }
    
    public int getLicenseType() {
        return this.licType;
    }
    
    public int getCount() {
        return this.count;
    }
    
    public int getFulfilled() {
        return this.fulfilled;
    }
    
    public int getRehosts() {
        return this.rehosts;
    }
    
    public int getRevoked() {
        return this.revoked;
    }
    
    public String getExpiration() {
        return this.exp;
    }
    
    public String getHostid() {
        return this.hostid;
    }
}
