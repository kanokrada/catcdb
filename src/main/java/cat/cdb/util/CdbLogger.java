package cat.cdb.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/*import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger;*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author SCM Technologies
 *
 */
public class CdbLogger   {
	CdbLogger(){
		throw new UnsupportedOperationException( "Do not instantiate libraries.");
	}
	private static Logger localLogger = LoggerFactory.getLogger(CdbLogger.class);
	
	private static final String NO_TRANS_ID = "NO-TRANS-ID";
	
	private static final String INFO_PREFIX = "[Interface-INFO:%s]: %s";
	private static final String DEBUG_PREFIX = "[Interface-DEBUG:%s]: %s";
	private static final String ERROR_PREFIX = "[Interface-ERROR:%s]: %s";
	
	
	public static void info(Object message){
		info(localLogger, message);
	}
	
	public static void debug(Object message){
		debug(localLogger, message);
	}

	public static void error(Object message){
		error(localLogger, message);
	}
	
	public static void info(Logger logger, Object message){
		info(logger, message, NO_TRANS_ID);
	}
	
	public static void debug(Logger logger, Object message){
		debug(logger, message, NO_TRANS_ID);
	}

	public static void error(Logger logger, Object message){
		error(logger, message, NO_TRANS_ID);
	}
	
	public static void info(Logger logger, Object message, String transId){
		if(message instanceof Exception){
			logger.info(String.format(INFO_PREFIX, transId, getStackTraceString((Exception) message)));
		} else {
			logger.info(String.format(INFO_PREFIX, transId, message.toString()));
		}
	}
	public static void info(Logger logger, Object message, Integer transId){
		if(message instanceof Exception){
			logger.info(String.format(INFO_PREFIX, transId, getStackTraceString((Exception) message)));
		} else {
			logger.info(String.format(INFO_PREFIX, transId, message.toString()));
		}
	}
	
	public static void debug(Logger logger, Object message, String transId){
			if(message instanceof Exception){
				logger.debug(String.format(DEBUG_PREFIX, transId, getStackTraceString((Exception) message)));
			} else {
				logger.debug(String.format(DEBUG_PREFIX, transId, message.toString()));
			}
		//}
	}
	public static void debug(Logger logger, Object message, Integer transId){ 
			if(message instanceof Exception){
				logger.debug(String.format(DEBUG_PREFIX, transId, getStackTraceString((Exception) message)));
			} else {
				logger.debug(String.format(DEBUG_PREFIX, transId, message.toString()));
			}
		//}
	}

	public static void error(Logger logger, Object message, String transId){
		if(message instanceof Exception){
			logger.error(String.format(ERROR_PREFIX, transId, getStackTraceString((Exception) message)));
		} else {
			logger.error(String.format(ERROR_PREFIX, transId, message.toString()));
		}
	}
	public static void error(Logger logger, Object message, Integer transId){
		if(message instanceof Exception){
			logger.error(String.format(ERROR_PREFIX, transId, getStackTraceString((Exception) message)));
		} else {
			logger.error(String.format(ERROR_PREFIX, transId, message.toString()));
		}
	}
	public static String getStackTraceString(Exception e){
		Writer writer = new StringWriter();
		PrintWriter printWriter = new PrintWriter(writer);
		e.printStackTrace(printWriter);
		return writer.toString();
	}
	
}
 
