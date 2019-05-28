package cat.cdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cat.cdb.domain.crmdata.CatMyNumberingAuditData; 

public interface CatMyNumberingAuditDataRepository extends JpaRepository<CatMyNumberingAuditData,String> {

	CatMyNumberingAuditData findByCatSvcId(String catSvcId);
	
	@Query(value = "SELECT *  FROM CRMDATA.CAT_MY_NUMBERING_AUDIT_DATA  "
			+ " WHERE STATUS_CODE='ACTIVE' AND MDN=?1  ORDER BY START_DATE DESC, END_DATE DESC",
			nativeQuery =true )
		List<CatMyNumberingAuditData> findAllActiveMobileByMDN9(String mdn9);

	@Query(value = "SELECT *  FROM CRMDATA.CAT_MY_NUMBERING_AUDIT_DATA  "
			+ " WHERE STATUS_CODE='ACTIVE' AND MOBILE_NO=?1  ORDER BY START_DATE DESC, END_DATE DESC",
			nativeQuery =true )
		List<CatMyNumberingAuditData> findAllActiveMobileByMDN10(String mdn9);
}
