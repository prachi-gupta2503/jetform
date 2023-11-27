package com.adjecti.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	private static final String[] FORMATS = { "dd/MM/yy", "MM/dd/yy", "dd/MM/yyyy", "MM/dd/yyyy","yyyy/MM/dd", "dd-MM-yy", "MM-dd-yy", "dd-MM-yyyy", "MM-dd-yyyy", "yyyy-MM-dd", "dd-MMM-yy", "MMM-dd-yy", "dd-MMM-yyyy", "MMM-dd-yyyy", "yyyy-MMM-dd", "dd MMM yyyy HH:mm:ss", "EEE MMM dd HH:mm:ss z yyyy" };

	public final static String YYYY_MM_DD = "yyyy-MM-dd";
	public final static String YYYY_MMM_DD = "yyyy-MMM-dd";
	public final static String YY_MM_DD = "yy-MM-dd";
	public final static String YY_MMM_DD = "yy-MMM-dd";
	public final static String MM_DD_YYYY = "MM-dd-yyyy";
	public final static String MMM_DD_YYYY = "MMM-dd-yyyy";
	public final static String MM_DD_YY = "MM-dd-yy";
	public final static String MMM_DD_YY = "MMM-dd-yy";
	public final static String DD_MM_YYYY = "dd-MM-yyyy";
	public final static String DD_MMM_YYYY = "dd-MMM-yyyy";
	public final static String DD_MM_YY = "dd-MM-yy";
	public final static String DD_MMM_YY = "dd-MMM-yy";
	
	public static Date toDate(String source) {
		Date date = null;
		for (String f : FORMATS) {
			try {
				date = new SimpleDateFormat(f).parse(source);
				break;
			} catch (Exception e) {
			}
		}
		return date;
	}

	public static Date toDate(String source, String format) {
		Date date = null;
		try{
			date = new SimpleDateFormat(format).parse(source);
		} catch (Exception e) {
		}
		return date;
	}
	
	public static Date toDate(String source, DateFormat format) {
		Date date = null;
		try{
			date = format.parse(source);
		} catch (Exception e) {
		}
		return date;
	}
	
	public static String format(Date date, String format) {
		try {
			return new SimpleDateFormat(format).format(date);
		} catch (Exception e) {
		}
		return null;
	}
	
	public static String format(Date date, DateFormat format) {
		try {
			return format.format(date);
		} catch (Exception e) {
		}
		return null;
	}

	public static void main(String[] p) {
		System.out.println(toDate("Mon Dec 01 16:11:00 IST 2014").toString());
	}

	public static Date setTime(Date toDate, int hour, int minute, int second) {
		Calendar cal=Calendar.getInstance();
		cal.setTime(toDate);
		cal.set(Calendar.HOUR, hour);
		cal.set(Calendar.MINUTE,minute);
		cal.set(Calendar.SECOND,second);
		return cal.getTime();
	}
}
