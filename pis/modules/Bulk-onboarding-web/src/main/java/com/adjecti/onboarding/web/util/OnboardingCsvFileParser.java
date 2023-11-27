package com.adjecti.onboarding.web.util;

import com.adjecti.onboarding.web.dto.RegistrationRecord;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang.StringUtils;

public class OnboardingCsvFileParser {
	private static Log LOGGER = LogFactoryUtil.getLog(OnboardingCsvFileParser.class);


	public static List<RegistrationRecord> parse(File requestFile) {
		
		List<RegistrationRecord> list = new ArrayList<RegistrationRecord>();
		try {
	            Reader reader = new FileReader(requestFile);
	            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
	                    .withHeader("sno","unit","section","personalNo","postBox", "rank",
	                    		"trade","grade","designation","doj",
	                    		"firstName", "middleName","lastName",
	                    		"gender", "dob","casteCategory", "mobileNo", "email",
	                    		"gpfNps", "gpfNpsNo", "idamAccess", "emailAccess", "digitalSigning", "egovAccess", "pisAccess")
	                    .withIgnoreHeaderCase()
	                    .withSkipHeaderRecord()
	                    .withTrim());
	            int count =0;
	            for (CSVRecord csvRecord : csvParser.getRecords()) {
	               	RegistrationRecord registrationRecord = new RegistrationRecord();
	            	// Accessing values by the names assigned to each column
	            	registrationRecord.setRowIndex(count++);
	            	registrationRecord.setEmployeeNumber(getLongValue(csvRecord.get("sno")));
	            	registrationRecord.setUnit(csvRecord.get("unit"));
	            	registrationRecord.setSection(csvRecord.get("section"));
	            	registrationRecord.setPersonalNo(getLongValue(csvRecord.get("personalNo")));
	            	registrationRecord.setPostBox(csvRecord.get("postBox"));
	            	registrationRecord.setRank(getLongValue(csvRecord.get("rank")));
	            	
	            	registrationRecord.setTrade(csvRecord.get("trade"));
	            	registrationRecord.setGrade(csvRecord.get("grade"));
	            	registrationRecord.setDesignation(csvRecord.get("designation"));
	            	registrationRecord.setDateOfJoiningUnit(getDate(csvRecord.get("doj")));
	            	
	            	registrationRecord.setFirstName(csvRecord.get("firstName"));
	            	registrationRecord.setMiddleName(csvRecord.get("middleName"));
	            	registrationRecord.setLastName(csvRecord.get("lastName"));
	            	
	            	registrationRecord.setGender(csvRecord.get("gender"));
	            	registrationRecord.setDateOfBirth(getDate(csvRecord.get("dob")));
	            	registrationRecord.setCastCategory(csvRecord.get("casteCategory"));
	            	registrationRecord.setMobile(getLongValue(csvRecord.get("mobileNo")));
	            	registrationRecord.setEmailId(csvRecord.get("email"));
	            	
	            	registrationRecord.setGpfNpsType(csvRecord.get("gpfNps"));
	            	registrationRecord.setGpfNpsNumber(getLongValue(csvRecord.get("gpfNpsNo")));
	            	registrationRecord.setIdamUser(csvRecord.get("idamAccess"));
	            	registrationRecord.setEmailAccess(csvRecord.get("emailAccess"));
	            	registrationRecord.setDigitalSigning(csvRecord.get("digitalSigning"));
	            	registrationRecord.seteGovAccess(csvRecord.get("egovAccess"));
	            	registrationRecord.setPisAccess(csvRecord.get("pisAccess"));
	            			            	
	            	list.add(registrationRecord);
	            }
		 }catch (Exception ex) {
			 LOGGER.error(ex);
		 }
		return list;
	}

	private static long getLongValue(String strValue) {
		if(StringUtils.isNotBlank(strValue)) {
			try {
				return Long.parseLong(strValue);
			} catch (NumberFormatException e) {
				LOGGER.error(e);
			}
		}
		return 0;
	}

	private static Date getDate(String stringDate) {
		 if (StringUtils.isBlank(stringDate)) {
	            return Calendar.getInstance().getTime();
	     } 
	     
		 try {
	            	
			 String dateFormat = "dd-M-yyyy";
	               
	         final SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
	                
	         return sdf.parse(stringDate);
		 } catch (ParseException e) {
	         try {  	
	        	 final SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
	        	 return sdf.parse(stringDate);
	     	}catch (ParseException ex) {
	            return Calendar.getInstance().getTime();
	        }
		 }
	}


}
