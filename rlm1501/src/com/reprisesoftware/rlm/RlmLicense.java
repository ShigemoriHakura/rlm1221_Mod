// 
// Decompiled by Procyon v0.5.36
// 

package com.reprisesoftware.rlm;

public class RlmLicense implements RlmConstants
{
    private long licHandle;
    private boolean valid;
    
    private native long rlmCheckout(final long p0, final String p1, final String p2, final int p3);
    
    private native long rlmCheckoutProduct(final long p0, final long p1, final String p2, final int p3);
    
    private native int rlmLicenseStat(final long p0);
    
    private native int rlmCheckin(final long p0);
    
    private native int rlmGetAttrHealth(final long p0);
    
    private native int rlmGoodOnce(final long p0);
    
    private native String rlmLicenseAkey(final long p0);
    
    private native String rlmLicenseContract(final long p0);
    
    private native String rlmLicenseCustomer(final long p0);
    
    private native int rlmLicenseCount(final long p0);
    
    private native int rlmLicenseDetachedDemo(final long p0);
    
    private native String rlmLicenseExp(final long p0);
    
    private native String rlmLicenseExpTime(final long p0);
    
    private native int rlmLicenseHold(final long p0);
    
    private native int rlmLicenseHostBased(final long p0);
    
    private native String rlmLicenseHostid(final long p0);
    
    private native int rlmLicenseIsMetered(final long p0);
    
    private native String rlmLicenseIssued(final long p0);
    
    private native String rlmLicenseIssuer(final long p0);
    
    private native String rlmLicenseLineItem(final long p0);
    
    private native int rlmLicenseMaxRoam(final long p0);
    
    private native int rlmLicenseMaxRoamCount(final long p0);
    
    private native int rlmLicenseMeterCounter(final long p0);
    
    private native int rlmLicenseMinRemove(final long p0);
    
    private native int rlmLicenseMinTimeout(final long p0);
    
    private native int rlmLicenseMinCheckout(final long p0);
    
    private native String rlmLicensePlatforms(final long p0);
    
    private native String rlmLicenseProduct(final long p0);
    
    private native String rlmLicenseServer(final long p0);
    
    private native int rlmLicenseSingle(final long p0);
    
    private native int rlmLicenseShare(final long p0);
    
    private native int rlmLicenseSoftLimit(final long p0);
    
    private native String rlmLicenseStart(final long p0);
    
    private native String rlmLicenseTeams(final long p0);
    
    private native int rlmLicenseType(final long p0);
    
    private native int rlmLicenseTimezone(final long p0);
    
    private native int rlmLicenseUncounted(final long p0);
    
    private native int rlmLicenseUserBased(final long p0);
    
    private native String rlmLicenseVersion(final long p0);
    
    private native int rlmLicenseNamedUserCount(final long p0);
    
    private native int rlmLicenseNamedUserMinHours(final long p0);
    
    private native String rlmLicenseGetLFPath(final long p0);
    
    private native int rlmLicenseExpDays(final long p0);
    
    private native int rlmLicenseRoaming(final long p0);
    
    private native int rlmLicenseMaxShare(final long p0);
    
    private native String rlmLicenseOptions(final long p0);
    
    private native int rlmLicenseClientCache(final long p0);
    
    private native int rlmLicenseIsCached(final long p0);
    
    private native int rlmAuthCheck(final long p0, final String p1);
    
    public RlmLicense(final RlmHandle handle, final String product, final String version, final int count) throws RlmException {
        System.out.println("[ShiroSaki] RlmLicense RIP");
        this.valid = true;
        /*this.licHandle = this.rlmCheckout(handle.getHandle(), product, version, count);
        final int stat = this.rlmLicenseStat(this.licHandle);
        if (stat != 0 && stat != -25 && stat != -39) {
            throw new RlmException(stat, handle, this);
        }
        this.valid = true;*/
    }
    
    public RlmLicense(final RlmHandle handle, final RlmAvailableProduct product, final String version, final int count) throws RlmException {
        System.out.println("[ShiroSaki] RlmLicense RIP");
        this.valid = true;
        /*final long prodHandle = product.getProdHandle();
        handle.positionProdHandle(prodHandle, product.getIndex());
        this.licHandle = this.rlmCheckoutProduct(handle.getHandle(), prodHandle, version, count);
        final int stat = this.rlmLicenseStat(this.licHandle);
        if (stat != 0 && stat != -25 && stat != -39) {
            throw new RlmException(stat, handle, this);
        }
        this.valid = true;*/
    }
    
    protected long getLicenseHandle() {
        return this.licHandle;
    }
    
    public int status() throws RlmException {
        System.out.println("[ShiroSaki] Here should always be 0");
        return 0;
        /*if (this.valid) {
            final int stat = this.rlmLicenseStat(this.licHandle);
            return stat;
        }
        throw new RlmException(-19);*/
    }
    
    public void checkin() {
        if (this.valid) {
            this.rlmCheckin(this.licHandle);
            this.valid = false;
        }
    }
    
    public int getAttrHealth() throws RlmException {
        int stat = 0;
        if (this.valid) {
            stat = this.rlmGetAttrHealth(this.licHandle);
            return stat;
        }
        throw new RlmException(-19);
    }
    
    public String getActKey() {
        return this.rlmLicenseAkey(this.licHandle);
    }
    
    public boolean goodOnce() {
        boolean ret = false;
        final int stat = this.rlmGoodOnce(this.licHandle);
        if (stat != 0) {
            ret = true;
        }
        return ret;
    }
    
    public int getCLientCache() {
        return this.rlmLicenseClientCache(this.licHandle);
    }
    
    public String getContract() {
        return this.rlmLicenseContract(this.licHandle);
    }
    
    public int getDetachedDemo() {
        return this.rlmLicenseDetachedDemo(this.licHandle);
    }
    
    public String getCustomer() {
        return this.rlmLicenseCustomer(this.licHandle);
    }
    
    public int getCount() {
        return this.rlmLicenseCount(this.licHandle);
    }
    
    public String getExpiration() {
        return this.rlmLicenseExp(this.licHandle);
    }
    
    public String getExpTime() {
        return this.rlmLicenseExpTime(this.licHandle);
    }
    
    public int getHold() {
        return this.rlmLicenseHold(this.licHandle);
    }
    
    public int hostBased() {
        return this.rlmLicenseHostBased(this.licHandle);
    }
    
    public String getHostID() {
        return this.rlmLicenseHostid(this.licHandle);
    }
    
    public String getIssued() {
        return this.rlmLicenseIssued(this.licHandle);
    }
    
    public boolean isMetered() {
        final int metered = this.rlmLicenseIsMetered(this.licHandle);
        return metered != 0;
    }
    
    public String getIssuer() {
        return this.rlmLicenseIssuer(this.licHandle);
    }
    
    public boolean isCached() {
        final int cached = this.rlmLicenseIsCached(this.licHandle);
        return cached != 0;
    }
    
    public String getLineItem() {
        return this.rlmLicenseLineItem(this.licHandle);
    }
    
    public int getMaxRoam() {
        return this.rlmLicenseMaxRoam(this.licHandle);
    }
    
    public int getMaxRoamCount() {
        return this.rlmLicenseMaxRoamCount(this.licHandle);
    }
    
    public int getMeterCounter() {
        return this.rlmLicenseMeterCounter(this.licHandle);
    }
    
    public int getMinRemove() {
        return this.rlmLicenseMinRemove(this.licHandle);
    }
    
    public int getMinTimeout() {
        return this.rlmLicenseMinTimeout(this.licHandle);
    }
    
    public String getPlatforms() {
        return this.rlmLicensePlatforms(this.licHandle);
    }
    
    public String getProduct() {
        return this.rlmLicenseProduct(this.licHandle);
    }
    
    public String getServer() {
        return this.rlmLicenseServer(this.licHandle);
    }
    
    public int getShare() {
        return this.rlmLicenseShare(this.licHandle);
    }
    
    public int getSoftLimit() {
        return this.rlmLicenseSoftLimit(this.licHandle);
    }
    
    public String getStart() {
        return this.rlmLicenseStart(this.licHandle);
    }
    
    public int getType() {
        return this.rlmLicenseType(this.licHandle);
    }
    
    public String getTeamsURL() {
        return this.rlmLicenseTeams(this.licHandle);
    }
    
    public int getTimezone() {
        return this.rlmLicenseTimezone(this.licHandle);
    }
    
    public int userBased() {
        return this.rlmLicenseUserBased(this.licHandle);
    }
    
    public String getVersion() {
        return this.rlmLicenseVersion(this.licHandle);
    }
    
    public String getLFPath() {
        return this.rlmLicenseGetLFPath(this.licHandle);
    }
    
    public int daysToExpiration() {
        return this.rlmLicenseExpDays(this.licHandle);
    }
    
    public boolean isRoaming() {
        boolean roaming = false;
        if (this.rlmLicenseRoaming(this.licHandle) != 0) {
            roaming = true;
        }
        return roaming;
    }
    
    public int getMaxShare() {
        return this.rlmLicenseMaxShare(this.licHandle);
    }
    
    public int getNamedUserCount() {
        return this.rlmLicenseNamedUserCount(this.licHandle);
    }
    
    public int getNamedUserMinHours() {
        return this.rlmLicenseNamedUserMinHours(this.licHandle);
    }
    
    public String getOptions() {
        return this.rlmLicenseOptions(this.licHandle);
    }
    
    public int getMinCheckout() {
        return this.rlmLicenseMinCheckout(this.licHandle);
    }
    
    public boolean authCheck(final String license) throws RlmException {
        final int stat = this.rlmAuthCheck(this.licHandle, license);
        if (stat != 0) {
            throw new RlmException(stat);
        }
        return true;
    }
    
    public boolean isSingle() {
        boolean single = false;
        if (this.rlmLicenseSingle(this.licHandle) != 0) {
            single = true;
        }
        return single;
    }
    
    public boolean isUncounted() {
        boolean uncounted = false;
        if (this.rlmLicenseUncounted(this.licHandle) != 0) {
            uncounted = true;
        }
        return uncounted;
    }
}
