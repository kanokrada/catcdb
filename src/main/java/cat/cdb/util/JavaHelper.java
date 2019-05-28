package cat.cdb.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaHelper { 

	 private static final Logger logger = LoggerFactory.getLogger(JavaHelper.class);
	private static DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private static DateFormat formatterE = new SimpleDateFormat("yyyy-MM-dd");
	private static DateFormat gmtFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	private static DateFormat formatterFull = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static DateFormat formatterShot = new SimpleDateFormat("dd/MM/yy");
	public static boolean isNull(Object test) {
		if (test instanceof String) 
			return isNull((String)test);
		
		return test == null;
	}
	
	public static boolean isNull(String test) {
		return test == null || test.length() == 0 || test.equalsIgnoreCase("null") || test.trim().length() == 0;
	}

	public static String getStackTraceString(Exception e){
		Writer writer = new StringWriter();
		PrintWriter printWriter = new PrintWriter(writer);
		e.printStackTrace(printWriter);
		return writer.toString();
	}
	
	public static String getStringArryaList(ArrayList<String> array) {
		Iterator<String> itr = array.iterator();
		StringBuilder sb = new StringBuilder();
		while (itr.hasNext()) {
			sb.append(itr.next() + "\n");
		}
		return sb.toString();
	}
	
	public static Timestamp getCurrentTimestamp(){
		return new Timestamp(new Date().getTime());
	}
	
	public static Date getCurrentDate(){
		Date result = null;
		
		try {
			result = convertStringTodate(formatter.format(new Date()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.debug(e.getMessage());
		}
		
		return result;		
	}
	public static Date convertStringTodate(String dateString) {
		Date result = null;
		try {
			//logger.debug("Date Str:"+dateString);
			result = (Date) formatter.parse(dateString);
		} catch (ParseException e) {
			logger.debug(e.getMessage());
		}
		return result;
	}
	public static Date convertStringTodateFormat(String dateString) {
		Date result = null;
		try {
			logger.debug("Date Str:"+dateString);
			result = (Date) formatterE.parse(dateString);
		} catch (ParseException E) {
			logger.debug("E:"+E);
			try {
				result = (Date) formatter.parse(dateString);
			} catch (ParseException e) {
				logger.debug("e:"+e);
				try {
					gmtFormatter.setTimeZone(TimeZone.getTimeZone("GMT"));
					result = (Date) gmtFormatter.parse(dateString);
				} catch (ParseException eZ) {
					// TODO Auto-generated catch block
					logger.debug("ez:"+eZ);
				}
			}
		}

		return result;
	}
	
	public static Date addDay(Date dt, int day) {
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(dt);
			c.add(Calendar.DATE, day);
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return dt = c.getTime();
	}

	public static XMLGregorianCalendar convertTimestampToXMLtime(Timestamp timestamp){
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(timestamp);
		XMLGregorianCalendar xmlTime = null;
		try {
			xmlTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			logger.debug(e.getMessage());
		}
		return xmlTime;
	}
	
	public static XMLGregorianCalendar convertDateToXMLtime(Date date){
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Timestamp(date.getTime()));
		XMLGregorianCalendar xmlTime = null;
		try {
			xmlTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			logger.debug(e.getMessage());
		}
		return xmlTime;
	}
	
	public static String convertIntegerTo3DigitsString(int i){
		String result = "000";
		
		if(!(i <= 0) && !(i >= 1000)){
			result = String.format("%03d", i);
		}
		
		return result;
	}
	
	public static String convertIntegerToLeftZeroString(int zeroDigits, int i){
		String result = String.format("%0" + zeroDigits + "d", 0);
		
		if(String.valueOf(i).length() <= result.length() && i > 0){
			result = String.format("%0" + zeroDigits + "d", i);
		}
		
		return result;
	}
	public static String convertDateToStringDDMMYYYY(Date dt){
		return formatter.format(dt);
	}
	public static String convertDateToStringDDMMYY(Date dt){
		return formatterShot.format(dt);
	}
	public static String convertDateToStringDDMMYYYYHHMISS(Date dt){
		return formatterFull.format(dt);
	}
	public static String getNewLineString(){
		return System.getProperty("line.separator");
	}
	
}