/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ziduye.utils.base;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationFieldType;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 * @author ThinkGem
 * @version 2014-4-15
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
	
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}
	
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}
	
	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}
	
	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}
	
	/**
	 * 日期型字符串转化为日期 格式
	 * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", 
	 *   "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
	 *   "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null){
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获取过去的天数
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(24*60*60*1000);
	}

	/**
	 * 获取过去的小时
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(60*60*1000);
	}
	
	/**
	 * 获取过去的分钟
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(60*1000);
	}
	
	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * @param timeMillis
	 * @return
	 */
    public static String formatDateTime(long timeMillis){
		long day = timeMillis/(24*60*60*1000);
		long hour = (timeMillis/(60*60*1000)-day*24);
		long min = ((timeMillis/(60*1000))-day*24*60-hour*60);
		long s = (timeMillis/1000-day*24*60*60-hour*60*60-min*60);
		long sss = (timeMillis-day*24*60*60*1000-hour*60*60*1000-min*60*1000-s*1000);
		return (day>0?day+",":"")+hour+":"+min+":"+s+"."+sss;
    }
	
	/**
	 * 获取两个日期之间的天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}
	
	public static final String f_full = "yyyy-MM-dd HH:mm:ss";
	public static final String f_long = "yyyy-MM-dd";
	
	public static final String f_year_month = "yyyy-MM";
	public static final String f_year = "yyyy";
	public static final String f_month = "MM";
	public static final String f_day = "dd";
	
	public static DateTime toDateTime(Date date){
		DateTime dt = new DateTime(date);
		return dt;
	}
	public static DateTime toDateTime(String dateStr){
		DateTime dt = toDateTime(parse(dateStr));
		return dt;
	}
	//=============获取当前时间,字符串-start===============
	public static Date now(){
		return DateTime.now().toDate();
	}
	public static String nows(){
		return nows(f_full);
	}
	public static String nows(String fmt){
		return DateTime.now().toString(fmt);
	}
	//=============获取当前时间,字符串- end ===============
	//=============解析日期字符串           -start===============
	public static Date parse(String dateStr,String fmts) {
		if (dateStr == null){
			return null;
		}
		Date d = null;
		try {
			DateTimeFormatter fmt = DateTimeFormat.forPattern(fmts);
			d = fmt.parseDateTime(dateStr).toDate();
		} catch (Exception e) {
			d = null;
		}
		return d;
	}
	private static String[] parsePatterns = {
		"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", 
		"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
		"yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};
	
	/**
	 * 日期型字符串转化为日期 格式
	 * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", 
	 *   "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
	 *   "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
	 */
	public static Date parse(String dateStr) {
		Date d = null;
		for(String fmts : parsePatterns){
			d = parse(dateStr,fmts);
			if(d != null){
				break;
			}
		}
		return d;
	}
	//=============解析日期字符串           - end ===============
	//=============格式化日期                   -start===============
	public static String format(Date date){
		return format(date,f_full);
	}
	public static String format(Date date,String fmts){
		if(date == null){
			return null;
		}
		DateTime dt = toDateTime(date);
		return dt.toString(fmts);
	}
	public static String format(String dateStr,String toFmts){
		Date date = parse(dateStr);
		return format(date,toFmts);
	}
	public static String format(String dateStr,String fromFmts,String toFmts){
		Date date = parse(dateStr,fromFmts);
		return format(date,toFmts);
	}
	
	//=============格式化日期                   - end ===============
	public static void main(String[] args) {
		System.out.println(nows("MM//dd"));
		System.out.println(format(parse("02","MM")));
		System.out.println(format(toDateTime("").toDate()));
		DateTime now = new DateTime();
		Date bd = now.toDate();
		//bd = calc(bd,DateField.DAYS,-10);
		bd = set(bd,DateTimeFieldType.dayOfWeek(),3);
		System.out.println(format(bd));
		//计算出一个日期:当前时间的10年前的三月的今天
		String s = DateUtils.getInstance().calc(DurationFieldType.years(), -10).set(DateTimeFieldType.monthOfYear(),3).toString();
		System.out.println(s);
		System.out.println(format(now()));
	}
	
	public static Date calc(Date date,DurationFieldType field,int amount){
		DateTime dt = toDateTime(date);
		dt = dt.withFieldAdded(field, amount);
		return dt.toDate();
	}
	public static Date set(Date date,DateTimeFieldType field,int value){
		DateTime dt = toDateTime(date);
		dt = dt.withField(field, value);
		return dt.toDate();
	}
	
	private DateTime dateTime;
	
	private DateUtils(DateTime dt){
		dateTime = dt;
	}
	
	public static DateUtils getInstance(){
		return new DateUtils(toDateTime(now()));
	}
	public static DateUtils getInstance(String dateStr){
		return new DateUtils(toDateTime(parse(dateStr)));
	}
	public static DateUtils getInstance(Date date){
		return new DateUtils(toDateTime(date));
	}
	public DateUtils calc(DurationFieldType field,int amount){
		dateTime = dateTime.withFieldAdded(field, amount);
		return this;
	}
	public DateUtils set(DateTimeFieldType field,int value){
		dateTime = dateTime.withField(field, value);
		return this;
	}
	
	@Override
	public String toString() {
		return toString(f_full);
	}

	public String toString(String fmt) {
		return dateTime.toString(fmt);
	}
	
	public Date toDate() {
		return dateTime.toDate();
	}
	
	public DateTime toDateTime() {
		return dateTime;
	}
	
	
}
