package cat.cdb.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cat.cdb.domain.crmdata.CatMyNumberingAuditData;
import cat.cdb.domain.crmdata.CatSvc;
import cat.cdb.repository.CatMyNumberingAuditDataRepository;
import cat.cdb.repository.CatSvcRepository;
import cat.cdb.util.CdbConstance;
import cat.cdb.util.JavaHelper;

@Service
public class ProductMyService extends TransactionMaster {
	ProductMyService() {
		super();
	}

	@Autowired
	CatMyNumberingAuditDataRepository myNumberAuditRepository;
	@Autowired
	CatSvcRepository svcRepository;

	private static final Logger logger = LoggerFactory.getLogger(ProductMyService.class);

	@Transactional
	public Boolean applyZoneMy(String catSvcId, Integer zone) {
		Boolean applySuccess = false;
		CatMyNumberingAuditData data = myNumberAuditRepository.findByCatSvcId(catSvcId);
		CatSvc svc = svcRepository.findByCatSvcId(catSvcId);
		if (zone == CdbConstance.ZONE_MY_BLOCK_01) {
			if (!JavaHelper.isNull(svc)) {
				svc.setPermitZone(zone);
				svc.setPermitZoneDate(JavaHelper.getCurrentDate());
				svcRepository.saveAndFlush(svc);
				applySuccess = true;
			}

			if (!JavaHelper.isNull(data)) {
				data.setPermitZone(zone);
				data.setPermitZoneDate(JavaHelper.getCurrentDate());
				myNumberAuditRepository.saveAndFlush(data);
				applySuccess = true;
			}
		} else if (zone == CdbConstance.ZONE_MY_PUBLIC_02) {
			if (!JavaHelper.isNull(svc)) {
				svc.setPermitZone(zone);
				svc.setPermitZoneDate(null);
				svcRepository.saveAndFlush(svc);
				applySuccess = true;
			}

			if (!JavaHelper.isNull(data)) {
				data.setPermitZone(zone);
				data.setPermitZoneDate(null);
				myNumberAuditRepository.saveAndFlush(data);
				applySuccess = true;
			}
		}

		return applySuccess;
	}

}
