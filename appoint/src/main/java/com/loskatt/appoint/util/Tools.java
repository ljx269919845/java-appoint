package com.loskatt.appoint.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	    c.add(Calendar.DAY_OF_MONTH, 1);
	    return c.getTime();
	}
    
}
