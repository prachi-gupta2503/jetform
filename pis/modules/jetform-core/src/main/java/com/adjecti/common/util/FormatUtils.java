package com.adjecti.common.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtils {
	public static final String DATE_SHORT="dd/MM/yyyy";
	public static final String DATE_LONG="dd/MM/yyyy hh:mm:ss a";
	public static final String DATE_MM_FS_DD_FS_YYYY="MM/dd/yyyy";
	public static final String DATE_MM_HF_DD_HF_YYYY="MM-dd-yyyy";
	public static final String DATE_DD_FS_MM_FS_YYYY="dd/MM/yyyy";
	public static final String DATE_DD_HF_MM_HF_YYYY="dd-MM-yyyy";
	
	public static final String NUMBER_INTERNATIONAL="###,###,##0";
	public static final String NUMBER_INDIAN="###,##,##0";
	public static final String DECIMAL_INTERNATIONAL="###,###,##0.00";
	public static final String DECIMAL_INDIAN="###,##,##0.00";
	
	
	public static String formatDate(Date date, boolean shortDate) {
		if(date==null) {
			return "";
		}
		try {
			String format=DATE_SHORT;
			if(shortDate) {
				format=DATE_SHORT;
			}else {
				format=DATE_LONG;
			}
			
			return new SimpleDateFormat(format).format(date);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return date.toString();
	}
	
	public static String formatDate(Date date, String format) {
		if(date==null) {
			return "";
		}
		try {
			return new SimpleDateFormat(format).format(date);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return date.toString();
	}
	
	
	public static Date toDate(String dateString, boolean shortDate) {
		try {
			
			String format="dd/MM/yyyy";
			if(dateString!=null) {
				if(dateString.length()>10) {
					format=DATE_LONG;
				}else {
					format=DATE_SHORT;
				}
			}
			
			return new SimpleDateFormat(format).parse(dateString);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date toDate(String dateString, String format) {
		try {
			
			
			if(dateString!=null) {
				return new SimpleDateFormat(format).parse(dateString);
			}
		}catch(Exception e) {
			e.printStackTrace();	
		}
		return null;
	}
	
	public static String formatNumber(int value, String format) {
		try {
			NumberFormat formatter=new DecimalFormat(format);
			return formatter.format(value);
		}catch(Exception e) {
			e.printStackTrace();
		}

		return String.valueOf(value);
	}
	
	public static String formatNumber(float value, String format) {
		try {
			NumberFormat formatter=new DecimalFormat(format);
			return formatter.format(value);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return String.valueOf(value);
	}
	
	public static String camelCaseToWords(String str) {
			return str;
	}
}
