package com.yoox.hieracy.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CounterUtils {
	
	public static final String SIMPLE_DATE_FORMAT = "dd/MM/yyyy";
	public static final String SIMPLE_DATETIME_FORMAT = "dd/MM/yyyy hh:mm:ss";
	
	public static int increment(int value) {
		return value + 5;
	}
	
	public static String fromDateToString(Date date) {
		
		String formattedDate = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_DATE_FORMAT);
		formattedDate = sdf.format(date);
		
		return formattedDate;
	}
	
	public static String fromDateTimeToString(Date date) {
		
		String formattedDate = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_DATETIME_FORMAT);
		formattedDate = sdf.format(date);
		
		return formattedDate;
	}
}
