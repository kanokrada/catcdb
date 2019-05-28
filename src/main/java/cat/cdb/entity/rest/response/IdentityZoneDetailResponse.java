package cat.cdb.entity.rest.response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import cat.cdb.entity.rest.ResponseContent;
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class IdentityZoneDetailResponse extends ResponseContent {
	private static final Logger logger = LoggerFactory.getLogger(IdentityZoneDetailResponse.class);
 	public IdentityZoneDetailResponse(String cdbTransactionId) {
	    super(cdbTransactionId);
	    logger.debug("Response item transaction id:"+cdbTransactionId);
		
	} 
	private IdentityZoneDetailResponseItem responseItems=new IdentityZoneDetailResponseItem();
	
	
 	public IdentityZoneDetailResponseItem getResponseItems() {
		return responseItems;
	}

	public void setResponseItems(IdentityZoneDetailResponseItem responseItems) {
		this.responseItems = responseItems;
	}
}
