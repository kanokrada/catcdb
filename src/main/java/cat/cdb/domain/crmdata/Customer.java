package cat.cdb.domain.crmdata;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "CUSTOMER", schema = "CRMDATA", catalog = "CRMDATA")
@JsonIgnoreProperties({ "dirty_property_names", "errors", "dirty", "attached", "version" })
public class Customer {
	@Id
	private String customerId;
	private String referenceCode;
	private String referenceCodeUp;
	private String customerFullName;
	private String customerFullNameUp;
	private String individualId;
	private String organizationId;
	private String naturalTierLkp;
	private String actualTierLkp;
	private String tierJustificationLkp;
	private Integer tierPoints;
	private Date dateUpdatedNaturalTier;
	private Date dateUpdatedActualTier;
	private String customerTypeLkp;
	private String customerCategoryLkp;
	private String eTerritoryId;
	private String ownerAgentId;
	private Integer strategicAccountFlag;
	private Date dateLastSynchedOrUpdt;
	private String currency;
	private Integer revisionNumber;
	private Integer obsoleteFlag;
	private BigDecimal catCardType;
	private String catCardNumber;
	private String catCardIssuedBy;
	private Date catCardIssuedDate;
	private String catCitizenId;
	private String catCustomerSegment;
	private String catCustomerGroup;
	private String catCustomerType;
	private String catCustomerFocus;
	private String employeeId;;
	private String updateBy;
	private Date updateDate;
	private String employeeFirstName;
	private String employeeLastName;
	private String customerNumber;
	private String keyAccountVip;
	private Date accountSince;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getReferenceCode() {
		return referenceCode;
	}
	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}
	public String getReferenceCodeUp() {
		return referenceCodeUp;
	}
	public void setReferenceCodeUp(String referenceCodeUp) {
		this.referenceCodeUp = referenceCodeUp;
	}
	public String getCustomerFullName() {
		return customerFullName;
	}
	public void setCustomerFullName(String customerFullName) {
		this.customerFullName = customerFullName;
	}
	public String getCustomerFullNameUp() {
		return customerFullNameUp;
	}
	public void setCustomerFullNameUp(String customerFullNameUp) {
		this.customerFullNameUp = customerFullNameUp;
	}
	public String getIndividualId() {
		return individualId;
	}
	public void setIndividualId(String individualId) {
		this.individualId = individualId;
	}
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public String getNaturalTierLkp() {
		return naturalTierLkp;
	}
	public void setNaturalTierLkp(String naturalTierLkp) {
		this.naturalTierLkp = naturalTierLkp;
	}
	public String getActualTierLkp() {
		return actualTierLkp;
	}
	public void setActualTierLkp(String actualTierLkp) {
		this.actualTierLkp = actualTierLkp;
	}
	public String getTierJustificationLkp() {
		return tierJustificationLkp;
	}
	public void setTierJustificationLkp(String tierJustificationLkp) {
		this.tierJustificationLkp = tierJustificationLkp;
	}
	public Integer getTierPoints() {
		return tierPoints;
	}
	public void setTierPoints(Integer tierPoints) {
		this.tierPoints = tierPoints;
	}
	public Date getDateUpdatedNaturalTier() {
		return dateUpdatedNaturalTier;
	}
	public void setDateUpdatedNaturalTier(Date dateUpdatedNaturalTier) {
		this.dateUpdatedNaturalTier = dateUpdatedNaturalTier;
	}
	public Date getDateUpdatedActualTier() {
		return dateUpdatedActualTier;
	}
	public void setDateUpdatedActualTier(Date dateUpdatedActualTier) {
		this.dateUpdatedActualTier = dateUpdatedActualTier;
	}
	public String getCustomerTypeLkp() {
		return customerTypeLkp;
	}
	public void setCustomerTypeLkp(String customerTypeLkp) {
		this.customerTypeLkp = customerTypeLkp;
	}
	public String getCustomerCategoryLkp() {
		return customerCategoryLkp;
	}
	public void setCustomerCategoryLkp(String customerCategoryLkp) {
		this.customerCategoryLkp = customerCategoryLkp;
	}
	public String geteTerritoryId() {
		return eTerritoryId;
	}
	public void seteTerritoryId(String eTerritoryId) {
		this.eTerritoryId = eTerritoryId;
	}
	public String getOwnerAgentId() {
		return ownerAgentId;
	}
	public void setOwnerAgentId(String ownerAgentId) {
		this.ownerAgentId = ownerAgentId;
	}
	public Integer getStrategicAccountFlag() {
		return strategicAccountFlag;
	}
	public void setStrategicAccountFlag(Integer strategicAccountFlag) {
		this.strategicAccountFlag = strategicAccountFlag;
	}
	public Date getDateLastSynchedOrUpdt() {
		return dateLastSynchedOrUpdt;
	}
	public void setDateLastSynchedOrUpdt(Date dateLastSynchedOrUpdt) {
		this.dateLastSynchedOrUpdt = dateLastSynchedOrUpdt;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Integer getRevisionNumber() {
		return revisionNumber;
	}
	public void setRevisionNumber(Integer revisionNumber) {
		this.revisionNumber = revisionNumber;
	}
	public Integer getObsoleteFlag() {
		return obsoleteFlag;
	}
	public void setObsoleteFlag(Integer obsoleteFlag) {
		this.obsoleteFlag = obsoleteFlag;
	}
	public BigDecimal getCatCardType() {
		return catCardType;
	}
	public void setCatCardType(BigDecimal catCardType) {
		this.catCardType = catCardType;
	}
	public String getCatCardNumber() {
		return catCardNumber;
	}
	public void setCatCardNumber(String catCardNumber) {
		this.catCardNumber = catCardNumber;
	}
	public String getCatCardIssuedBy() {
		return catCardIssuedBy;
	}
	public void setCatCardIssuedBy(String catCardIssuedBy) {
		this.catCardIssuedBy = catCardIssuedBy;
	}
	public Date getCatCardIssuedDate() {
		return catCardIssuedDate;
	}
	public void setCatCardIssuedDate(Date catCardIssuedDate) {
		this.catCardIssuedDate = catCardIssuedDate;
	}
	public String getCatCitizenId() {
		return catCitizenId;
	}
	public void setCatCitizenId(String catCitizenId) {
		this.catCitizenId = catCitizenId;
	}
	public String getCatCustomerSegment() {
		return catCustomerSegment;
	}
	public void setCatCustomerSegment(String catCustomerSegment) {
		this.catCustomerSegment = catCustomerSegment;
	}
	public String getCatCustomerGroup() {
		return catCustomerGroup;
	}
	public void setCatCustomerGroup(String catCustomerGroup) {
		this.catCustomerGroup = catCustomerGroup;
	}
	public String getCatCustomerType() {
		return catCustomerType;
	}
	public void setCatCustomerType(String catCustomerType) {
		this.catCustomerType = catCustomerType;
	}
	public String getCatCustomerFocus() {
		return catCustomerFocus;
	}
	public void setCatCustomerFocus(String catCustomerFocus) {
		this.catCustomerFocus = catCustomerFocus;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}
	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}
	public String getEmployeeLastName() {
		return employeeLastName;
	}
	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getKeyAccountVip() {
		return keyAccountVip;
	}
	public void setKeyAccountVip(String keyAccountVip) {
		this.keyAccountVip = keyAccountVip;
	}
	public Date getAccountSince() {
		return accountSince;
	}
	public void setAccountSince(Date accountSince) {
		this.accountSince = accountSince;
	}
}
