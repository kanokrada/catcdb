package cat.cdb.entity.rest.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import cat.cdb.entity.rest.RequestContent;
import cat.cdb.entity.rest.request.IdentityZoneMyRequestMessage;
/**
 * @author Komsan
 *
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class IdentityZoneMyRequest extends RequestContent{
	private IdentityZoneMyRequestMessage requestMessage=new IdentityZoneMyRequestMessage();

	public IdentityZoneMyRequestMessage getRequestMessage() {
		return requestMessage;
	}

	public void setRequestMessage(IdentityZoneMyRequestMessage requestMessage) {
		this.requestMessage = requestMessage;
	}
		 
}

 
