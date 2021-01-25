package com.reprisesoftware.rlm;





public class RlmException
  extends Exception
{
  private int code;
  


  RlmHandle handle;
  


  RlmLicense license;
  


  String message;
  



  private native void rlmErrstring(long paramLong1, long paramLong2, byte[] paramArrayOfByte);
  



  protected RlmException(int code)
  {
    this.code = code;
  }
  
  protected RlmException(int code, RlmHandle handle, RlmLicense license) {
    this.handle = handle;
    this.license = license;
    this.code = code;
  }
  
  protected RlmException(int code, RlmHandle handle) {
    this.handle = handle;
    license = null;
    this.code = code;
  }
  




  public int getCode()
  {
    return code;
  }
  




  public String getMessage()
  {
    String ret = null;
    if ((handle == null) && (license == null)) {
      ret = new String("RlmException " + code);
    }
    else {
      byte[] errString = new byte['ȁ'];
      long h = 0L;
      long l = 0L;
      if (handle != null) {
        h = handle.getHandle();
      }
      if (license != null) {
        l = license.getLicenseHandle();
      }
      rlmErrstring(h, l, errString);
      ret = new String(errString).trim();
    }
    return ret;
  }
}
