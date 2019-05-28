package cat.cdb.domain.crmdata.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "V_CAT_MY_IDENTITY_ZONE", schema = "CRMDATA", catalog = "CRMDATA")
@JsonIgnoreProperties({ "dirty_property_names", "errors", "dirty", "attached", "version" })

public class ViewCatMyIdentityZone {
	@Id
	private String catSvcId;
	private String	mdn;
	private String	registerId;
	private String	customerFullName;
	private Date	startDate;
	private Date	endDate;
	private BigDecimal	permitZone;
	@Column(name="PERMIT_ZONE_DATE")
	private Date	permitZone1Date;
	private String	verifiedIdentity;
	private Date	verifiedIdentityDate;
	private String	serviceType;
	private Date	updateDate;
	private String customerType;
	private String serviceStatus;
	private String imageIdentityId;
	private Date terminateDate;
	private String catCardType;
		
	/*CAT_SVC_ID
	MDN
	REGISTER_ID
	CUSTOMER_FULL_NAME
	START_DATE
	END_DATE
	PERMIT_ZONE
	PERMIT_ZONE_DATE
	VERIFIED_IDENTITY
	VERIFIED_IDENTITY_DATE
	SERVICE_TYPE
	UPDATE_DATE
	CUSTOMER_TYPE
	*/

	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getCatSvcId() {
		return catSvcId;
	}
	public void setCatSvcId(String catSvcId) {
		this.catSvcId = catSvcId;
	}
	public String getCustomerFullName() {
		return customerFullName;
	}
	public void setCustomerFullName(String customerFullName) {
		this.customerFullName = customerFullName;
	}
	public Date getPermitZone1Date() {
		return permitZone1Date;
	}
	public void setPermitZone1Date(Date permitZone1Date) {
		this.permitZone1Date = permitZone1Date;
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
	public String getCustomerfullName() {
		return customerFullName;
	}
	public void setCustomerfullName(String customerfullName) {
		this.customerFullName = customerfullName;
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
	public BigDecimal getPermitZone() {
		return permitZone;
	}
	public void setPermitZone(BigDecimal permitZone) {
		this.permitZone = permitZone;
	} 
	public String getVerifiedIdentity() {
		return verifiedIdentity;
	}
	public void setVerifiedIdentity(String verifiedIdentity) {
		this.verifiedIdentity = verifiedIdentity;
	}
	public Date getVerifiedIdentityDate() {
		return verifiedIdentityDate;
	}
	public void setVerifiedIdentityDate(Date verifiedIdentityDate) {
		this.verifiedIdentityDate = verifiedIdentityDate;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getServiceStatus() {
		return serviceStatus;
	}
	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
	public String getImageIdentityId() {
		return imageIdentityId;
	}
	public void setImageIdentityId(String imageIdentityId) {
		this.imageIdentityId = imageIdentityId;
	}
	public Date getTerminateDate() {
		return terminateDate;
	}
	public void setTerminateDate(Date terminateDate) {
		this.terminateDate = terminateDate;
	}
	public String getCatCardType() {
		return catCardType;
	}
	public void setCatCardType(String catCardType) {
		this.catCardType = catCardType;
	}
}
