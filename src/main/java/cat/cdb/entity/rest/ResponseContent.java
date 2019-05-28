package cat.cdb.entity.rest;

import java.util.Date;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import cat.cdb.util.CdbConstance;
 

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ResponseContent {
	protected String responseCode;
	protected String responseMessage;
	protected String cdbTransactionId;
	protected Date responseDate;
	
	public ResponseContent(String cdbTransactionId) {
		this.cdbTransactionId=cdbTransactionId;		
	}
	
	
	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getCdbTransactionId() {
		return cdbTransactionId;
	}

	public void setCdbTransactionId(String cdbTransactionId) {
		this.cdbTransactionId = cdbTransactionId;
	}

	public Date getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}

	public void setStatusSuccess() {
		this.responseCode=CdbConstance.RESPONE_CODE_SUCCESS;
		this.responseMessage="Your request successfully.";
	}

	public void setStatusFail() {
		this.responseCode="FAIL";
		this.responseMessage=CdbConstance.RESPONE_CODE_FAIL;
	}
	
	public void setStatusNotMatch() {
		this.responseCode="FAIL";
		this.responseMessage=CdbConstance.RESPONE_CODE_FAIL;
	}
	
	public void setStatusBadRequest() {
		this.responseCode = CdbConstance.RESPONE_CODE_PARAMETER_INVALID;
		this.responseMessage=CdbConstance.RESPONE_CODE_FAIL;
	}

}
