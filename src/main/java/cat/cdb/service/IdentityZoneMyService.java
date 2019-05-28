package cat.cdb.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cat.cdb.domain.crmdata.view.ViewCatMyIdentityZone;
import cat.cdb.repository.ViewCatMyIdentityZoneRepository;
import cat.cdb.util.JavaHelper;

@Service
public class IdentityZoneMyService extends TransactionMaster {

	IdentityZoneMyService() {
		super();
	}

	@Autowired
	ViewCatMyIdentityZoneRepository zoneRepository;

	private static final Logger logger = LoggerFactory.getLogger(IdentityZoneMyService.class);

	public ViewCatMyIdentityZone findServiceZone(String mdn, String registerId) {
		logger.debug("transaction service id:" + getTransactionId());
		ViewCatMyIdentityZone serviceZone = new ViewCatMyIdentityZone();
		List<ViewCatMyIdentityZone> serviceZones = zoneRepository.findAllIndentityZoneByMdnAndRegId(mdn, registerId);

		if (!JavaHelper.isNull(serviceZones) && serviceZones.size() > 0) {
			serviceZone = serviceZones.get(0); // return latest service
			logger.debug(serviceZone.getMdn() + ":permit zone is .." + serviceZone.getPermitZone());
		} else {
			serviceZone = null;
		}
		return serviceZone;
	}

	public ViewCatMyIdentityZone findServiceMobileData(String mdn) {
		logger.debug("transaction service id:" + getTransactionId());
		ViewCatMyIdentityZone serviceZone = new ViewCatMyIdentityZone();
		List<ViewCatMyIdentityZone> serviceZones = zoneRepository.findAllIndentityZoneByMdn(mdn);

		if (!JavaHelper.isNull(serviceZones) && serviceZones.size() > 0) {
			serviceZone = serviceZones.get(0); // return latest service
			logger.debug(serviceZone.getMdn() + ":permit zone is .." + serviceZone.getPermitZone());
		} else {
			serviceZone = null;
		}
		return serviceZone;
	}

	public List<ViewCatMyIdentityZone> findServiceMobileDetail(String mdn, String svcId) {
		logger.debug("transaction service id:" + getTransactionId());
		List<ViewCatMyIdentityZone> serviceZones = new ArrayList<ViewCatMyIdentityZone>();
		if (!JavaHelper.isNull(mdn) && !mdn.isEmpty() && !JavaHelper.isNull(svcId) && !svcId.isEmpty()) {
			serviceZones = zoneRepository.findAllIndentityZoneByMdnAndSvcId(mdn, svcId);
		} else if (!JavaHelper.isNull(mdn) && !mdn.isEmpty()) {
			serviceZones = zoneRepository.findAllIndentityZoneByMdn(mdn);
		}

		return serviceZones;
	}
}
