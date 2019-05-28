package cat.cdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cat.cdb.domain.crmdata.Address;
 

public interface AddressRepository extends JpaRepository<Address, String> {

	Address findByAddressId(String addressId);
	Address findByCustomerId(String customerId);
	
	@Query(value = "SELECT *  FROM CRMDATA.ADDRESS   WHERE   CUSTOMER_ID = ?1 AND OBSOLETE_FLAG =0 AND ROWNUM=1  ORDER BY  DATE_ENTERED DESC",nativeQuery =true )
	List<Address> findPrimaryAllByCustomerId(String customerId);
}