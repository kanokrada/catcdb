package cat.cdb.entity.rest.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import cat.cdb.entity.rest.RequestContent;
import cat.cdb.entity.rest.request.IdentityZoneMyRequestMessage;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class IdentityZoneDetail extends RequestContent{
	private IdentityZoneDetailMessage requestMessage=new IdentityZoneDetailMessage();

	public IdentityZoneDetailMessage getRequestMessage() {
		return requestMessage;
	}

	public void setRequestMessage(IdentityZoneDetailMessage requestMessage) {
		this.requestMessage = requestMessage;
	}
		 
}

 
