package cat.cdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cat.cdb.domain.crmdata.CdbTransactionSequence;

public interface CdbTransactionSequenceRepository extends JpaRepository<CdbTransactionSequence, Long> {

	@Query(value = " SELECT CAST(SYS_GUID() AS VARCHAR2(120)) FROM DUAL", nativeQuery = true)
	String getNEXTRAWID();

	// CRMDATA
	@Query(value = " SELECT CRMDATA.TRANSACTION_ID_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	Long getNextCdbTransactionId();

	@Query(value = " SELECT CRMDATA.SVC_EXT_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	Long getNextCrmSvcExtentionId();

	@Query(value = " SELECT CRMDATA.CA_NUMBER.NEXTVAL FROM DUAL", nativeQuery = true)
	Long getNextCrmCaNumber();

	@Query(value = " SELECT CRMDATA.SUBSCR_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	Long getNextCrmSubscrNo();

	@Query(value = " SELECT CRMDATA.PARTNER_PROJECT_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	Long getNextCrmPartnerProject();

	@Query(value = " SELECT CRMDATA.DEALER_POSTFIX_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	Long getNextCrmDealerPostfix();

	@Query(value = " SELECT CRMDATA.PROJECT_POSTFIX_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	Long getNextCrmProjectPostfixSeq();

	@Query(value = " SELECT CRMDATA.TG_BF_HOLDER_CREATE.NEXTVAL FROM DUAL", nativeQuery = true)
	Long getNextCrmSvcHolderId();

	// CRMAPP
	@Query(value = " SELECT CRMAPP.CUSTOMER_ACCOUNT_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	Long getNextCrmAppCustomerId();

	@Query(value = " SELECT CRMAPP.BILLING_ACCOUNT_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	Long getNextCrmAppBillngId();

	@Query(value = " SELECT CRMAPP.CAT_BILL_ACCT_NUMBER_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	Long getNextCrmAppBillNumber();

	@Query(value = " SELECT CRMAPP.SERVICE_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	Long getNextCrmAppServiceId();

	@Query(value = " SELECT CRMAPP.PACKAGE_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	Long getNextCrmAppPackageId();

	@Query(value = " SELECT CRMAPP.COMPONENT_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	Long getNextCrmAppComponentId();

	// PMS
	@Query(value = " SELECT PMS.PM_ACCOUNT_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	Long getNextPmAppPartnerId();

	@Query(value = " SELECT PMS.PM_AGREEMENT_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	Long getNextPmAppAgreementId();

	@Query(value = " SELECT PMS.PM_SAA_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	Long getNextPmAppSaaId();
}
