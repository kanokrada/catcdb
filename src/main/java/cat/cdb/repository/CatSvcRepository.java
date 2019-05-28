package cat.cdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cat.cdb.domain.crmdata.CatSvc;
 
public interface CatSvcRepository extends JpaRepository<CatSvc, String > {

	CatSvc findByCatSvcId(String catSvcId);
	
	@Query(value = "SELECT *  FROM CAT_SVC  WHERE  DISPLAY_NAME = ?1 AND ( CAT_SVC_TYPE_LKP = 110 OR  CAT_SVC_TYPE_LKP = 150)   AND  OBSOLETE_FLAG =0  ORDER BY START_DATE DESC, UPDATE_DATE DESC",
		nativeQuery =true )
	List<CatSvc> findMobileAllByDisplayName(String mdn);
	
	
	//@Query(value = "SELECT s  FROM CatSvc s  WHERE  s.displayName = ?1 AND ( s.catSvcTypeLkp = 110 OR  s.catSvcTypeLkp = 150)   AND  s.obsoleteFlag =0  ORDER BY s.startDate DESC, s.updateDate DESC" )
	//List<CatSvc> findMobileAllByDisplayName(String displayName);
	
	@Query(value = "SELECT s  FROM CatSvc s  WHERE	s.catSvcId = ?1 and s.obsoleteFlag = 0 and (s.catSvcStatusLkp=1 or s.catSvcStatusLkp=6 or s.catSvcStatusLkp=2 or s.catSvcStatusLkp=4 or s.catSvcStatusLkp=7 or s.catSvcStatusLkp=1)")
	CatSvc getActiveCatSvcWithCatSvcId(String catSvcId);
	
	@Query(value = "SELECT s  FROM CatSvc s  WHERE	s.displayName = ?1 and s.obsoleteFlag = 0 and (s.catSvcStatusLkp=1 or s.catSvcStatusLkp=6 or s.catSvcStatusLkp=2 or s.catSvcStatusLkp=4 or s.catSvcStatusLkp=7 or s.catSvcStatusLkp=1)")
	CatSvc getActiveCatSvcWithMobileNumber(String mdn);  //สำหรับงาน holder เพื่อค้นหาเบอร์ที่ active อยู่จากเบอร์เดิมที่ต้องการย้าย
	
	@Query(value = "SELECT s  FROM CatSvc s  WHERE	s.cssCatId = ?1 and s.obsoleteFlag = 0  ")
	List<CatSvc> findAllByCssCatId(String cssCatId);
	
	
}
