package cat.cdb.domain.crmdata;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "CDB_INTERFACE_LOG", schema = "CRMDATA", catalog = "CRMDATA")
@JsonIgnoreProperties({ "dirty_property_names", "errors", "dirty", "attached", "version" })
public class CdbInterfaceLog {
	@Id
	@Column(name = "RESP_INTERFACE_ID")
	private String respInterfaceId;

	@Column(name = "REQ_INTERFACE_ID")
	private String reqInterfaceId;

	@Column(name = "INTERFACE_TYPE")
	private String interfaceType;

	@Column(name = "INTERFACE_CODE")
	private String interfaceCode;
	
	@Column(name = "INTERFACE_SOURCE")
	private String interfaceSource;
	
	@Column(name = "REQUEST_DATE")
	private Date requestDate;
	
	@Column(name = "REQUEST_BY")
	private String requestBy;
	
	@Column(name = "ORDER_NUMBER")
	private String orderNumber;
	
	@Column(name = "ORDER_DATE")
	private Date orderDate;
	
	@Column(name = "EFFECTIVE_DATE")
	private Date effectiveDate;
	
	@Column(name = "ORDER_TYPE")
	private String orderType;
	
	@Column(name = "ORDER_SUB_TYPE")
	private String orderSubType;
	
	@Column(name = "SERVICE_ID")
	private String serviceId;
	
	@Column(name = "RESPONSE_CODE")
	private String responseCode;
	
	@Column(name = "RESPONSE_MESSAGE")
	private String responseMessage;
	
	@Column(name = "REQUEST_FULL_MESSAGE")
	private String requestFullMessage;
	
	@Column(name = "RESPONSE_FULL_MESSAGE")
	private String responseFullMessage;
	
	@Column(name = "RECIEVE_DATE")
	private Date recieveDate;
	
	@Column(name = "RESPONSE_DATE")
	private Date responseDate;

	public String getRespInterfaceId() {
		return respInterfaceId;
	}

	public void setRespInterfaceId(String respInterfaceId) {
		this.respInterfaceId = respInterfaceId;
	}

	public String getReqInterfaceId() {
		return reqInterfaceId;
	}

	public void setReqInterfaceId(String reqInterfaceId) {
		this.reqInterfaceId = reqInterfaceId;
	}

	public String getInterfaceType() {
		return interfaceType;
	}

	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}

	public String getInterfaceCode() {
		return interfaceCode;
	}

	public void setInterfaceCode(String interfaceCode) {
		this.interfaceCode = interfaceCode;
	}

	public String getInterfaceSource() {
		return interfaceSource;
	}

	public void setInterfaceSource(String interfaceSource) {
		this.interfaceSource = interfaceSource;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getRequestBy() {
		return requestBy;
	}

	public void setRequestBy(String requestBy) {
		this.requestBy = requestBy;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderSubType() {
		return orderSubType;
	}

	public void setOrderSubType(String orderSubType) {
		this.orderSubType = orderSubType;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
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

	public String getRequestFullMessage() {
		return requestFullMessage;
	}

	public void setRequestFullMessage(String requestFullMessage) {
		this.requestFullMessage = requestFullMessage;
	}

	public String getResponseFullMessage() {
		return responseFullMessage;
	}

	public void setResponseFullMessage(String responseFullMessage) {
		this.responseFullMessage = responseFullMessage;
	}

	public Date getRecieveDate() {
		return recieveDate;
	}

	public void setRecieveDate(Date recieveDate) {
		this.recieveDate = recieveDate;
	}

	public Date getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}

}
