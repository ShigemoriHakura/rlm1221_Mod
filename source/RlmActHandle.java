package com.reprisesoftware.rlm;



























public class RlmActHandle
  implements RlmConstants
{
  private static int RLM_ACT_HANDLE_ISV = 1;
  private static int RLM_ACT_HANDLE_HOSTID_LIST = 2;
  private static int RLM_ACT_HANDLE_HOSTNAME = 3;
  private static int RLM_ACT_HANDLE_EXTRA = 4;
  private static int RLM_ACT_HANDLE_LOG = 5;
  private static int RLM_ACT_HANDLE_REHOST = 6;
  private long actHandleL;
  
  private static native long rlmActNewHandle(long paramLong);
  
  private static native void rlmActDestroyHandle(long paramLong);
  
  private static native int rlmActSetHandle(long paramLong, int paramInt, String paramString);
  
  private static native int rlmActSetHandleInt(long paramLong, int paramInt1, int paramInt2);
  
  public RlmActHandle(RlmHandle rh) {
    rlmHandle = rh;
    rlmHandleL = rh.getHandle();
    actHandleL = rlmActNewHandle(rlmHandleL);
  }
  




  public void setExtra(String extra)
    throws RlmException
  {
    int stat = rlmActSetHandle(actHandleL, RLM_ACT_HANDLE_EXTRA, extra);
    if (stat != 0) {
      throw new RlmException(stat, rlmHandle);
    }
  }
  



  public void setHostidList(String hostidList)
    throws RlmException
  {
    int stat = rlmActSetHandle(actHandleL, RLM_ACT_HANDLE_HOSTID_LIST, hostidList);
    
    if (stat != 0) {
      throw new RlmException(stat, rlmHandle);
    }
  }
  


  public void setHostname(String hostname)
    throws RlmException
  {
    int stat = rlmActSetHandle(actHandleL, RLM_ACT_HANDLE_HOSTNAME, hostname);
    
    if (stat != 0) {
      throw new RlmException(stat, rlmHandle);
    }
  }
  



  public void setLogString(String logString)
    throws RlmException
  {
    int stat = rlmActSetHandle(actHandleL, RLM_ACT_HANDLE_LOG, logString);
    
    if (stat != 0) {
      throw new RlmException(stat, rlmHandle);
    }
  }
  



  public void setISV(String ISV)
    throws RlmException
  {
    int stat = rlmActSetHandle(actHandleL, RLM_ACT_HANDLE_ISV, ISV);
    
    if (stat != 0) {
      throw new RlmException(stat, rlmHandle);
    }
  }
  

  private long rlmHandleL;
  
  private RlmHandle rlmHandle;
  
  public void setRehostable(boolean rehostable)
  {
    rlmActSetHandleInt(actHandleL, RLM_ACT_HANDLE_REHOST, rehostable ? 1 : 0);
  }
  
  protected long getHandle()
  {
    return actHandleL;
  }
  
  protected void finalize() {
    rlmActDestroyHandle(actHandleL);
  }
}
