package cat.cdb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cat.cdb.domain.crmdata.view.ViewCatMyIdentityZone;

public interface ViewCatMyIdentityZoneRepository extends JpaRepository<ViewCatMyIdentityZone, String> {

	@Query(value = "SELECT *  FROM V_CAT_MY_IDENTITY_ZONE  WHERE  MDN = ?1 AND REGISTER_ID=?2   ORDER BY START_DATE DESC, UPDATE_DATE DESC", nativeQuery = true)
	List<ViewCatMyIdentityZone> findAllIndentityZoneByMdnAndRegId(String mdn, String registerId);

	@Query(value = "SELECT *  FROM V_CAT_MY_IDENTITY_ZONE  WHERE  MDN = ?1 ORDER BY START_DATE DESC, UPDATE_DATE DESC", nativeQuery = true)
	List<ViewCatMyIdentityZone> findAllIndentityZoneByMdn(String mdn);
	
	@Query(value = "SELECT *  FROM V_CAT_MY_IDENTITY_ZONE  WHERE  MDN = ?1 AND CAT_SVC_ID = ?2 ORDER BY START_DATE DESC, UPDATE_DATE DESC", nativeQuery = true)
	List<ViewCatMyIdentityZone> findAllIndentityZoneByMdnAndSvcId(String mdn, String svcId);
}
