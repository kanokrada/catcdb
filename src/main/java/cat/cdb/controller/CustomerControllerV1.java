package cat.cdb.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import cat.cdb.controller.base.ControllerBase;
import cat.cdb.entity.rest.RequestContent;
import cat.cdb.entity.rest.ResponseContent;
import cat.cdb.entity.rest.request.CustomerReserve;
import cat.cdb.entity.rest.response.CustomerReserveResponse;
import cat.cdb.entity.rest.response.CustomerReserveResponseItem;
import cat.cdb.service.IdentityZoneMyService;
import cat.cdb.service.ProductMyService;
import cat.cdb.service.TransactionSequenceService;
import cat.cdb.util.CdbConstance;
import cat.cdb.util.CdbLogger;

@Controller
@Scope("request")
@RequestMapping(value = "/api/v1/customer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CustomerControllerV1 implements ControllerBase {

	@Autowired
	CustomerControllerV1(TransactionSequenceService tranSevice, IdentityZoneMyService zoneService,
			ProductMyService myService) {
		this.tranSevice = tranSevice;
		this.zoneService = zoneService;
		setBaseTransaction();
	}

	TransactionSequenceService tranSevice;
	IdentityZoneMyService zoneService;
	private String cdbTransactionId;
	private static final Logger logger = LoggerFactory.getLogger(CustomerControllerV1.class);

	@RequestMapping(value = "/reservecanumber", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<CustomerReserveResponse> reservecanumber(@RequestBody CustomerReserve request,
			@RequestHeader(value = "interface_type") String interfaceType,
			@RequestHeader(value = "interface_code") String interfaceCode,
			@RequestHeader(value = "interface_source") String interfaceSource,
			@RequestHeader(value = "interface_id") String interfaceId,
			@RequestHeader(value = "request_date") String requestDate,
			@RequestHeader(value = "request_by") String requestBy) {
		CustomerReserveResponse respBody = new CustomerReserveResponse(this.cdbTransactionId);
		respBody.setResponseDate(new Date());
		respBody.setCdbTransactionId(requestBy);
		
		if(request.getRequestMessage().getReserve_amount() != null && !request.getRequestMessage().getReserve_amount().toString().isEmpty() && !request.getRequestMessage().getReserve_amount().toString().equals("0")) {
			//Test
			System.out.println("/bbbbbbbbbbbbb///// : "+request.getRequestMessage().getReserve_amount().toString().charAt(0));
			tranSevice.getTranSequenceRepository().setIncrementalCrmCaNumber(5);
//			tranSevice.getTranSequenceRepository().setIncrementalCrmCaNumber(request.getRequestMessage().getReserve_amount().to);
			
			Long startSequence = tranSevice.getTranSequenceRepository().getNextCrmCaNumber(); // Increment 1
			if (startSequence != null && startSequence != 0) {
				respBody.setResponseItems(new CustomerReserveResponseItem());
				respBody.getResponseItems().setReserve_start(startSequence);
//				tranSevice.getTranSequenceRepository().setIncrementalCrmCaNumber(request.getRequestMessage().getReserve_amount().intValue()); // set Increment
				
				Long endSequence = tranSevice.getTranSequenceRepository().getNextCrmCaNumber(); // Increment Reserve_amount
				
				tranSevice.getTranSequenceRepository().setIncrementalCrmCaNumber(1); // set Increment default
				respBody.getResponseItems().setReserve_end(endSequence);
				respBody.setStatusSuccess();
			} else {
				respBody.setStatusFail();
			}
		}
		
		respBody.setResponseDate(new Date());

		if (respBody.getResponseCode() == CdbConstance.RESPONE_CODE_SUCCESS)
			return new ResponseEntity<>(respBody, HttpStatus.OK);
		else if (respBody.getResponseCode() == CdbConstance.RESPONE_CODE_FAIL)
			return new ResponseEntity<>(respBody, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
		else
			return new ResponseEntity<>(respBody, HttpStatus.FORBIDDEN);
	}

	@Override
	public void setBaseTransaction() {
		// CdbLogger.debug(logger,"Test");
		this.cdbTransactionId = tranSevice.getInterfaceTransactionId();
		zoneService.setTransactionId(this.cdbTransactionId);
		// CdbLogger.debug(logger,"transaction service id
		// 1:"+zoneService.getTransactionId());
//		myService.setTransactionId(this.cdbTransactionId);

	}

	@Override
	public void logBaseTransaction(RequestContent reqeust, ResponseContent response) {
		// CDB_INTERFACE_LOG
		/*
		 * RESP_INTERFACE_ID VARCHAR2(100) REQ_INTERFACE_ID VARCHAR2(100) INTERFACE_TYPE
		 * VARCHAR2(20) INTERFACE_CODE VARCHAR2(30) INTERFACE_SOURCE VARCHAR2(20)
		 * REQUEST_DATE DATE REQUEST_BY VARCHAR2(20) ORDER_NUMBER VARCHAR2(20)
		 * ORDER_DATE DATE EFFECTIVE_DATE DATE ORDER_TYPE VARCHAR2(10) ORDER_SUB_TYPE
		 * VARCHAR2(10) SERVICE_ID VARCHAR2(2500) RESPONSE_CODE VARCHAR2(10)
		 * RESPONSE_MESSAGE VARCHAR2(200) REQUEST_FULL_MESSAGE CLOB
		 * RESPONSE_FULL_MESSAGE CLOB RECIEVE_DATE DATE RESPONSE_DATE DATE
		 */
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public void handleBadRequest(HttpMessageNotReadableException e) {
		CdbLogger.error(logger, e);
	}

}