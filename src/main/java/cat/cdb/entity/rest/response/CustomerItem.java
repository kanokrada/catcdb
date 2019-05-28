package cat.cdb.entity.rest.response;

import java.util.Date;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CustomerItem {
	Number reserve_start;
	Number reserve_end;
	String customer_number;
	String address;	
	String organization;
	String email;	
	String telephone;	
	String billing_account;	

}
