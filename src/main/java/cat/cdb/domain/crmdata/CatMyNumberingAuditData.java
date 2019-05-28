package cat.cdb.domain.crmdata;
 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "CAT_MY_NUMBERING_AUDIT_DATA", schema = "CRMDATA", catalog = "CRMDATA")
@JsonIgnoreProperties({ "dirty_property_names", "errors", "dirty", "attached", "version" })
public class CatMyNumberingAuditData {
	@Id
	private String catSvcId;
	private String mobileNo;
	private String registerDocTypeCode;
	private String registerDocTypeDesc;
	private String registerDocType;
	private String registerDocNo;
	private String registerName;
	private String registerAddress;
	private String registerDate;
	private String activeDate;
	private String serviceType;
	private String statusCode;
	private String deactiveDate;
	private String sellerName;
	private String sellerAddress;
	private String verifiedIdentity;
	private String registerByApp;
	private String remark;
	private String startDateBegin;
	private String startDateEnd;
	private String type;
	private String mdn;
	private String iccid;
	private String sapCode;
	private Date startDate;
	private Date endDate;
	private String dealerCode;
	private String divisionCode;
	private String divisionDesc;
	private String divisionFull;
	private String departmentCode;
	private String departmentDesc;
	private String departmentFull;
	private String activateUrlImg;
	private String infoStatus;
	private String customerId;
	private String id;
	private Date createDate;
	private Date updateDate;
	private String createBy;
	private String updateBy;
	private String customerNumber;
	private String billingAccountNo;
	private String subscrNo;
	private Integer permitZone;
	private String holderNumber;
	private String imageIdentityId;
	private Date permitZoneDate;
	private String activateBy;
	private String internalSale;
	private Date verifiedIdentityDate;
	
	public String getCatSvcId() {
		return catSvcId;
	}
	public void setCatSvcId(String catSvcId) {
		this.catSvcId = catSvcId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getRegisterDocTypeCode() {
		return registerDocTypeCode;
	}
	public void setRegisterDocTypeCode(String registerDocTypeCode) {
		this.registerDocTypeCode = registerDocTypeCode;
	}
	public String getRegisterDocTypeDesc() {
		return registerDocTypeDesc;
	}
	public void setRegisterDocTypeDesc(String registerDocTypeDesc) {
		this.registerDocTypeDesc = registerDocTypeDesc;
	}
	public String getRegisterDocType() {
		return registerDocType;
	}
	public void setRegisterDocType(String registerDocType) {
		this.registerDocType = registerDocType;
	}
	public String getRegisterDocNo() {
		return registerDocNo;
	}
	public void setRegisterDocNo(String registerDocNo) {
		this.registerDocNo = registerDocNo;
	}
	public String getRegisterName() {
		return registerName;
	}
	public void setRegisterName(String registerName) {
		this.registerName = registerName;
	}
	public String getRegisterAddress() {
		return registerAddress;
	}
	public void setRegisterAddress(String registerAddress) {
		this.registerAddress = registerAddress;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getActiveDate() {
		return activeDate;
	}
	public void setActiveDate(String activeDate) {
		this.activeDate = activeDate;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getDeactiveDate() {
		return deactiveDate;
	}
	public void setDeactiveDate(String deactiveDate) {
		this.deactiveDate = deactiveDate;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerAddress() {
		return sellerAddress;
	}
	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}
	public String getVerifiedIdentity() {
		return verifiedIdentity;
	}
	public void setVerifiedIdentity(String verifiedIdentity) {
		this.verifiedIdentity = verifiedIdentity;
	}
	public String getRegisterByApp() {
		return registerByApp;
	}
	public void setRegisterByApp(String registerByApp) {
		this.registerByApp = registerByApp;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStartDateBegin() {
		return startDateBegin;
	}
	public void setStartDateBegin(String startDateBegin) {
		this.startDateBegin = startDateBegin;
	}
	public String getStartDateEnd() {
		return startDateEnd;
	}
	public void setStartDateEnd(String startDateEnd) {
		this.startDateEnd = startDateEnd;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMdn() {
		return mdn;
	}
	public void setMdn(String mdn) {
		this.mdn = mdn;
	}
	public String getIccid() {
		return iccid;
	}
	public void setIccid(String iccid) {
		this.iccid = iccid;
	}
	public String getSapCode() {
		return sapCode;
	}
	public void setSapCode(String sapCode) {
		this.sapCode = sapCode;
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
	public String getDealerCode() {
		return dealerCode;
	}
	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}
	public String getDivisionCode() {
		return divisionCode;
	}
	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}
	public String getDivisionDesc() {
		return divisionDesc;
	}
	public void setDivisionDesc(String divisionDesc) {
		this.divisionDesc = divisionDesc;
	}
	public String getDivisionFull() {
		return divisionFull;
	}
	public void setDivisionFull(String divisionFull) {
		this.divisionFull = divisionFull;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public String getDepartmentDesc() {
		return departmentDesc;
	}
	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc;
	}
	public String getDepartmentFull() {
		return departmentFull;
	}
	public void setDepartmentFull(String departmentFull) {
		this.departmentFull = departmentFull;
	}
	public String getActivateUrlImg() {
		return activateUrlImg;
	}
	public void setActivateUrlImg(String activateUrlImg) {
		this.activateUrlImg = activateUrlImg;
	}
	public String getInfoStatus() {
		return infoStatus;
	}
	public void setInfoStatus(String infoStatus) {
		this.infoStatus = infoStatus;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getBillingAccountNo() {
		return billingAccountNo;
	}
	public void setBillingAccountNo(String billingAccountNo) {
		this.billingAccountNo = billingAccountNo;
	}
	public String getSubscrNo() {
		return subscrNo;
	}
	public void setSubscrNo(String subscrNo) {
		this.subscrNo = subscrNo;
	}
	public Integer getPermitZone() {
		return permitZone;
	}
	public void setPermitZone(Integer permitZone) {
		this.permitZone = permitZone;
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
	public Date getPermitZoneDate() {
		return permitZoneDate;
	}
	public void setPermitZoneDate(Date permitZoneDate) {
		this.permitZoneDate = permitZoneDate;
	}
	public String getActivateBy() {
		return activateBy;
	}
	public void setActivateBy(String activateBy) {
		this.activateBy = activateBy;
	}
	public String getInternalSale() {
		return internalSale;
	}
	public void setInternalSale(String internalSale) {
		this.internalSale = internalSale;
	}
	public Date getVerifiedIdentityDate() {
		return verifiedIdentityDate;
	}
	public void setVerifiedIdentityDate(Date verifiedIdentityDate) {
		this.verifiedIdentityDate = verifiedIdentityDate;
	}

}
