package com.frame.test.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/*
 * 一、java中Date类中的getTime()是获取时间戳的，java中生成的时间戳精确到毫秒级别，而unix中精确到秒级别，所以通过java生成的时间戳需要除以1000。
 */
public class DateFormatTran {
	
	
	
	public static long[] createWeekDayDatelong(long maxdate,int numsrc) throws ParseException
	{
		int num = 0;
		
		long tml = maxdate;
		long tm[] = new long[numsrc];
		while(true)
		{
			//System.out.println("aaa-1+num={"+num);
			if(tml != 1451577600)
			{
				if(DateFormatTran.isWeekdayForSjc(tml))
				{
					tm[num] = tml;
					
					//System.out.println("aaa-1+num="+num);
					num++;
					if(num == numsrc)
						break;
					
				}
			}
			tml = tml - 86400;
			//System.out.println("aaa-1+num=}"+num);
		}
		return tm;
	}
	 /** 
     * @title 判断是否为工作日 
     * @detail 工作日计算: 
     *           1、正常工作日，并且为非假期 
     *           2、周末被调整成工作日 
     * @author chanson 
     * @param date 日期 
     * @return 是工作日返回true，非工作日返回false 
     */  
    public static boolean isWeekdayLtj(GregorianCalendar calendar){  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        if (calendar.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.SATURDAY  
                && calendar.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.SUNDAY)
        {  
            //平时  
            return true;
        }else{  
            //周末  
            return false;
        }  
    } 
    
    /**
     * 
     * @param @param shijianc
     * @param @return
     * @param @throws ParseException
     * @Title isWeekdayForSjc
     * @Description 判断该时间戳是否工作日
     * @return 是工作日返回true，非工作日返回false 
     *
     */
    public static boolean isWeekdayForSjc(long shijianc) throws ParseException
    {
    	SimpleDateFormat format = null;
    	format =  new SimpleDateFormat("yyyy-MM-dd");  
    	Long time=Long.valueOf(shijianc*1000);
    	Date dt = liunxDateTranDate(shijianc);
    	GregorianCalendar gc = new GregorianCalendar();  
        gc.setTime(dt);  
        return isWeekdayLtj(gc);
    }
    
    /**
     * 
     * @param @param dateformat
     * @param @param lxtime
     * @param @return
     * @Title liunxDateTranDate
     * @Description 将时间戳转换为Date类型
     * @return Date
     * @throws ParseException 
     *
     */
    public static Date liunxDateTranDate(long lxtime) throws ParseException 
    {
    	SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");  
    	Long time=Long.valueOf(lxtime*1000);
	    String datefor = format.format(time);  
	    Date date=format.parse(datefor);  
	    return date;
    }
	/*
	 * 时间戳转化为指定格式的（默认为yyyy-MM-dd）的Sting ，并返回该字符串
	 */
	public static String liunxDateTranDateStr(String dateformat,long lxtime)
	{
		String datefor = "";
		//SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		SimpleDateFormat format = null;
		if(dateformat!=null && !dateformat.equals(""))
			 format =  new SimpleDateFormat(dateformat);  
		else
		     format =  new SimpleDateFormat("yyyy-MM-dd");  
	    Long time=Long.valueOf(lxtime*1000);
	    datefor = format.format(time);  
	    //Date date=format.parse(d);  
	   // System.out.println("Format To String(Date):"+datefor);  
	    //System.out.println("Format To Date:"+date);  
		return datefor;
	}
	/*
	 * 将Date（yyyy-MM-dd）格式的String转化为时间戳
	 */
	public static long DateTranLiunxTime(String lxtime) throws ParseException
	{
		 SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");  
		 String time="1970-01-06";  
		 Date date = format.parse(lxtime);
		 System.out.println("Format To times:"+date.getTime());
		 return date.getTime();
	}
	
	/*
	 * 将Date（yyyy-MM-dd）格式的String转化为时间类型
	 */
	public static Date StrTranDate(String lxtime) throws ParseException
	{
		 SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");  
		 Date date = format.parse(lxtime);
		 System.out.println("Format To times:"+date.getTime());
		 return date;
	}
	
    /*
     *    将Date（yyyy-MM-dd）格式的String增加指定时间，再将增加的时间已String返回
     *    dateUnit取值：
     *       Calendar.DAY_OF_MONTH  单位天
     *       Calendar.MONTH         单位月
     *       Calendar.YEAR          单位年
     *    addNum取值：
     *       整数，如果addNum=3，dateUnit=Calendar.MONTH，那即为3个月
     */
	public static String strDateAddOutStr(String lxtime,int dateUnit,int addNum) throws ParseException
	{
		 Calendar c= Calendar.getInstance();
		 SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd"); 
		 Date date = format.parse(lxtime);
		 c.setTime(date);
		 c.add(dateUnit, addNum);
		 date = c.getTime();
		 return format.format(date);
	}
	
	
	/*
     *    将Date（yyyy-MM-dd）格式的String增加指定时间，再将增加的时间以时间戳返回
     *    dateUnit取值：
     *       Calendar.DAY_OF_MONTH  单位天
     *       Calendar.MONTH         单位月
     *       Calendar.YEAR          单位年
     *    addNum取值：
     *       整数，如果addNum=3，dateUnit=Calendar.MONTH，那即为3个月
     */
	public static long strDateAddOutDateLong(String lxtime,int dateUnit,int addNum) throws ParseException
	{
		 Calendar c= Calendar.getInstance();
		 SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd"); 
		 Date date = format.parse(lxtime);
		 c.setTime(date);
		 c.add(dateUnit, addNum);
		 date = c.getTime();
		 return date.getTime();
	}
	
	
	 /*
     *    将时间戳增加指定时间，再将增加的时间已String返回
     *    dateUnit取值：
     *       Calendar.DAY_OF_MONTH  单位天
     *       Calendar.MONTH         单位月
     *       Calendar.YEAR          单位年
     *    addNum取值：
     *       整数，如果addNum=3，dateUnit=Calendar.MONTH，那即为3个月
     */
//	public static String strDateAddOutStr(long lxtime,int dateUnit,int addNum) throws ParseException
//	{
//		 Calendar c= Calendar.getInstance();
//		 SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd"); 
//		 Date date = format.format(Long.valueOf(lxtime));
//		 c.setTime(date);
//		 c.add(dateUnit, addNum);
//		 date = c.getTime();
//		 return format.format(date);
//	}
	 /**
     * unix时间戳转换为dateFormat
     * 
     * @param beginDate
     * @return
     */
    public static String timestampToDate(String beginDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd = sdf.format(new Date(Long.parseLong(beginDate)));
        return sd;
    }
 
    /**
     * 自定义格式时间戳转换
     * 
     * @param beginDate
     * @return
     */
    public static String timestampToDate(String beginDate,String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String sd = sdf.format(new Date(Long.parseLong(beginDate)));
        return sd;
    }
 
    /**
     * 将字符串转为时间戳
     * 
     * @param user_time
     * @return
     */
    public static String dateToTimestamp(String user_time) {
        String re_time = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date d;
        try {
            d = sdf.parse(user_time);
            long l = d.getTime();
            String str = String.valueOf(l);
            re_time = str.substring(0, 10);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return re_time;
    }
	public static void main(String[] args) throws ParseException 
	{
		// TODO Auto-generated method stub
		System.out.println(DateFormatTran.liunxDateTranDateStr(null,1443369600));
		System.out.println(DateFormatTran.DateTranLiunxTime("2016-02-02"));
		System.out.println(DateFormatTran.strDateAddOutStr("2015-09-22", Calendar.DAY_OF_MONTH, 8));
		System.out.println(DateFormatTran.strDateAddOutStr("2015-09-22", Calendar.MONTH, 8));
		

	}

}
