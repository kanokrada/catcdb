package cat.cdb.domain.crmdata;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ADDRESS", schema = "CRMDATA", catalog = "CRMDATA")
@JsonIgnoreProperties({ "dirty_property_names", "errors", "dirty", "attached", "version" })
public class Address {
	@Id
	private String addressId;
	private String individualId;
	private String organizationId;
	// String address1
	private String addressTypeLkp;
	private Integer primaryFlag;
	private Integer shipToFlag;
	private Integer billToFlag;
	private String city;
	private String cityUp;
	private String postalCode;
	private String postalCodeUp;
	private String stateLkp;
	private String countryLkp;
	// String address1Phonetic
	// String address2
	// String address2Phonetic
	private String fullAddress;
	private Date dateEntered;
	private String timezoneLkp;
	private String erpAddressCode;
	private Integer soldToFlag;
	// Date dateLastSynchedOrUpdt
	private Integer revisionNumber;
	private Integer obsoleteFlag;
	private String catHouseNumber;
	private String catMoo;
	private String catVillage;
	private String catMoreInfo;
	private String catTrokSoi;
	private String catRoad;
	private String catKwang;
	private String catKhet;
	private String catProvince;
	private String catCountry;
	private Date catEffectiveDate;
	private Date catEffectiveDateEnd;
	private BigDecimal esbSvcId;
	private BigDecimal catSvcStatusLkp;
	private Date dateActive;
	private String catName;
	// String catCountryScreen
	// String addressTypeLkpScreen
	// Boolean primaryFlagScreen
	private String customerId;
	private String latitude;
	private String longitude;

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
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

	public String getAddressTypeLkp() {
		return addressTypeLkp;
	}

	public void setAddressTypeLkp(String addressTypeLkp) {
		this.addressTypeLkp = addressTypeLkp;
	}

	public Integer getPrimaryFlag() {
		return primaryFlag;
	}

	public void setPrimaryFlag(Integer primaryFlag) {
		this.primaryFlag = primaryFlag;
	}

	public Integer getShipToFlag() {
		return shipToFlag;
	}

	public void setShipToFlag(Integer shipToFlag) {
		this.shipToFlag = shipToFlag;
	}

	public Integer getBillToFlag() {
		return billToFlag;
	}

	public void setBillToFlag(Integer billToFlag) {
		this.billToFlag = billToFlag;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCityUp() {
		return cityUp;
	}

	public void setCityUp(String cityUp) {
		this.cityUp = cityUp;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPostalCodeUp() {
		return postalCodeUp;
	}

	public void setPostalCodeUp(String postalCodeUp) {
		this.postalCodeUp = postalCodeUp;
	}

	public String getStateLkp() {
		return stateLkp;
	}

	public void setStateLkp(String stateLkp) {
		this.stateLkp = stateLkp;
	}

	public String getCountryLkp() {
		return countryLkp;
	}

	public void setCountryLkp(String countryLkp) {
		this.countryLkp = countryLkp;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public Date getDateEntered() {
		return dateEntered;
	}

	public void setDateEntered(Date dateEntered) {
		this.dateEntered = dateEntered;
	}

	public String getTimezoneLkp() {
		return timezoneLkp;
	}

	public void setTimezoneLkp(String timezoneLkp) {
		this.timezoneLkp = timezoneLkp;
	}

	public String getErpAddressCode() {
		return erpAddressCode;
	}

	public void setErpAddressCode(String erpAddressCode) {
		this.erpAddressCode = erpAddressCode;
	}

	public Integer getSoldToFlag() {
		return soldToFlag;
	}

	public void setSoldToFlag(Integer soldToFlag) {
		this.soldToFlag = soldToFlag;
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

	public String getCatHouseNumber() {
		return catHouseNumber;
	}

	public void setCatHouseNumber(String catHouseNumber) {
		this.catHouseNumber = catHouseNumber;
	}

	public String getCatMoo() {
		return catMoo;
	}

	public void setCatMoo(String catMoo) {
		this.catMoo = catMoo;
	}

	public String getCatVillage() {
		return catVillage;
	}

	public void setCatVillage(String catVillage) {
		this.catVillage = catVillage;
	}

	public String getCatMoreInfo() {
		return catMoreInfo;
	}

	public void setCatMoreInfo(String catMoreInfo) {
		this.catMoreInfo = catMoreInfo;
	}

	public String getCatTrokSoi() {
		return catTrokSoi;
	}

	public void setCatTrokSoi(String catTrokSoi) {
		this.catTrokSoi = catTrokSoi;
	}

	public String getCatRoad() {
		return catRoad;
	}

	public void setCatRoad(String catRoad) {
		this.catRoad = catRoad;
	}

	public String getCatKwang() {
		return catKwang;
	}

	public void setCatKwang(String catKwang) {
		this.catKwang = catKwang;
	}

	public String getCatKhet() {
		return catKhet;
	}

	public void setCatKhet(String catKhet) {
		this.catKhet = catKhet;
	}

	public String getCatProvince() {
		return catProvince;
	}

	public void setCatProvince(String catProvince) {
		this.catProvince = catProvince;
	}

	public String getCatCountry() {
		return catCountry;
	}

	public void setCatCountry(String catCountry) {
		this.catCountry = catCountry;
	}

	public Date getCatEffectiveDate() {
		return catEffectiveDate;
	}

	public void setCatEffectiveDate(Date catEffectiveDate) {
		this.catEffectiveDate = catEffectiveDate;
	}

	public Date getCatEffectiveDateEnd() {
		return catEffectiveDateEnd;
	}

	public void setCatEffectiveDateEnd(Date catEffectiveDateEnd) {
		this.catEffectiveDateEnd = catEffectiveDateEnd;
	}

	public BigDecimal getEsbSvcId() {
		return esbSvcId;
	}

	public void setEsbSvcId(BigDecimal esbSvcId) {
		this.esbSvcId = esbSvcId;
	}

	public BigDecimal getCatSvcStatusLkp() {
		return catSvcStatusLkp;
	}

	public void setCatSvcStatusLkp(BigDecimal catSvcStatusLkp) {
		this.catSvcStatusLkp = catSvcStatusLkp;
	}

	public Date getDateActive() {
		return dateActive;
	}

	public void setDateActive(Date dateActive) {
		this.dateActive = dateActive;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}
