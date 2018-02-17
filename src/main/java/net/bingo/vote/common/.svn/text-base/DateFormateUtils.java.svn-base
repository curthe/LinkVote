package net.bingo.vote.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 处理日期字符串的类
 * @author 初坤
 *
 */
public class DateFormateUtils {

	//将日期字符串转为日期类型的
	public static Date fromStringToDate(String pattern,String dateStr){
		DateFormat dateFormat  = new SimpleDateFormat(pattern);
		try {
			return dateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//将日期类型转为日期字符串
	public static String formDateToString(String pattern,Date date){
		DateFormat dateFormat  = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}
}
