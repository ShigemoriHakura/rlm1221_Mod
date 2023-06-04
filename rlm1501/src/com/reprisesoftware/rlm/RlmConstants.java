// 
// Decompiled by Procyon v0.5.36
// 

package com.reprisesoftware.rlm;

public interface RlmConstants
{
    public static final int RLM_EL_NOPRODUCT = -1;
    public static final int RLM_EL_NOTME = -2;
    public static final int RLM_EL_EXPIRED = -3;
    public static final int RLM_EL_NOTTHISHOST = -4;
    public static final int RLM_EL_BADKEY = -5;
    public static final int RLM_EL_BADVER = -6;
    public static final int RLM_EL_BADDATE = -7;
    public static final int RLM_EL_TOOMANY = -8;
    public static final int RLM_EL_NOAUTH = -9;
    public static final int RLM_EL_ON_EXC_ALL = -10;
    public static final int RLM_EL_ON_EXC = -11;
    public static final int RLM_EL_NOT_INC_ALL = -12;
    public static final int RLM_EL_NOT_INC = -13;
    public static final int RLM_EL_OVER_MAX = -14;
    public static final int RLM_EL_REMOVED = -15;
    public static final int RLM_EL_SERVER_BADRESP = -16;
    public static final int RLM_EL_COMM_ERROR = -17;
    public static final int RLM_EL_NO_SERV_SUPP = -18;
    public static final int RLM_EL_NOHANDLE = -19;
    public static final int RLM_EL_SERVER_DOWN = -20;
    public static final int RLM_EL_NO_HEARTBEAT = -21;
    public static final int RLM_EL_ALLINUSE = -22;
    public static final int RLM_EL_NOHOSTID = -23;
    public static final int RLM_EL_TIMEDOUT = -24;
    public static final int RLM_EL_INQUEUE = -25;
    public static final int RLM_EL_SYNTAX = -26;
    public static final int RLM_EL_ROAM_TOOLONG = -27;
    public static final int RLM_EL_NO_SERV_HANDLE = -28;
    public static final int RLM_EL_ON_EXC_ROAM = -29;
    public static final int RLM_EL_NOT_INC_ROAM = -30;
    public static final int RLM_EL_TOOMANY_ROAMING = -31;
    public static final int RLM_EL_WILL_EXPIRE = -32;
    public static final int RLM_EL_ROAMFILEERR = -33;
    public static final int RLM_EL_RLM_ROAM_ERR = -34;
    public static final int RLM_EL_WRONG_PLATFORM = -35;
    public static final int RLM_EL_WRONG_TZ = -36;
    public static final int RLM_EL_NOT_STARTED = -37;
    public static final int RLM_EL_CANT_GET_DATE = -38;
    public static final int RLM_EL_OVERSOFT = -39;
    public static final int RLM_EL_WINDBACK = -40;
    public static final int RLM_EL_BADPARAM = -41;
    public static final int RLM_EL_NOROAM_FAILOVER = -42;
    public static final int RLM_EL_BADHOST = -43;
    public static final int RLM_EL_APP_INACTIVE = -44;
    public static final int RLM_EL_NOT_NAMED_USER = -45;
    public static final int RLM_EL_TS_DISABLED = -46;
    public static final int RLM_EL_VM_DISABLED = -47;
    public static final int RLM_EL_PORTABLE_REMOVED = -48;
    public static final int RLM_EL_DEMOEXP = -49;
    public static final int RLM_EL_FAILED_BACK_UP = -50;
    public static final int RLM_EL_SERVER_LOST_XFER = -51;
    public static final int RLM_EL_BAD_PASSWORD = -52;
    public static final int RLM_EL_METER_NO_SERVER = -53;
    public static final int RLM_EL_METER_NOCOUNT = -54;
    public static final int RLM_EL_NOROAM_TRANSIENT = -55;
    public static final int RLM_EL_CANTRECONNECT = -56;
    public static final int RLM_EL_NONE_CANROAM = -57;
    public static final int RLM_EL_SERVER_TOO_OLD = -58;
    public static final int RLM_EL_SERVER_REJECT = -59;
    public static final int RLM_EL_REQ_OPT_MISSING = -60;
    public static final int RLM_EL_NO_DYNRES = -61;
    public static final int RLM_EL_RECONN_INFO_BAD = -62;
    public static final int RLM_EL_ALREADY_ROAMING = -63;
    public static final int RLM_EL_BAD_EXTEND_FMT = -64;
    public static final int RLM_EL_BAD_EXTEND_CODE = -65;
    public static final int RLM_EL_NO_ROAM_TO_EXTEND = -66;
    public static final int RLM_EH_NOHANDLE = -101;
    public static final int RLM_EH_READ_NOLICENSE = -102;
    public static final int RLM_EH_NET_INIT = -103;
    public static final int RLM_EH_NET_WERR = -104;
    public static final int RLM_EH_NET_RERR = -105;
    public static final int RLM_EH_NET_BADRESP = -106;
    public static final int RLM_EH_BADHELLO = -107;
    public static final int RLM_EH_BADPRIVKEY = -108;
    public static final int RLM_EH_SIGERROR = -109;
    public static final int RLM_EH_INTERNAL = -110;
    public static final int RLM_EH_CONN_REFUSED = -111;
    public static final int RLM_EH_NOSERVER = -112;
    public static final int RLM_EH_BADHANDSHAKE = -113;
    public static final int RLM_EH_CANTGETETHER = -114;
    public static final int RLM_EH_MALLOC = -115;
    public static final int RLM_EH_BIND = -116;
    public static final int RLM_EH_SOCKET = -117;
    public static final int RLM_EH_BADPUBKEY = -118;
    public static final int RLM_EH_AUTHFAIL = -119;
    public static final int RLM_EH_WRITE_LF = -120;
    public static final int RLM_EH_NO_REPORTLOG = -121;
    public static final int RLM_EH_DUP_ISV_HID = -122;
    public static final int RLM_EH_BADPARAM = -123;
    public static final int RLM_EH_ROAMWRITEERR = -124;
    public static final int RLM_EH_ROAMREADERR = -125;
    public static final int RLM_EH_HANDLER_INSTALLED = -126;
    public static final int RLM_EH_CANTCREATLOCK = -127;
    public static final int RLM_EH_CANTOPENLOCK = -128;
    public static final int RLM_EH_CANTSETLOCK = -129;
    public static final int RLM_EH_BADRLMLIC = -130;
    public static final int RLM_EH_BADHOST = -131;
    public static final int RLM_EH_CANTCONNECT_URL = -132;
    public static final int RLM_EH_OP_NOT_ALLOWED = -133;
    public static final int RLM_EH_ACT_BADSTAT = -134;
    public static final int RLM_EH_BADLICKEY = -135;
    public static final int RLM_EH_BAD_HTTP = -136;
    public static final int RLM_EH_DEMOEXISTS = -137;
    public static final int RLM_EH_DEMOWRITEERR = -138;
    public static final int RLM_EH_NO_DEMO_LIC = -139;
    public static final int RLM_EH_NO_RLM_PLATFORM = -140;
    public static final int RLM_EH_EVAL_EXPIRED = -141;
    public static final int RLM_EH_SERVER_REJECT = -142;
    public static final int RLM_EH_UNLICENSED = -143;
    public static final int RLM_EH_SEMAPHORE_FAILURE = -144;
    public static final int RLM_EH_ACT_OLDSERVER = -145;
    public static final int RLM_EH_BAD_LIC_LINE = -146;
    public static final int RLM_EH_BAD_SERVER_HOSTID = -147;
    public static final int RLM_EH_NO_REHOST_TOP_DIR = -148;
    public static final int RLM_EH_CANT_GET_REHOST = -149;
    public static final int RLM_EH_CANT_DEL_REHOST = -150;
    public static final int RLM_EH_CANT_CREATE_REHOST = -151;
    public static final int RLM_EH_REHOST_TOP_DIR_EXISTS = -152;
    public static final int RLM_EH_REHOST_EXISTS = -153;
    public static final int RLM_EH_NO_FULFILLMENTS = -154;
    public static final int RLM_EH_METER_READERR = -155;
    public static final int RLM_EH_METER_WRITEERR = -156;
    public static final int RLM_EH_METER_BADINCREMENT = -157;
    public static final int RLM_EH_METER_NO_COUNTER = -158;
    public static final int RLM_EH_ACT_UNLICENSED = -159;
    public static final int RLM_EH_ACTPRO_UNLICENSED = -160;
    public static final int RLM_EH_SERVER_REQUIRED = -161;
    public static final int RLM_EH_DATE_REQUIRED = -162;
    public static final int RLM_EH_NO_METER_UPGRADE = -163;
    public static final int RLM_EH_NO_CLIENT = -164;
    public static final int RLM_EH_NO_DISCONN = -165;
    public static final int RLM_EH_NO_FILES = -166;
    public static final int RLM_EH_NO_BROADCAST_RESP = -167;
    public static final int RLM_EH_NO_BROADCAST_HOST = -168;
    public static final int RLM_EH_SERVER_TOO_OLD = -169;
    public static final int RLM_EH_BADLIC_FROM_SERVER = -170;
    public static final int RLM_EH_NO_LIC_FROM_SERVER = -171;
    public static final int RLM_EH_CACHEWRITEERR = -172;
    public static final int RLM_EH_CACHEREADERR = -173;
    public static final int RLM_EH_LIC_WITH_NEW_KEYWORDS = -174;
    public static final int RLM_EH_NO_ISV = -175;
    public static final int RLM_EH_NO_CUSTOMER = -176;
    public static final int RLM_EH_NO_SQL = -177;
    public static final int RLM_EH_ONLY_LOCAL_CMDS = -178;
    public static final int RLM_EH_SERVER_TIMEOUT = 179;
    public static final int RLM_EH_NONE_SIGNED = 180;
    public static final int RLM_EH_DUP_XFER = 181;
    public static final int RLM_ACT_BADPARAM = -1001;
    public static final int RLM_ACT_NO_KEY = -1002;
    public static final int RLM_ACT_NO_PROD = -1003;
    public static final int RLM_ACT_CANT_WRITE_KEYS = -1004;
    public static final int RLM_ACT_KEY_USED = -1005;
    public static final int RLM_ACT_BAD_HOSTID = -1006;
    public static final int RLM_ACT_BAD_HOSTID_TYPE = -1007;
    public static final int RLM_ACT_BAD_HTTP = -1008;
    public static final int RLM_ACT_CANTLOCK = -1009;
    public static final int RLM_ACT_CANTREAD_DB = -1010;
    public static final int RLM_ACT_CANT_WRITE_FULFILL = -1011;
    public static final int RLM_ACT_CLIENT_TIME_BAD = -1012;
    public static final int RLM_ACT_BAD_REDIRECT = -1013;
    public static final int RLM_ACT_TOOMANY_HOSTID_CHANGES = -1014;
    public static final int RLM_ACT_BLACKLISTED = -1015;
    public static final int RLM_ACT_NOT_WHITELISTED = -1016;
    public static final int RLM_ACT_KEY_EXPIRED = -1017;
    public static final int RLM_ACT_NO_PERMISSION = -1018;
    public static final int RLM_ACT_SERVER_ERROR = -1019;
    public static final int RLM_ACT_BAD_GENERATOR = -1020;
    public static final int RLM_ACT_NO_KEY_MATCH = -1021;
    public static final int RLM_ACT_NO_AUTH_SUPPLIED = -1022;
    public static final int RLM_ACT_PROXY_AUTH_FAILED = -1023;
    public static final int RLM_ACT_NO_BASIC_AUTH = -1024;
    public static final int RLM_ACT_GEN_UNLICENSED = -1025;
    public static final int RLM_ACT_DB_READERR = -1026;
    public static final int RLM_ACT_GEN_PARAM_ERR = -1027;
    public static final int RLM_ACT_UNSUPPORTED_CMD = -1028;
    public static final int RLM_ACT_REVOKE_TOOLATE = -1029;
    public static final int RLM_ACT_KEY_DISABLED = -1030;
    public static final int RLM_ACT_KEY_NO_HOSTID = -1031;
    public static final int RLM_ACT_KEY_HOSTID_REVOKED = -1032;
    public static final int RLM_ACT_NO_FULFILLMENTS = -1033;
    public static final int RLM_ACT_LICENSE_TOOBIG = -1034;
    public static final int RLM_ACT_NO_REHOST = -1035;
    public static final int RLM_ACT_BAD_URL = -1036;
    public static final int RLM_ACT_NO_LICENSES = -1037;
    public static final int RLM_ACT_NO_CLEAR = -1038;
    public static final int RLM_ACT_BAD_KEY = -1039;
    public static final int RCC_CANT_WRITE_FULFILL = -1040;
    public static final int RCC_PORTAL_CANT_WRITE_FULFILL = -1041;
    public static final int RLM_ACT_KEY_TOOMANY = -1042;
    public static final int RLM_ACT_SUB_BADTYPE = -1043;
    public static final int RLM_ACT_REVOKE_REFERENCE = 1;
    public static final int RLM_ACT_REVOKE_NOFULFILL = 2;
    public static final int RLM_ACT_REVOKE_NODEL = 4;
    public static final int RLM_HOSTID_32BIT = 1;
    public static final int RLM_HOSTID_STRING = 2;
    public static final int RLM_HOSTID_ETHER = 3;
    public static final int RLM_HOSTID_USER = 4;
    public static final int RLM_HOSTID_HOST = 5;
    public static final int RLM_HOSTID_IP = 6;
    public static final int RLM_HOSTID_ANY = 7;
    public static final int RLM_HOSTID_DEMO = 8;
    public static final int RLM_HOSTID_INVALID = 9;
    public static final int RLM_HOSTID_SN = 10;
    public static final int RLM_HOSTID_RLMID1 = 11;
    public static final int RLM_HOSTID_DISKSN = 14;
    public static final int RLM_HOSTID_REHOST = 15;
    public static final int RLM_HOSTID_GC = 16;
    public static final int RLM_HOSTID_ASH = 17;
    public static final int RLM_HOSTID_ISV = 18;
    public static final int RLM_HOSTID_IPV6 = 19;
    public static final int RLM_HOSTID_UUID = 20;
    public static final int RLM_MAX_HOSTID_STRING = 76;
    public static final int RLM_MAX_LOG = 256;
    public static final int RLM_MAX_LINE = 1024;
    public static final int RLM_LA_BETA_TYPE = 1;
    public static final int RLM_LA_EVAL_TYPE = 2;
    public static final int RLM_LA_DEMO_TYPE = 4;
    public static final int RLM_LA_SHARE_USER = 1;
    public static final int RLM_LA_SHARE_HOST = 2;
    public static final int RLM_LA_SHARE_ISV = 4;
    public static final int RLM_ACT_LT_FLOATING = 0;
    public static final int RLM_ACT_LT_F_UPGRADE = 4;
    public static final int RLM_ACT_LT_UNCOUNTED = 1;
    public static final int RLM_ACT_LT_NLU_UPGRADE = 5;
    public static final int RLM_ACT_LT_SINGLE = 3;
    public static final int RLM_ACT_LT_S_UPGRADE = 7;
    public static final int RLM_TEMP_LT_UNCOUNTED = 1;
    public static final int RLM_TEMP_LT_SINGLE = 2;
}
