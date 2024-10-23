package com.reprisesoftware.rlm;

public class RlmLicense implements RlmConstants {
    private long licHandle;
    private boolean valid;

    private native long rlmCheckout(long var1, String var3, String var4, int var5);

    private native long rlmCheckoutProduct(long var1, long var3, String var5, int var6);

    private native int rlmLicenseStat(long var1);

    private native int rlmCheckin(long var1);

    private native int rlmGetAttrHealth(long var1);

    private native int rlmGoodOnce(long var1);

    private native String rlmLicenseAkey(long var1);

    private native String rlmLicenseContract(long var1);

    private native String rlmLicenseCustomer(long var1);

    private native int rlmLicenseCount(long var1);

    private native int rlmLicenseDetachedDemo(long var1);

    private native String rlmLicenseExp(long var1);

    private native String rlmLicenseExpTime(long var1);

    private native int rlmLicenseHold(long var1);

    private native int rlmLicenseHostBased(long var1);

    private native String rlmLicenseHostid(long var1);

    private native int rlmLicenseIsMetered(long var1);

    private native String rlmLicenseIssued(long var1);

    private native String rlmLicenseIssuer(long var1);

    private native String rlmLicenseLineItem(long var1);

    private native int rlmLicenseMaxRoam(long var1);

    private native int rlmLicenseMaxRoamCount(long var1);

    private native int rlmLicenseMeterCounter(long var1);

    private native int rlmLicenseMinRemove(long var1);

    private native int rlmLicenseMinTimeout(long var1);

    private native int rlmLicenseMinCheckout(long var1);

    private native String rlmLicensePlatforms(long var1);

    private native String rlmLicenseProduct(long var1);

    private native String rlmLicenseServer(long var1);

    private native int rlmLicenseSingle(long var1);

    private native int rlmLicenseShare(long var1);

    private native int rlmLicenseSoftLimit(long var1);

    private native String rlmLicenseStart(long var1);

    private native String rlmLicenseTeams(long var1);

    private native int rlmLicenseType(long var1);

    private native int rlmLicenseTimezone(long var1);

    private native int rlmLicenseUncounted(long var1);

    private native int rlmLicenseUserBased(long var1);

    private native String rlmLicenseVersion(long var1);

    private native int rlmLicenseNamedUserCount(long var1);

    private native int rlmLicenseNamedUserMinHours(long var1);

    private native String rlmLicenseGetLFPath(long var1);

    private native int rlmLicenseExpDays(long var1);

    private native int rlmLicenseRoaming(long var1);

    private native int rlmLicenseMaxShare(long var1);

    private native String rlmLicenseOptions(long var1);

    private native int rlmLicenseClientCache(long var1);

    private native int rlmLicenseIsCached(long var1);

    private native int rlmAuthCheck(long var1, String var3);

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
            stat = (int) this.rlmGetAttrHealth(this.licHandle);
            return stat;
        } else {
            throw new RlmException(-19);
        }
    }

    public String getActKey() {
        return this.rlmLicenseAkey(this.licHandle);
    }

    public boolean goodOnce() {
        boolean ret = false;
        int stat = this.rlmGoodOnce(this.licHandle);
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
        int metered = this.rlmLicenseIsMetered(this.licHandle);
        return metered != 0;
    }

    public String getIssuer() {
        return this.rlmLicenseIssuer(this.licHandle);
    }

    public boolean isCached() {
        int cached = this.rlmLicenseIsCached(this.licHandle);
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

    public boolean authCheck(String license) throws RlmException {
        int stat = this.rlmAuthCheck(this.licHandle, license);
        if (stat != 0) {
            throw new RlmException(stat);
        } else {
            return true;
        }
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
