package cat.cdb.entity.rest.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CustomerReserveResponseItem {
	Long reserve_start;
	Long reserve_end;
	String customer_number;
	String address;
	String organization;
	String email;
	String telephone;
	String billing_account;

	public Long getReserve_start() {
		return reserve_start;
	}

	public void setReserve_start(Long reserve_start) {
		this.reserve_start = reserve_start;
	}

	public Long getReserve_end() {
		return reserve_end;
	}

	public void setReserve_end(Long reserve_end) {
		this.reserve_end = reserve_end;
	}

	public String getCustomer_number() {
		return customer_number;
	}

	public void setCustomer_number(String customer_number) {
		this.customer_number = customer_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getBilling_account() {
		return billing_account;
	}

	public void setBilling_account(String billing_account) {
		this.billing_account = billing_account;
	}

}
