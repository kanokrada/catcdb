package cat.cdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cat.cdb.domain.crmdata.Customer;
 

public interface CustomerRepository extends JpaRepository<Customer, String> {

	Customer findByCustomerId(String customerId);
	Customer findByCustomerNumber(String customerNumber);
	@Query("SELECT t FROM Customer t WHERE t.obsoleteFlag=0 and t.catCardNumber= ?1 ")
	List<Customer> findAllByCatCardNumber(String catCardNumber);
	
	@Query(value = "SELECT c  FROM Customer c  WHERE	catCardNumber = ?1 and c.obsoleteFlag = 0 ")
	List<Customer> findAllByRegisterId(String registerId);
	
	@Query("SELECT t FROM Customer t WHERE t.obsoleteFlag=0 and t.individualId IN :ids")
	List<Customer> findAllByIndividualIdIn(@Param("ids") List<String> ids);
	
	@Query("SELECT t FROM Customer t WHERE t.obsoleteFlag=0 and t.organizationId IN :ids")
	List<Customer> findAllByOrganizationIdIn(@Param("ids") List<String> ids);
	
	@Query("SELECT t FROM Customer t WHERE t.obsoleteFlag=0 and t.customerId IN :ids")
	List<Customer>findAllByCustomerId(@Param("ids") List<String> ids);
}