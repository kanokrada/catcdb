package cat.cdb.domain.crmdata;
 
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "CAT_SVC", schema = "CRMDATA", catalog = "CRMDATA")
@JsonIgnoreProperties({ "dirty_property_names", "errors", "dirty", "attached", "version" })
public class CatSvc {
	@Id
	private String catSvcId;
	private String catBillAcctId;
	private BigDecimal catSvcTypeLkp;
	private Integer obsoleteFlag;
	private BigDecimal revision;
	private String esbSvcId;
	private BigDecimal catSvcStatusLkp;
	private String catBillInstanceId;
	private Date startDate;
	private Date endDate;
	private String displayName;
	private String catLastOrderItemId;
	private String productId;
	private String catProperty;
	private String customerId;
	@Column(name = "CAT_VIEW_ID_1")
	private String catViewId1;
	@Column(name = "CAT_VIEW_ID_2")
	private String catViewId2;
	Date updateDate;
	@Column(name = "CAT_SVC_ACCT_ADDR_ID_1")
	private String catSvcAcctAddrId1;
	@Column(name = "CAT_SVC_ACCT_ADDR_ID_2")
	private String catSvcAcctAddrId2;
	@Column(name = "CAT_CONTACT_PERSON_ID_1")
	private String catContactPersonId1;
	@Column(name = "CAT_CONTACT_PERSON_ID_2")
	private String catContactPersonId2;
	private String updateBy;
	private BigDecimal svcPendingFlag;
	private BigDecimal prevStatusLkp;
	private String remark;
	private String dealer;
	private Date savedDate;
	private String savedBy;
	private String catMnpOperator;
	private String catMnpOrderId;
	private String catMnpPortInId;
	private String catMnpPortOutOrderId;
	private String catMnpPortOutId;
	private String catMnpPortOutOperator;
	private String catMnpFirstName;
	private String catMnpLastName;
	private String catMnpCompanyName;
	private String catDealerCode;
	private String userId;
	private String sapCostCenter;
	private String revRcvCostCtr;
	private String eTerritoryAgentId;
	private String empId; // add by Komsan 2015 07 19
	private String cssCatId;
	private String projectPartnerCode;
	private String reasonLkp;
	private BigDecimal chernSvcStatusLkp;
	private String subscrNo;
	private String holderNumber;
	private String imageIdentityId;
	private Integer permitZone;
	private String verifiedIdentity;
	private Date permitZoneDate;
	private Date verifiedIdentityDate;
	

	public String getCatSvcId() {
		return catSvcId;
	}
	public void setCatSvcId(String catSvcId) {
		this.catSvcId = catSvcId;
	}
	public String getCatBillAcctId() {
		return catBillAcctId;
	}
	public void setCatBillAcctId(String catBillAcctId) {
		this.catBillAcctId = catBillAcctId;
	}
	public BigDecimal getCatSvcTypeLkp() {
		return catSvcTypeLkp;
	}
	public void setCatSvcTypeLkp(BigDecimal catSvcTypeLkp) {
		this.catSvcTypeLkp = catSvcTypeLkp;
	}
	public Integer getObsoleteFlag() {
		return obsoleteFlag;
	}
	public void setObsoleteFlag(Integer obsoleteFlag) {
		this.obsoleteFlag = obsoleteFlag;
	}
	public BigDecimal getRevision() {
		return revision;
	}
	public void setRevision(BigDecimal revision) {
		this.revision = revision;
	}
	public String getEsbSvcId() {
		return esbSvcId;
	}
	public void setEsbSvcId(String esbSvcId) {
		this.esbSvcId = esbSvcId;
	}
	public BigDecimal getCatSvcStatusLkp() {
		return catSvcStatusLkp;
	}
	public void setCatSvcStatusLkp(BigDecimal catSvcStatusLkp) {
		this.catSvcStatusLkp = catSvcStatusLkp;
	}
	public String getCatBillInstanceId() {
		return catBillInstanceId;
	}
	public void setCatBillInstanceId(String catBillInstanceId) {
		this.catBillInstanceId = catBillInstanceId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getCatLastOrderItemId() {
		return catLastOrderItemId;
	}
	public void setCatLastOrderItemId(String catLastOrderItemId) {
		this.catLastOrderItemId = catLastOrderItemId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getCatProperty() {
		return catProperty;
	}
	public void setCatProperty(String catProperty) {
		this.catProperty = catProperty;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCatViewId1() {
		return catViewId1;
	}
	public void setCatViewId1(String catViewId1) {
		this.catViewId1 = catViewId1;
	}
	public String getCatViewId2() {
		return catViewId2;
	}
	public void setCatViewId2(String catViewId2) {
		this.catViewId2 = catViewId2;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getCatSvcAcctAddrId1() {
		return catSvcAcctAddrId1;
	}
	public void setCatSvcAcctAddrId1(String catSvcAcctAddrId1) {
		this.catSvcAcctAddrId1 = catSvcAcctAddrId1;
	}
	public String getCatSvcAcctAddrId2() {
		return catSvcAcctAddrId2;
	}
	public void setCatSvcAcctAddrId2(String catSvcAcctAddrId2) {
		this.catSvcAcctAddrId2 = catSvcAcctAddrId2;
	}
	public String getCatContactPersonId1() {
		return catContactPersonId1;
	}
	public void setCatContactPersonId1(String catContactPersonId1) {
		this.catContactPersonId1 = catContactPersonId1;
	}
	public String getCatContactPersonId2() {
		return catContactPersonId2;
	}
	public void setCatContactPersonId2(String catContactPersonId2) {
		this.catContactPersonId2 = catContactPersonId2;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public BigDecimal getSvcPendingFlag() {
		return svcPendingFlag;
	}
	public void setSvcPendingFlag(BigDecimal svcPendingFlag) {
		this.svcPendingFlag = svcPendingFlag;
	}
	public BigDecimal getPrevStatusLkp() {
		return prevStatusLkp;
	}
	public void setPrevStatusLkp(BigDecimal prevStatusLkp) {
		this.prevStatusLkp = prevStatusLkp;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDealer() {
		return dealer;
	}
	public void setDealer(String dealer) {
		this.dealer = dealer;
	}
	public Date getSavedDate() {
		return savedDate;
	}
	public void setSavedDate(Date savedDate) {
		this.savedDate = savedDate;
	}
	public String getSavedBy() {
		return savedBy;
	}
	public void setSavedBy(String savedBy) {
		this.savedBy = savedBy;
	}
	public String getCatMnpOperator() {
		return catMnpOperator;
	}
	public void setCatMnpOperator(String catMnpOperator) {
		this.catMnpOperator = catMnpOperator;
	}
	public String getCatMnpOrderId() {
		return catMnpOrderId;
	}
	public void setCatMnpOrderId(String catMnpOrderId) {
		this.catMnpOrderId = catMnpOrderId;
	}
	public String getCatMnpPortInId() {
		return catMnpPortInId;
	}
	public void setCatMnpPortInId(String catMnpPortInId) {
		this.catMnpPortInId = catMnpPortInId;
	}
	public String getCatMnpPortOutOrderId() {
		return catMnpPortOutOrderId;
	}
	public void setCatMnpPortOutOrderId(String catMnpPortOutOrderId) {
		this.catMnpPortOutOrderId = catMnpPortOutOrderId;
	}
	public String getCatMnpPortOutId() {
		return catMnpPortOutId;
	}
	public void setCatMnpPortOutId(String catMnpPortOutId) {
		this.catMnpPortOutId = catMnpPortOutId;
	}
	public String getCatMnpPortOutOperator() {
		return catMnpPortOutOperator;
	}
	public void setCatMnpPortOutOperator(String catMnpPortOutOperator) {
		this.catMnpPortOutOperator = catMnpPortOutOperator;
	}
	public String getCatMnpFirstName() {
		return catMnpFirstName;
	}
	public void setCatMnpFirstName(String catMnpFirstName) {
		this.catMnpFirstName = catMnpFirstName;
	}
	public String getCatMnpLastName() {
		return catMnpLastName;
	}
	public void setCatMnpLastName(String catMnpLastName) {
		this.catMnpLastName = catMnpLastName;
	}
	public String getCatMnpCompanyName() {
		return catMnpCompanyName;
	}
	public void setCatMnpCompanyName(String catMnpCompanyName) {
		this.catMnpCompanyName = catMnpCompanyName;
	}
	public String getCatDealerCode() {
		return catDealerCode;
	}
	public void setCatDealerCode(String catDealerCode) {
		this.catDealerCode = catDealerCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSapCostCenter() {
		return sapCostCenter;
	}
	public void setSapCostCenter(String sapCostCenter) {
		this.sapCostCenter = sapCostCenter;
	}
	public String getRevRcvCostCtr() {
		return revRcvCostCtr;
	}
	public void setRevRcvCostCtr(String revRcvCostCtr) {
		this.revRcvCostCtr = revRcvCostCtr;
	}
	public String geteTerritoryAgentId() {
		return eTerritoryAgentId;
	}
	public void seteTerritoryAgentId(String eTerritoryAgentId) {
		this.eTerritoryAgentId = eTerritoryAgentId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getCssCatId() {
		return cssCatId;
	}
	public void setCssCatId(String cssCatId) {
		this.cssCatId = cssCatId;
	}
	public String getProjectPartnerCode() {
		return projectPartnerCode;
	}
	public void setProjectPartnerCode(String projectPartnerCode) {
		this.projectPartnerCode = projectPartnerCode;
	}
	public String getReasonLkp() {
		return reasonLkp;
	}
	public void setReasonLkp(String reasonLkp) {
		this.reasonLkp = reasonLkp;
	}
	public BigDecimal getChernSvcStatusLkp() {
		return chernSvcStatusLkp;
	}
	public void setChernSvcStatusLkp(BigDecimal chernSvcStatusLkp) {
		this.chernSvcStatusLkp = chernSvcStatusLkp;
	}
	public String getSubscrNo() {
		return subscrNo;
	}
	public void setSubscrNo(String subscrNo) {
		this.subscrNo = subscrNo;
	}
	public String getHolderNumber() {
		return holderNumber;
	}
	public void setHolderNumber(String holderNumber) {
		this.holderNumber = holderNumber;
	}
	public String getImageIdentityId() {
		return imageIdentityId;
	}
	public void setImageIdentityId(String imageIdentityId) {
		this.imageIdentityId = imageIdentityId;
	}
	public Integer getPermitZone() {
		return permitZone;
	}
	public void setPermitZone(Integer permitZone) {
		this.permitZone = permitZone;
	}
	public String getVerifiedIdentity() {
		return verifiedIdentity;
	}
	public void setVerifiedIdentity(String verifiedIdentity) {
		this.verifiedIdentity = verifiedIdentity;
	}
	public Date getPermitZoneDate() {
		return permitZoneDate;
	}
	public void setPermitZoneDate(Date permitZoneDate) {
		this.permitZoneDate = permitZoneDate;
	}
	public Date getVerifiedIdentityDate() {
		return verifiedIdentityDate;
	}
	public void setVerifiedIdentityDate(Date verifiedIdentityDate) {
		this.verifiedIdentityDate = verifiedIdentityDate;
	}
}
