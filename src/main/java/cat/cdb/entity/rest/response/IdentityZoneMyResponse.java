package cat.cdb.entity.rest.response;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import cat.cdb.entity.rest.ResponseContent; 
import cat.cdb.service.TransactionSequenceService;
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class IdentityZoneMyResponse extends ResponseContent {
	private static final Logger logger = LoggerFactory.getLogger(IdentityZoneMyResponse.class);
 	public IdentityZoneMyResponse(String cdbTransactionId) {
	    super(cdbTransactionId);
	    logger.debug("Response item transaction id:"+cdbTransactionId);
		
	} 
	private IdentityZoneMyResponseItem responseItems=new IdentityZoneMyResponseItem();
	
	
 	public IdentityZoneMyResponseItem getResponseItems() {
		return responseItems;
	}

	public void setResponseItems(IdentityZoneMyResponseItem responseItems) {
		this.responseItems = responseItems;
	}
}
