package com.loskatt.appoint.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class Tools {
	
	/**
	 * 根据出生年月日计算年龄
	 * @param birthDay
	 * @return
	 * @throws Exception
	 */
	public static int getAge(Date birthDay) throws Exception {
        Calendar cal = Calendar.getInstance(); 
        if (cal.before(birthDay)) { //出生日期晚于当前时间无法计算
            throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);  //当前年份
        int monthNow = cal.get(Calendar.MONTH);  //当前月份
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
        cal.setTime(birthDay); 
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);  
        int age = yearNow - yearBirth;   //计算整岁数
            if (monthNow <= monthBirth) {
	            if (monthNow == monthBirth) {
	                if (dayOfMonthNow < dayOfMonthBirth) 
	                	age--;
	            }else{
	                age--;
	            } 
            } 
        return age; 
   }
	
	/**
	 *    字符串转日期格式
	 * @param birthDay
	 * @return
	 * @throws Exception
	 */
	public static  Date parse(String strDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(strDate);
    }
	
	/**
	 *    字符串转日期格式
	 * @param birthDay
	 * @return
	 * @throws Exception
	 */
	
	/**
	 * 返回时间格式：yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
    public static String getDateToStr(Date currDate, String format){
        if(format == null || format.equals(""))
            format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if(currDate == null)
            currDate = new Date();
        String str = sdf.format(currDate);
        return str;
    }
    
    public static Date dateAdd(Date date,int num){
    	Calendar c = Calendar.getInstance();  
	    c.setTime(date);  
	    c.add(Calendar.DAY_OF_MONTH, num);
	    return c.getTime();
	}
    

	public static Date ExcepDate(String dateStr,Integer hour,int min,int sec){
		if(StringUtils.isBlank(dateStr)){
			return null;
		}
		if(hour==null) {
			hour = 17;
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		Date date;
		try {
			date = sf.parse(dateStr);
			c.setTime(date);
			c.set(Calendar.HOUR_OF_DAY, hour);
			c.set(Calendar.MINUTE, min);
			c.set(Calendar.SECOND, sec);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return c.getTime();
	}
    
    
    /**
	 * 字符串起始日期转Date类型后带时分秒
	 * @return date
	 */
	public static Date SToDS(String dateStr){
		if(StringUtils.isBlank(dateStr)){
			return null;
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		Date date;
		try {
			date = sf.parse(dateStr);
			c.setTime(date);
			c.set(Calendar.HOUR_OF_DAY, 00);
			c.set(Calendar.MINUTE, 00);
			c.set(Calendar.SECOND, 00);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return c.getTime();
	}

	/**
	 * 字符串截止日期转Date类型后带时分秒
	 * @return date
	 */
	public static Date SToDE(String dateStr){
		if(StringUtils.isBlank(dateStr)){
			return null;
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		Date date;
		try {
			date = sf.parse(dateStr);
			c.setTime(date);
			c.set(Calendar.HOUR_OF_DAY, 23);
			c.set(Calendar.MINUTE, 59);
			c.set(Calendar.SECOND, 59);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return c.getTime();
	}
    
	
	/**
	 * 返回时间格式：yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String getyyyyMMddTime(Date date){
		if(date == null)
			return null;
		return getDateToStr(date, "yyyy-MM-dd");
	}
}
