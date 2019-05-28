package cat.cdb.entity.rest.response;

import java.util.Date;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class IdentityZoneMyResponseItem {
	Boolean isPermitZone1;
	Boolean verifiedIdentity;
	Date permitZone1Date;
	Date verifiedIdentityDate;
	String catSvcId;
	String mdn;
	String registerId;
	String customerFullName;
	Date startDate;
	Date endDate;
	String serviceType;
	Integer zone;
	String customerType;
	
	public Boolean getIsPermitZone1() {
		return isPermitZone1;
	}
	public void setIsPermitZone1(Boolean isPermitZone1) {
		this.isPermitZone1 = isPermitZone1;
	}
	public Integer getZone() {
		return zone;
	}
	public void setZone(Integer zone) {
		this.zone = zone;
	}
	public Boolean getVerifiedIdentity() {
		return verifiedIdentity;
	}
	public void setVerifiedIdentity(Boolean verifiedIdentity) {
		this.verifiedIdentity = verifiedIdentity;
	}
	public Date getPermitZone1Date() {
		return permitZone1Date;
	}
	public void setPermitZone1Date(Date permitZone1Date) {
		this.permitZone1Date = permitZone1Date;
	}
	public Date getVerifiedIdentityDate() {
		return verifiedIdentityDate;
	}
	public void setVerifiedIdentityDate(Date verifiedIdentityDate) {
		this.verifiedIdentityDate = verifiedIdentityDate;
	}
	public String getCatSvcId() {
		return catSvcId;
	}
	public void setCatSvcId(String catSvcId) {
		this.catSvcId = catSvcId;
	}
	public String getMdn() {
		return mdn;
	}
	public void setMdn(String mdn) {
		this.mdn = mdn;
	}
	public String getRegisterId() {
		return registerId;
	}
	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}
	public String getCustomerFullName() {
		return customerFullName;
	}
	public void setCustomerFullName(String customerFullName) {
		this.customerFullName = customerFullName;
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
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
}
