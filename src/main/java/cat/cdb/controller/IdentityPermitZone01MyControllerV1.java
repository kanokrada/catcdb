package cat.cdb.controller;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import cat.cdb.controller.base.ControllerBase;
import cat.cdb.domain.crmdata.view.ViewCatMyIdentityZone;
import cat.cdb.entity.rest.RequestContent;
import cat.cdb.entity.rest.ResponseContent;
import cat.cdb.entity.rest.request.IdentityZoneDetail;
import cat.cdb.entity.rest.request.IdentityZoneMyInquiry;
import cat.cdb.entity.rest.request.IdentityZoneMyRequest;
import cat.cdb.entity.rest.response.IdentityZoneDetailResponse;
import cat.cdb.entity.rest.response.IdentityZoneDetailResponseItem;
import cat.cdb.entity.rest.response.IdentityZoneMyResponse;
import cat.cdb.entity.rest.response.IdentityZoneServiceItem;
import cat.cdb.service.IdentityZoneMyService;
import cat.cdb.service.ProductMyService;
import cat.cdb.service.TransactionSequenceService;
import cat.cdb.util.CdbConstance;
import cat.cdb.util.CdbLogger;
import cat.cdb.util.JavaHelper;

@Controller
@Scope("request")
@RequestMapping(value = "/api/v1/service/my", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class IdentityPermitZone01MyControllerV1 implements ControllerBase {

	@Autowired
	IdentityPermitZone01MyControllerV1(TransactionSequenceService tranSevice, IdentityZoneMyService zoneService,
			ProductMyService myService) {
		this.tranSevice = tranSevice;
		this.zoneService = zoneService;
		this.myService = myService;
		setBaseTransaction();
	}

	IdentityZoneMyService zoneService;
	ProductMyService myService;
	TransactionSequenceService tranSevice;
	private String cdbTransactionId;
	private static final Logger logger = LoggerFactory.getLogger(IdentityPermitZone01MyControllerV1.class);

	// indentityZoneRequest * 6
	@RequestMapping(value = "/indentityZoneRequest", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<IdentityZoneMyResponse> identityZoneRequest(@RequestBody IdentityZoneMyRequest request,
			@RequestHeader(value = "interface_type") String interfaceType,
			@RequestHeader(value = "interface_code") String interfaceCode,
			@RequestHeader(value = "interface_source") String interfaceSource,
			@RequestHeader(value = "interface_id") String interfaceId,
			@RequestHeader(value = "request_date") String requestDate,
			@RequestHeader(value = "request_by") String requestBy) {
		IdentityZoneMyResponse respBody = new IdentityZoneMyResponse(this.cdbTransactionId);
		Boolean permitZone1 = false;

		// init response value
		respBody.getResponseItems().setZone(CdbConstance.ZONE_MY_PUBLIC_02);
		respBody.getResponseItems().setVerifiedIdentity(false);

		// find mobile zone
		ViewCatMyIdentityZone mobileZone = zoneService.findServiceZone(request.getRequestMessage().getMdn(),
				request.getRequestMessage().getRegisterId());

		if (mobileZone != null) {
			respBody.setStatusSuccess();
			respBody.getResponseItems().setCatSvcId(mobileZone.getCatSvcId());
			respBody.getResponseItems().setCustomerFullName(mobileZone.getCustomerFullName());
			respBody.getResponseItems().setStartDate(mobileZone.getStartDate());
			respBody.getResponseItems().setEndDate(mobileZone.getEndDate());
			respBody.getResponseItems().setCustomerType(mobileZone.getCustomerType());
			// zone ทั่วไป =0 , zone 3 จว.ภาคใต้ =1, zone null = zone 0
			// verifiedIdentity = Y คือลงทะเบียนอัตลักษณ์
			if (JavaHelper.isNull(mobileZone.getPermitZone()) // zone null or
					|| mobileZone.getPermitZone().intValue() == CdbConstance.ZONE_MY_PUBLIC_02) {// zone Zero(public)

				CdbLogger.debug(logger, "ZONE_MY_PUBLIC_02", this.cdbTransactionId);
				// ถ้ายังไม่เคยขอใช้งาน 3 จว. ชายแดนใต้
				// อนุญาตให้ใช้งานได้ถ้ายืนยันอัตลักษณ์แล้ว
				// permitZone1 = true;
				if (mobileZone.getVerifiedIdentity().equalsIgnoreCase(CdbConstance.VERIFIED_IDENTITY_PASS)) {
					// apply zone 1?
					respBody.getResponseItems().setVerifiedIdentity(true);
					respBody.getResponseItems().setVerifiedIdentityDate(mobileZone.getVerifiedIdentityDate());

					if (myService.applyZoneMy(mobileZone.getCatSvcId(), CdbConstance.ZONE_MY_BLOCK_01)) {
						CdbLogger.debug(logger, "Identity apply ZONE_MY_BLOCK_01", this.cdbTransactionId);
						permitZone1 = true;
						if (CdbConstance.INTERFACE_SOURCE.SMS.equalsIgnoreCase(interfaceSource)) {
							respBody.setResponseMessage(CdbConstance.RESP_EN_NOPASS_ZONE1);
						} else {
							respBody.setResponseMessage(CdbConstance.RESP_TH_NOPASS_ZONE1);
						}
						respBody.getResponseItems().setZone(CdbConstance.ZONE_MY_BLOCK_01);
						respBody.getResponseItems().setPermitZone1Date(JavaHelper.getCurrentDate());
						respBody.getResponseItems().setMdn(request.getRequestMessage().getMdn());
						respBody.getResponseItems().setStartDate(mobileZone.getStartDate());
						respBody.getResponseItems().setRegisterId(mobileZone.getRegisterId());
						respBody.getResponseItems().setServiceType(mobileZone.getServiceType());
					} else {
						if (CdbConstance.INTERFACE_SOURCE.SMS.equalsIgnoreCase(interfaceSource)) {
							respBody.setResponseMessage(CdbConstance.RESP_EN_NOPASS_ZONE1);
						} else {
							respBody.setResponseMessage(CdbConstance.RESP_TH_NOPASS_ZONE1);
						}
						respBody.getResponseItems().setZone(CdbConstance.ZONE_MY_PUBLIC_02);
					}
				} else {
					if (CdbConstance.INTERFACE_SOURCE.SMS.equalsIgnoreCase(interfaceSource)) {
						respBody.setResponseMessage(CdbConstance.RESP_EN_NOPASS_ZONE1);
					} else {
						respBody.setResponseMessage(CdbConstance.RESP_TH_NOPASS_ZONE1);
					}
					respBody.getResponseItems().setZone(CdbConstance.ZONE_MY_PUBLIC_02);
				}

			} else if (mobileZone.getPermitZone().intValue() == CdbConstance.ZONE_MY_BLOCK_01) {// zone private 3
																								// จว.ชายแดนใต้
				CdbLogger.debug(logger, "ZONE_MY_BLOCK_01", this.cdbTransactionId);
				permitZone1 = true;
				if (CdbConstance.INTERFACE_SOURCE.SMS.equalsIgnoreCase(interfaceSource)) {
					respBody.setResponseMessage(CdbConstance.RESP_EN_PASS_ZONE1);
				} else {
					respBody.setResponseMessage(CdbConstance.RESP_TH_PASS_ZONE1);
				}

				respBody.getResponseItems().setZone(mobileZone.getPermitZone().intValue());
				respBody.getResponseItems().setPermitZone1Date(mobileZone.getPermitZone1Date());
				respBody.getResponseItems().setMdn(request.getRequestMessage().getMdn());
				respBody.getResponseItems().setStartDate(mobileZone.getStartDate());
				respBody.getResponseItems().setRegisterId(mobileZone.getRegisterId());
				respBody.getResponseItems().setServiceType(mobileZone.getServiceType());
				CdbLogger.debug(logger, "VerifiedIdentity =" + mobileZone.getVerifiedIdentity(), this.cdbTransactionId);

				if (!JavaHelper.isNull(mobileZone.getVerifiedIdentity())// verified ผ่านการยืนยันตัวตน
						&& mobileZone.getVerifiedIdentity().equalsIgnoreCase(CdbConstance.VERIFIED_IDENTITY_PASS)) {
					CdbLogger.debug(logger, "VerifiedIdentity was true", this.cdbTransactionId);
					respBody.getResponseItems().setVerifiedIdentity(true);
					respBody.getResponseItems().setVerifiedIdentityDate(mobileZone.getVerifiedIdentityDate());
				} else {
					CdbLogger.debug(logger, "VerifiedIdentity was false", this.cdbTransactionId);
					respBody.getResponseItems().setVerifiedIdentity(false);
				}

			} else {// zone อื่นๆ
				CdbLogger.debug(logger, "Others zone.", this.cdbTransactionId);
				if (CdbConstance.INTERFACE_SOURCE.SMS.equalsIgnoreCase(interfaceSource)) {
					respBody.setResponseMessage(CdbConstance.RESP_EN_NOPASS_ZONE1);
				} else {
					respBody.setResponseMessage(CdbConstance.RESP_TH_NOPASS_ZONE1);
				}
				respBody.getResponseItems().setZone(CdbConstance.ZONE_MY_PUBLIC_02);
				permitZone1 = false;
			}

		} else {// ไม่พบ profile
			ViewCatMyIdentityZone mobileData = zoneService.findServiceMobileData(request.getRequestMessage().getMdn());
			CdbLogger.debug(logger, mobileData.getMdn(), this.cdbTransactionId);
			if (mobileData != null) {
				respBody.setStatusNotMatch();
				if (CdbConstance.INTERFACE_SOURCE.SMS.equalsIgnoreCase(interfaceSource)) {
					respBody.setResponseMessage(CdbConstance.RESP_EN_INVALID_IDCARD_NOTMATCH);
				} else {
					respBody.setResponseMessage(CdbConstance.RESP_TH_INVALID_IDCARD_NOTMATCH);
				}
			} else {
				respBody.setStatusFail();
				respBody.setResponseMessage("ไม่พบหมายเลขในระบบ" + "0" + request.getRequestMessage().getMdn()
						+ ",ทะเบียนเลขที่ " + request.getRequestMessage().getRegisterId());
				// respBody.setResponseMessage(
				// MessageFormat.format(CdbConstance.RESP_NOPASS_ZONE1, "0" +
				// request.getRequestMessage().getMdn()));
			}
		}

		respBody.setResponseDate(new Date());
		respBody.getResponseItems().setIsPermitZone1(permitZone1);

		if (respBody.getResponseCode() == CdbConstance.RESPONE_CODE_SUCCESS)
			return new ResponseEntity<>(respBody, HttpStatus.OK);
		else if (respBody.getResponseCode() == CdbConstance.RESPONE_CODE_FAIL)
			return new ResponseEntity<>(respBody, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
		else
			return new ResponseEntity<>(respBody, HttpStatus.FORBIDDEN);
	}

	// indentityZoneInquiry * 5
	@RequestMapping(value = "/indentityZoneInquiry", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	ResponseEntity<IdentityZoneMyResponse> identityZoneInquiry(@RequestBody IdentityZoneMyInquiry request,
			@RequestHeader(value = "interface_type") String interfaceType,
			@RequestHeader(value = "interface_code") String interfaceCode,
			@RequestHeader(value = "interface_source") String interfaceSource,
			@RequestHeader(value = "interface_id") String interfaceId,
			@RequestHeader(value = "request_date") String requestDate,
			@RequestHeader(value = "request_by") String requestBy) {
		IdentityZoneMyResponse respBody = new IdentityZoneMyResponse(this.cdbTransactionId);
		Boolean permitZone1 = false;
		// init response value
		respBody.getResponseItems().setZone(CdbConstance.ZONE_MY_PUBLIC_02);
		respBody.getResponseItems().setVerifiedIdentity(false);

		ViewCatMyIdentityZone mobileZone = zoneService.findServiceZone(request.getRequestMessage().getMdn(),
				request.getRequestMessage().getRegisterId());

		if (mobileZone != null) {
			respBody.setStatusSuccess();
			respBody.getResponseItems().setCatSvcId(mobileZone.getCatSvcId());
			respBody.getResponseItems().setCustomerFullName(mobileZone.getCustomerFullName());
			respBody.getResponseItems().setStartDate(mobileZone.getStartDate());
			respBody.getResponseItems().setEndDate(mobileZone.getEndDate());
			respBody.getResponseItems().setCustomerType(mobileZone.getCustomerType());

			// zone ทั่วไป =0 , zone 3 จว.ภาคใต้ =1, zone null = zone 0
			// verifiedIdentity = Y คือลงทะเบียนอัตลักษณ์
			if (JavaHelper.isNull(mobileZone.getPermitZone()) // zone null or
					|| mobileZone.getPermitZone().intValue() == CdbConstance.ZONE_MY_PUBLIC_02) {// zone Zero(public)
				CdbLogger.debug(logger, "ZONE_MY_PUBLIC_02", this.cdbTransactionId);
				// ถ้ายังไม่เคยขอใช้งาน 3 จว. ชายแดนใต้
				// อนุญาตให้ใช้งานได้ถ้ายืนยันอัตลักษณ์แล้ว
				// permitZone1 = true;
				if (!JavaHelper.isNull(mobileZone.getVerifiedIdentity())
						&& mobileZone.getVerifiedIdentity().equalsIgnoreCase(CdbConstance.VERIFIED_IDENTITY_PASS)) {
					// apply zone 1?
					respBody.getResponseItems().setVerifiedIdentity(true);
					respBody.getResponseItems().setVerifiedIdentityDate(mobileZone.getVerifiedIdentityDate());
					respBody.getResponseItems().setMdn(request.getRequestMessage().getMdn());
					respBody.getResponseItems().setStartDate(mobileZone.getStartDate());
					respBody.getResponseItems().setRegisterId(mobileZone.getRegisterId());
					respBody.getResponseItems().setServiceType(mobileZone.getServiceType());
					respBody.setResponseMessage(
							MessageFormat.format(CdbConstance.RESP_PASS_VERIFIED_IDENDTITY_NOPASS_ZONE1,
									"0" + request.getRequestMessage().getMdn()));
					respBody.getResponseItems().setZone(CdbConstance.ZONE_MY_PUBLIC_02);

				} else {
					respBody.getResponseItems().setVerifiedIdentity(false);
					if (CdbConstance.INTERFACE_SOURCE.SMS.equalsIgnoreCase(interfaceSource)) {
						respBody.setResponseMessage(CdbConstance.RESP_EN_NOPASS_ZONE1);
					} else {
						respBody.setResponseMessage(CdbConstance.RESP_TH_NOPASS_ZONE1);
					}
					respBody.getResponseItems().setZone(CdbConstance.ZONE_MY_PUBLIC_02);
				}

			} else if (mobileZone.getPermitZone().intValue() == CdbConstance.ZONE_MY_BLOCK_01) {// zone private 3
																								// จว.ชายแดนใต้
				CdbLogger.debug(logger, "ZONE_MY_BLOCK_01", this.cdbTransactionId);
				permitZone1 = true;
				if (CdbConstance.INTERFACE_SOURCE.SMS.equalsIgnoreCase(interfaceSource)) {
					respBody.setResponseMessage(CdbConstance.RESP_EN_PASS_ZONE1);
				} else {
					respBody.setResponseMessage(CdbConstance.RESP_TH_PASS_ZONE1);
				}
				respBody.getResponseItems().setZone(mobileZone.getPermitZone().intValue());
				respBody.getResponseItems().setPermitZone1Date(mobileZone.getPermitZone1Date());
				respBody.getResponseItems().setMdn(request.getRequestMessage().getMdn());
				respBody.getResponseItems().setStartDate(mobileZone.getStartDate());
				respBody.getResponseItems().setRegisterId(mobileZone.getRegisterId());
				respBody.getResponseItems().setServiceType(mobileZone.getServiceType());
				CdbLogger.debug(logger, "VerifiedIdentity =" + mobileZone.getVerifiedIdentity(), this.cdbTransactionId);

				if (!JavaHelper.isNull(mobileZone.getVerifiedIdentity())// verified ผ่านการยืนยันตัวตน
						&& mobileZone.getVerifiedIdentity().equalsIgnoreCase(CdbConstance.VERIFIED_IDENTITY_PASS)) {
					CdbLogger.debug(logger, "VerifiedIdentity was true", this.cdbTransactionId);
					respBody.getResponseItems().setVerifiedIdentity(true);
					respBody.getResponseItems().setVerifiedIdentityDate(mobileZone.getVerifiedIdentityDate());
				} else {
					CdbLogger.debug(logger, "VerifiedIdentity was false", this.cdbTransactionId);
					respBody.getResponseItems().setVerifiedIdentity(false);
				}

			} else {// zone อื่นๆ
				CdbLogger.debug(logger, "Others zone.", this.cdbTransactionId);
				if (CdbConstance.INTERFACE_SOURCE.SMS.equalsIgnoreCase(interfaceSource)) {
					respBody.setResponseMessage(CdbConstance.RESP_EN_NOPASS_ZONE1);
				} else {
					respBody.setResponseMessage(CdbConstance.RESP_TH_NOPASS_ZONE1);
				}
				respBody.getResponseItems().setZone(CdbConstance.ZONE_MY_PUBLIC_02);
				permitZone1 = false;
			}
		} else {// ไม่พบ profile
			ViewCatMyIdentityZone mobileData = zoneService.findServiceMobileData(request.getRequestMessage().getMdn());
			CdbLogger.debug(logger, "mobileData : " + mobileData, this.cdbTransactionId);
			if (mobileData != null) {
				respBody.setStatusNotMatch();
				if (CdbConstance.INTERFACE_SOURCE.SMS.equalsIgnoreCase(interfaceSource)) {
					respBody.setResponseMessage(CdbConstance.RESP_EN_INVALID_IDCARD_NOTMATCH);
				} else {
					respBody.setResponseMessage(CdbConstance.RESP_TH_INVALID_IDCARD_NOTMATCH);
				}
			} else {
				respBody.setStatusFail();
				// respBody.getResponseItems().setVerifiedIdentity(false);
				respBody.setResponseMessage("ไม่พบหมายเลขในระบบ" + "0" + request.getRequestMessage().getMdn()
						+ ",ทะเบียนเลขที่ " + request.getRequestMessage().getRegisterId());
				// respBody.setResponseMessage(
				// MessageFormat.format(CdbConstance.RESP_NOPASS_ZONE1, "0" +
				// request.getRequestMessage().getMdn()));
			}
		}
		CdbLogger.debug(logger, respBody.getResponseMessage(), this.cdbTransactionId);
		CdbLogger.debug(logger,
				MessageFormat.format(respBody.getResponseMessage(), "0" + request.getRequestMessage().getMdn()),
				this.cdbTransactionId);

		respBody.setResponseDate(new Date());
		respBody.getResponseItems().setIsPermitZone1(permitZone1);

		logBaseTransaction(request, respBody);

		if (respBody.getResponseCode() == CdbConstance.RESPONE_CODE_SUCCESS)
			return new ResponseEntity<>(respBody, HttpStatus.OK);
		else if (respBody.getResponseCode() == CdbConstance.RESPONE_CODE_FAIL)
			return new ResponseEntity<>(respBody, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
		else
			return new ResponseEntity<>(respBody, HttpStatus.FORBIDDEN);
	}

	@RequestMapping(value = "/indentityZoneDetail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<IdentityZoneDetailResponse> indentityZoneDetail(@RequestBody IdentityZoneDetail request,
			@RequestHeader(value = "interface_type") String interfaceType,
			@RequestHeader(value = "interface_code") String interfaceCode,
			@RequestHeader(value = "interface_source") String interfaceSource,
			@RequestHeader(value = "interface_id") String interfaceId,
			@RequestHeader(value = "request_date") String requestDate,
			@RequestHeader(value = "request_by") String requestBy) {
		IdentityZoneDetailResponse respBody = new IdentityZoneDetailResponse(this.cdbTransactionId);
		Boolean isPermitZone1 = false;
		Boolean isVerified = false;
		int codeZone;
		List<ViewCatMyIdentityZone> mobileDetails = null;
		
		if(request.getRequestMessage().getMdn() != null && !request.getRequestMessage().getMdn().isEmpty()) {
			mobileDetails = zoneService.findServiceMobileDetail(
					request.getRequestMessage().getMdn(), request.getRequestMessage().getServiceId());
			
			if (mobileDetails != null) {
				respBody.setResponseItems(new IdentityZoneDetailResponseItem());
				respBody.getResponseItems().setService(new ArrayList<IdentityZoneServiceItem>());
				IdentityZoneServiceItem serviceItem = new IdentityZoneServiceItem();
				for (int i = 0; i < mobileDetails.size(); i++) {				
					serviceItem = new IdentityZoneServiceItem();
					if (mobileDetails.get(i).getPermitZone() != null && mobileDetails.get(i).getPermitZone().intValue() == CdbConstance.ZONE_MY_BLOCK_01) {
						isPermitZone1 = true;
					} else {
						isPermitZone1 = false;
					}

					if (mobileDetails.get(i).getVerifiedIdentity() != null && mobileDetails.get(i).getVerifiedIdentity()
							.equalsIgnoreCase(CdbConstance.VERIFIED_IDENTITY_PASS)) {
						isVerified = true;
					} else {
						isVerified = false;
					}

					serviceItem.setIsPermitZone1(isPermitZone1);
					serviceItem.setVerifiedIdentityDate(mobileDetails.get(i).getPermitZone1Date());
					serviceItem.setVerifiedIdentity(isVerified);
					serviceItem.setVerifiedIdentityDate(mobileDetails.get(i).getVerifiedIdentityDate());
					serviceItem.setCatSvcId(mobileDetails.get(i).getCatSvcId());
					serviceItem.setMdn(mobileDetails.get(i).getMdn());
					serviceItem.setRegisterId(mobileDetails.get(i).getRegisterId());
					serviceItem.setCustomerFullName(mobileDetails.get(i).getCustomerFullName());
					serviceItem.setStartDate(mobileDetails.get(i).getStartDate());
					serviceItem.setServiceType(mobileDetails.get(i).getServiceType());
					if(mobileDetails.get(i).getPermitZone()!=null) {
						serviceItem.setZone(mobileDetails.get(i).getPermitZone().intValue());
					}				
					serviceItem.setCustomerType(mobileDetails.get(i).getCustomerType());
					serviceItem.setCatCardType(mobileDetails.get(i).getCatCardType());
					serviceItem.setImageIdentityId(mobileDetails.get(i).getImageIdentityId());
					serviceItem.setTerminateDate(mobileDetails.get(i).getTerminateDate());
					serviceItem.setServiceStatus(mobileDetails.get(i).getServiceStatus());

					respBody.getResponseItems().getService().add(serviceItem);
				}
				respBody.setStatusSuccess();
				respBody.setResponseDate(new Date());
				respBody.setResponseCode(CdbConstance.RESPONE_CODE_SUCCESS);
				respBody.setCdbTransactionId(this.cdbTransactionId);
			} else {// ไม่พบ profile
				respBody.setStatusFail();
				respBody.setResponseMessage("ไม่พบหมายเลขในระบบ" + "0" + request.getRequestMessage().getMdn());
			}
		} else {
//			respBody.setStatusBadRequest();
			respBody.setResponseCode(CdbConstance.RESPONE_CODE_PARAMETER_INVALID);
			respBody.setResponseMessage(CdbConstance.RESP_NOPASS_VERIFIED_PARAMETER_INVALID);
		}
		
		if (respBody.getResponseCode() == CdbConstance.RESPONE_CODE_SUCCESS)
			return new ResponseEntity<>(respBody, HttpStatus.OK);
		else if (respBody.getResponseCode() == CdbConstance.RESPONE_CODE_FAIL)
			return new ResponseEntity<>(respBody, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
		else if(respBody.getResponseCode() == CdbConstance.RESPONE_CODE_PARAMETER_INVALID)
			return new ResponseEntity<>(respBody, HttpStatus.BAD_REQUEST);
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
		myService.setTransactionId(this.cdbTransactionId);

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