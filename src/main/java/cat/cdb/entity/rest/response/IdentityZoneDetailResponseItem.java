package cat.cdb.entity.rest.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class IdentityZoneDetailResponseItem {
	List<IdentityZoneServiceItem> service = new ArrayList<IdentityZoneServiceItem>();

	public List<IdentityZoneServiceItem> getService() {
		return service;
	}

	public void setService(List<IdentityZoneServiceItem> service) {
		this.service = service;
	}

}
