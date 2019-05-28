package cat.cdb.entity.rest.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CustomerReserveResponseItem {
	List<CustomerItem> customer = new ArrayList<CustomerItem>();

	public List<CustomerItem> getCustomer() {
		return customer;
	}

	public void setCustomer(List<CustomerItem> customer) {
		this.customer = customer;
	}

}
