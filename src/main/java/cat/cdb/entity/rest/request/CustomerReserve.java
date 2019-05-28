package cat.cdb.entity.rest.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import cat.cdb.entity.rest.RequestContent;
import cat.cdb.entity.rest.request.IdentityZoneMyRequestMessage;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CustomerReserve extends RequestContent {
	private CustomerReserveMessage requestMessage = new CustomerReserveMessage();

	public CustomerReserveMessage getRequestMessage() {
		return requestMessage;
	}

	public void setRequestMessage(CustomerReserveMessage requestMessage) {
		this.requestMessage = requestMessage;
	}
}
