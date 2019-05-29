package cat.cdb.entity.rest.response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import cat.cdb.entity.rest.ResponseContent;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CustomerReserveResponse extends ResponseContent {
	private static final Logger logger = LoggerFactory.getLogger(CustomerReserveResponse.class);

	public CustomerReserveResponse(String cdbTransactionId) {
		super(cdbTransactionId);
		logger.debug("Response item transaction id:" + cdbTransactionId);

	}

	private CustomerReserveResponseItem responseItem = new CustomerReserveResponseItem();

	public CustomerReserveResponseItem getResponseItems() {
		return responseItem;
	}

	public void setResponseItems(CustomerReserveResponseItem responseItems) {
		this.responseItem = responseItems;
	}

}
