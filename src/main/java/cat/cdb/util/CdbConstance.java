package cat.cdb.util;

import java.math.BigDecimal;

public class CdbConstance {

	// cdb status code

	public final static String RESPONE_CODE_SUCCESS = "SUCCESS";
	public final static String RESPONE_CODE_FAIL = "FAIL";
	public final static String RESPONE_CODE_NOTMATCH = "NOTMATCH";
	public final static String RESPONE_CODE_DUPLICATE = "DUPLICATE-REQUEST";
	public final static String RESPONE_CODE_PARAMETER_INVALID = "BAD-REQUEST";

	public final static String CUSTOMER_ACCOUNT_TYPE_INDIVIDUAL_STRING = "individual";
	public final static String CUSTOMER_ACCOUNT_TYPE_ORGANIZATION_STRING = "organization";
	public final static String CUSTOMER_NUMBER_SEQUENCE = "CUSTOMER_NUMBER_SEQ";
	public final static String SUBSCR_NO_SEQUENCE = "SUBSCR_SEQ";
	public final static String SVC_EXT_SEQUENCE = "SVC_EXT_SEQ";
	// change blacklist to block 2018 Nov 30
	public final static String CUSTOMER_TYPE_BLOCK = "301B9B60C6344A3E8C7269FB028A8370";
	public final static String CUSTOMER_TYPE_BLACKLIST = "7C4B78C9574272D0E05400144F68ACCC";

	// Permit Zone "my"
	public final static Integer ZONE_MY_PUBLIC_02 = new Integer(0);
	public final static Integer ZONE_MY_BLOCK_01 = new Integer(1);
	public final static String VERIFIED_IDENTITY_PASS = "Y";
	public final static String VERIFIED_IDENTITY_NOPASS = "N";

	public final static String RESP_TH_PASS_ZONE1 = "ท่านได้ลงทะเบียนด้วยระบบอัตลักษณ์ถูกต้องแล้ว";
	public final static String RESP_EN_PASS_ZONE1 = "Your sim card is registered via biometric registration already";

	public final static String RESP_TH_NOPASS_ZONE1 = "ท่านยังไม่ได้ลงทะเบียนด้วยระบบอัตลักษณ์ติดต่อศูนย์ให้บริการ สอบถาม 1322";
	public final static String RESP_EN_NOPASS_ZONE1 = "Your sim card has not been registered via biometric registration,call 1322";
	public final static String RESP_TH_INVALID_IDCARD_NOTMATCH = "เลขปชช.ของท่านไม่ตรงกับที่ลงทะเบียนไว้ ติดต่อศูนย์ให้บริการ สอบถาม 1322";
	public final static String RESP_EN_INVALID_IDCARD_NOTMATCH = "If your passport no. registration is not valid in registration database, call 1322";
	public final static String RESP_TH_CORPORATE_NUMBER = "หมายเลขของท่านลงทะเบียนในนามนิติบุคคล สามารถใช้งานได้ปกติ";
	public final static String RESP_EN_CORPORATE_NUMBER = "Your sim card is registered in corporate number";

	// public final static String RESP_PASS_VERIFIED_IDENDTITY="หมายเลข
	// {0}ผ่านการยืนยันอัตลักษณ์";
	public final static String RESP_PASS_VERIFIED_IDENDTITY_NOPASS_ZONE1 = "หมายเลข {0}ผ่านการยืนยันอัตลักษณ์แต่ไม่สามารถใช้งาน 3 จว.ชายแดนใต้ได้หากต้องการใช้งานในพื้นที่ 3 จังหวัดภาคใต้ให้กดรหัส USSD *165*6*ID 13 หลัก# และโทรออก ";

	public final static String RESP_NOPASS_VERIFIED_PARAMETER_INVALID = "Parameter Invalid";

	public static class INTERFACE_SOURCE {
		public final static String USSD = "USSD";
		public final static String TWOSHOT = "2SHOT";
		public final static String SMS = "SMS";
	}
}
