package cat.cdb.entity.rest.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import cat.cdb.entity.rest.RequestContent;
import cat.cdb.entity.rest.request.IdentityZoneMyInquiryMessage;
/**
 * @author Komsan
 *
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class IdentityZoneMyInquiry extends RequestContent{
	private IdentityZoneMyInquiryMessage requestMessage=new IdentityZoneMyInquiryMessage();

	public IdentityZoneMyInquiryMessage getRequestMessage() {
		return requestMessage;
	}

	public void setRequestMessage(IdentityZoneMyInquiryMessage requestMessage) {
		this.requestMessage = requestMessage;
	}
		 
}

 
