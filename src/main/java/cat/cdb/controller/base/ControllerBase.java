package cat.cdb.controller.base;

import cat.cdb.entity.rest.RequestContent;
import cat.cdb.entity.rest.ResponseContent;

public interface ControllerBase {
	void setBaseTransaction();
	//void verifyRequest(RequestContent request);
	void logBaseTransaction(RequestContent reqeust,ResponseContent response);
}
