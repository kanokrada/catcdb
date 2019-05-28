/**
 * 
 */
package cat.cdb.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper; 
 
/**
 * @author SCM Technologies
 *
 */
public class JsonFormat {
	static Logger log = LogManager.getLogger(JsonFormat.class);

	JsonFormat() {
		throw new UnsupportedOperationException("Do not instantiate libraries.");
	}
	public static String convertObjectToJSONString(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		String json="";
		try {
			 json = mapper.writeValueAsString(obj);
			//InfLogger.info(log,"Object to JSON = " + json,tranId)
			
		} catch (JsonProcessingException e)  {
			log.error(e.getMessage());
		}
		return json;
	}
	public static String convertRequestObjecttoJSONString(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(obj); 
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		}
		return json;
	}
}
