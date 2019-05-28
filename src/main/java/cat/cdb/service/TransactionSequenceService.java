package cat.cdb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import cat.cdb.repository.CdbTransactionSequenceRepository;

@Service
public class TransactionSequenceService {

	@Autowired
	CdbTransactionSequenceRepository tranSequenceRepository;

	private static final Logger logger = LoggerFactory.getLogger(TransactionSequenceService.class);

	public String getInterfaceTransactionId() {

		String transactionId = "TRN";
		Long id = tranSequenceRepository.getNextCdbTransactionId();
		if (id != null)
			transactionId = transactionId + id;
		else
			transactionId = "DUMMY00000001";

		return transactionId;
	}
}
