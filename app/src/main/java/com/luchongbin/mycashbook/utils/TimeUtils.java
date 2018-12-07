package com.luchongbin.mycashbook.utils;

import android.text.TextUtils;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by admin on 2016/10/15.
 */

public class TimeUtils {

    private static TimeUtils mTimeUtils = null;
    private static String numsMonth[] = {"正", "二", "三", "四", "五", "六", "七", "八", "九", "十", "冬月", "腊"};
    private static String numsDayOfMonth0[] = {"初", "十", "廿", "三"};
    private static String numsDayOfMonth[] = {"十", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    private static final String YAER = "岁";
    private static final String MONTH = "月";
    private static final String DAY = "天";

    private TimeUtils() {

    }

    public static TimeUtils ShareInstance() {
        if (mTimeUtils == null) {
            synchronized (TimeUtils.class) {
                if (mTimeUtils == null) {
                    mTimeUtils = new TimeUtils();
                }
            }
        }
        return mTimeUtils;
    }


    public static String getDate() {
        long millis = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(millis);
        return sdf.format(date);
    }

    public static String getHms() {
        long millis = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(millis);
        return sdf.format(date);
    }

    public static String getDateYYMMDD() {
        long millis = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(millis);
        return sdf.format(date);
    }
    public static String getDateYYMMDD(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static String getDate(long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        Date date = new Date(millis);
        return sdf.format(date);
    }

    public static String getDateYYMMDD(long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(millis);
        return sdf.format(date);
    }

    public static String getDateHHMM(long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date = new Date(millis);
        return sdf.format(date);
    }

    public static String getDateYYMMDDHHMMSS(long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(millis);
        return sdf.format(date);
    }

    public static long dateToStamp(String s) {
        long time = 0;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simpleDateFormat.parse(s);
            time = date.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }

    public static long getHHMMSS(String s) {
        long time = 0;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            Date date = simpleDateFormat.parse(s);
            time = date.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }

    public static Calendar getOldTime(String s) {
        Calendar calendar = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simpleDateFormat.parse(s);
            calendar = Calendar.getInstance();
            calendar.setTime(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return calendar;
    }
//    public  static  Calendar  getCurrentTime(String s) {
//        Calendar calendar = null;
//        try {
//            long millis = System.currentTimeMillis();
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            Date date = new Date(millis);
//            String format = simpleDateFormat.format(date);
//            calendar = Calendar.getInstance();
//            calendar.setTime(date);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return calendar;
//    }

    public static long getCureentTime() {
        return System.currentTimeMillis();
    }

    /**
     * 信息页列表时间显示
     *
     * @param time
     * @return
     */
    public static String changeTime(String time) {
        String showTime = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long millis = 0;
        Date date = null;
        try {
            date = sdf.parse(time);
            millis = date.getTime();

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

        Calendar today = Calendar.getInstance();
        Date d = new Date(System.currentTimeMillis());
        today.setTime(d);

        Calendar showDay = Calendar.getInstance();
        Date d1 = new Date(millis);
        showDay.setTime(d1);
        int i = today.get(Calendar.DAY_OF_YEAR) - showDay.get(Calendar.DAY_OF_YEAR);

        SimpleDateFormat s = new SimpleDateFormat("HH:mm");
        String onlyTime = s.format(date);

        if (i == 0) {
            //今天
            showTime = onlyTime;
        } else if (i == 1) {
            //昨天
            showTime = "昨天";
        } else if ((i < 7) && (i > 1)) {
            //一星期以内
            String week = String.valueOf(showDay.get(Calendar.DAY_OF_WEEK));
            switch (week) {
                case "1":
                    showTime = "星期日";
                    break;
                case "2":
                    showTime = "星期一";
                    break;
                case "3":
                    showTime = "星期二";
                    break;
                case "4":
                    showTime = "星期三";
                    break;
                case "5":
                    showTime = "星期四";
                    break;
                case "6":
                    showTime = "星期五";
                    break;
                case "7":
                    showTime = "星期六";
                    break;
            }

        } else {
            SimpleDateFormat s1 = new SimpleDateFormat("MM月dd日");
            showTime = s1.format(date);
        }

        return showTime;
    }


    /**
     * 群公告列表显示的时间
     *
     * @param millis
     * @return
     */
    public static String groupNoticeTime(long millis) {
        String showTime = "";
        Date date = new Date(millis);

        Calendar today = Calendar.getInstance();
        Date d = new Date(System.currentTimeMillis());
        today.setTime(d);

        Calendar showDay = Calendar.getInstance();
        Date d1 = new Date(millis);
        showDay.setTime(d1);
        int i = today.get(Calendar.DAY_OF_YEAR) - showDay.get(Calendar.DAY_OF_YEAR);

        SimpleDateFormat s = new SimpleDateFormat("HH:mm");
        String onlyTime = s.format(date);

        if (i == 0) {
            //今天
            showTime = "今天 " + onlyTime;
        } else if (i == 1) {
            //昨天
            showTime = "昨天 " + onlyTime;
        } else if ((i < 7) && (i > 1)) {
            //一星期以内
            String week = String.valueOf(showDay.get(Calendar.DAY_OF_WEEK));
            switch (week) {
                case "1":
                    showTime = "星期日 " + onlyTime;
                    break;
                case "2":
                    showTime = "星期一 " + onlyTime;
                    break;
                case "3":
                    showTime = "星期二 " + onlyTime;
                    break;
                case "4":
                    showTime = "星期三 " + onlyTime;
                    break;
                case "5":
                    showTime = "星期四 " + onlyTime;
                    break;
                case "6":
                    showTime = "星期五 " + onlyTime;
                    break;
                case "7":
                    showTime = "星期六 " + onlyTime;
                    break;
            }

        } else {
            SimpleDateFormat s1 = new SimpleDateFormat("MM月dd日");
            showTime = s1.format(date) + " " + onlyTime;
        }
        return showTime;
    }

    /**
     * 群公告列表显示的时间 : 今天  昨天 星期一 星期二
     *
     * @param millis
     * @return
     */
    public static String groupNoticeTime2(long millis) {
        String showTime = "";
        Date date = new Date(millis);

        Calendar today = Calendar.getInstance();
        Date d = new Date(System.currentTimeMillis());
        today.setTime(d);

        Calendar showDay = Calendar.getInstance();
        Date d1 = new Date(millis);
        showDay.setTime(d1);
        int i = today.get(Calendar.DAY_OF_YEAR) - showDay.get(Calendar.DAY_OF_YEAR);

        if (i == 0) {
            //今天
            showTime = "今天";
        } else if (i == 1) {
            //昨天
            showTime = "昨天";
        } else if ((i < 7) && (i > 1)) {
            //一星期以内
            String week = String.valueOf(showDay.get(Calendar.DAY_OF_WEEK));
            switch (week) {
                case "1":
                    showTime = "星期日";
                    break;
                case "2":
                    showTime = "星期一";
                    break;
                case "3":
                    showTime = "星期二";
                    break;
                case "4":
                    showTime = "星期三";
                    break;
                case "5":
                    showTime = "星期四";
                    break;
                case "6":
                    showTime = "星期五";
                    break;
                case "7":
                    showTime = "星期六";
                    break;
            }

        } else {
            SimpleDateFormat s1 = new SimpleDateFormat("MM月dd日");
            showTime = s1.format(date);
        }
        return showTime;
    }

    public static String formatTimeUs(String time) {

        if (time == null || TextUtils.isEmpty(time)) {
            return "";
        }

        long l_time = Long.parseLong(time);


        StringBuilder builder = new StringBuilder();

        if (l_time > 0 && l_time < 60 * 1000) {//超过一秒小于一分钟
            builder.append("00");
            builder.append(":");
            builder.append("" + l_time / 1000);
        } else if (l_time >= 60 * 1000 && l_time < 60 * 60 * 1000) {//大于一分钟小于一个小时
            builder.append("" + l_time / 60000);
            builder.append(":");
            builder.append("" + (l_time % 60000) / 1000);
        } else {//大于一个小时
            builder.append("" + l_time / 3600000);
            builder.append(":");
            long min = l_time / (1000 * 60) % 60;
            if (min >= 0 && min < 10) {
                builder.append("0" + min);
            } else if (min >= 10 && min < 60) {
                builder.append(min + "");
            } else {
                builder.append("00");
            }

            builder.append(":");

            long sec = l_time / (1000 * 60 * 60) % 60;

            if (sec >= 0 && sec < 10) {
                builder.append("0" + sec);
            } else if (sec >= 10 && sec < 59) {
                builder.append("" + sec);
            } else {
                builder.append("00");
            }
        }

        return builder.toString();
    }

    public static String star(int month, int day) {
        String star = "";
        if (month == 1 && day >= 20 || month == 2 && day <= 18) {
            star = "水瓶座";
        }
        if (month == 2 && day >= 19 || month == 3 && day <= 20) {
            star = "双鱼座";
        }
        if (month == 3 && day >= 21 || month == 4 && day <= 19) {
            star = "白羊座";
        }
        if (month == 4 && day >= 20 || month == 5 && day <= 20) {
            star = "金牛座";
        }
        if (month == 5 && day >= 21 || month == 6 && day <= 21) {
            star = "双子座";
        }
        if (month == 6 && day >= 22 || month == 7 && day <= 22) {
            star = "巨蟹座";
        }
        if (month == 7 && day >= 23 || month == 8 && day <= 22) {
            star = "狮子座";
        }
        if (month == 8 && day >= 23 || month == 9 && day <= 22) {
            star = "处女座";
        }
        if (month == 9 && day >= 23 || month == 10 && day <= 22) {
            star = "天秤座";
        }
        if (month == 10 && day >= 23 || month == 11 && day <= 21) {
            star = "天蝎座";
        }
        if (month == 11 && day >= 22 || month == 12 && day <= 21) {
            star = "射手座";
        }
        if (month == 12 && day >= 22 || month == 1 && day <= 19) {
            star = "摩羯座";
        }
        return star;
    }

    /**
     * 获取农历月份
     *
     * @param input
     * @return
     */
    public static String numsMonth(int input) {
        if (input > 12) {
            return "";
        }

        return numsMonth[input - 1];
    }

    /**
     * 获取农历日
     *
     * @param inputInt
     * @return
     */
    public static String numsDayOfMonth(int inputInt) {
        String result[];
        if (inputInt < 10) {
            return "初" + numsDayOfMonth[inputInt];
        }
        if (inputInt == 10) {
            return "初十";
        }
        if (inputInt == 31) {
            return "三十一";
        }

        String input = String.valueOf(inputInt);
        result = new String[input.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = String.valueOf(input.charAt(i));
        }
        int dayOfMonth = Integer.parseInt(result[1]);

        int month = Integer.parseInt(result[0]);
        return numsDayOfMonth0[month] + numsDayOfMonth[dayOfMonth];
    }

    public static String getBlogTime(String blogTime) {


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format2 = new SimpleDateFormat("MM-dd");
        try {
            Date date = format.parse(blogTime);
            //================>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

            Calendar instance = Calendar.getInstance();
            int currentYear = instance.get(Calendar.YEAR);
            int currentMonth = instance.get(Calendar.MONTH) + 1;
            int currentDay = instance.get(Calendar.DAY_OF_MONTH);

            SimpleDateFormat blogFormat = new SimpleDateFormat("yyyy-MM-dd");
            String blog_Time = blogFormat.format(date);
            String[] split = blog_Time.split("-");
            int blog_year = Integer.parseInt(split[0]);
            int blog_month = Integer.parseInt(split[1]);
            int blog_day = Integer.parseInt(split[2]);

            Log.i("jsonhu", "Calendar date = " + currentYear + "年" + currentMonth + "月" + currentDay + "日");
            Log.i("jsonhu", "Blog date = " + blog_year + "年" + blog_month + "月" + blog_day + "日");

            if (blog_year == currentYear && blog_month == currentMonth) {
                if (blog_day == currentDay) {
                    return "今天";
                }

                if (currentDay - blog_day == 1) {
                    return "昨天";
                }

            }

            return format2.format(date);

        } catch (Exception e) {
            e.printStackTrace();
        }


        return "";
    }

    public static String convertYMDHms2YMD(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = format.parse(time);
            SimpleDateFormat blogFormat = new SimpleDateFormat("yyyy-MM-dd");
            String newtime = blogFormat.format(date);

            return newtime;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }

    /**
     * 将年月日转换成时间戳
     *
     * @param blog_time
     * @return
     */
    public static long getLongTime(String blog_time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = format.parse(blog_time);
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0L;
    }

    public static String convertYMDHms2Y(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = format.parse(time);
            SimpleDateFormat blogFormat = new SimpleDateFormat("yyyy");
            String newtime = blogFormat.format(date);

            return newtime;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }
    public static String convertYMD2YM(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format.parse(time);
            SimpleDateFormat blogFormat = new SimpleDateFormat("yyyy-MM");
            String newtime = blogFormat.format(date);

            return newtime;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String getBabyAge(String birthday, String blogTime) {

        String str_age = "";

        long birth_time = dateToStamp(birthday);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            long blog_time = format.parse(blogTime).getTime();

            long age_time = blog_time - birth_time;
            if (age_time >= 0) {
                str_age = getAge(age_time);
            }else {//此处说明宝宝还未出生
                str_age = "距出生还有"+getFutureAge(Math.abs(age_time));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return str_age;
    }

    private static String getFutureAge(long age_time) {

        StringBuilder sb = new StringBuilder();
        long day = age_time / (24 * 3600 * 1000);
        if (day >= 0  && day < 365){//一年以内
            long month = day / 30;

            if (month>0){
                long sub_day = day % 30;
                sb.append(month);
                sb.append(MONTH);
                if (sub_day>0 && sub_day <10){
                    sb.append("零");
                    sb.append(sub_day);
                    sb.append(DAY);
                }else if (sub_day >= 10){
                    sb.append(sub_day);
                    sb.append(DAY);
                }
            }else {
                long sub_day = day % 30;
                if (sub_day>0 && sub_day <10){
                    sb.append(sub_day);
                    sb.append(DAY);
                }else if (sub_day >= 10){
                    sb.append(sub_day);
                    sb.append(DAY);
                }else {
                    sb.append("出生");
                }
            }
        }else if (day >= 365){//一年以上
            long year = day / 365;
            long month = (day % 365) / 30;
            long sub_day = (day % 365) % 30;
            sb.append(year);
            sb.append("年");

            if (month > 0){
                sb.append(month);
                sb.append(MONTH);
            }

            if (sub_day > 0 ){
                if (sub_day <10 ) {
                    sb.append("零");
                }
                sb.append(sub_day);
                sb.append(DAY);
            }
        }

        return sb.toString();
    }

    private static String getAge(long age_time) {
        StringBuilder sb = new StringBuilder();
        long day = age_time / (24 * 3600 * 1000);
        if (day >= 0 && day < 365) {//一年以内
            long month = day / 30;

            if (month > 0) {
                long sub_day = day % 30;
                sb.append(month);
                sb.append(MONTH);
                if (sub_day > 0 && sub_day < 10) {
                    sb.append("零");
                    sb.append(sub_day);
                    sb.append(DAY);
                } else if (sub_day >= 10) {
                    sb.append(sub_day);
                    sb.append(DAY);
                }
            } else {
                long sub_day = day % 30;
                if (sub_day > 0 && sub_day < 10) {
                    sb.append(sub_day);
                    sb.append(DAY);
                } else if (sub_day >= 10) {
                    sb.append(sub_day);
                    sb.append(DAY);
                } else {
                    sb.append("出生");
                }
            }
        } else if (day >= 365) {//一年以上
            long year = day / 365;
            long month = (day % 365) / 30;
            long sub_day = (day % 365) % 30;
            sb.append(year);
            sb.append(YAER);

            if (month > 0) {
                sb.append(month);
                sb.append(MONTH);
            }

            if (sub_day > 0) {
                if (sub_day < 10) {
                    sb.append("零");
                }
                sb.append(sub_day);
                sb.append(DAY);
            }
        } else { //宝宝还未出生

        }

        return sb.toString();
    }

    public static String getShowTime(String loadTime) {
        String time = loadTime;
        try {
            if (!TextUtils.isEmpty(time)) {
                Calendar c = Calendar.getInstance();
                long year = c.get(Calendar.YEAR);
                long month = c.get(Calendar.MONTH) + 1;
                long day = c.get(Calendar.DAY_OF_MONTH);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                if (String.valueOf(month).length() < 2) {
                    month = 0 + month;
                }
                if (String.valueOf(day).length() < 2) {
                    day = 0 + day;
                }
                Date date = format.parse(year + "-" + month + "-" + day);
                String nowTime = format.format(date);
                if (nowTime.equals(loadTime)) {
                    time = "今天";
                } else {
                    c.add(Calendar.DAY_OF_MONTH, -1);
                    Date yesteDay = c.getTime();
                    String nextime = format.format(yesteDay);
                    if (time.equals(nextime)) {
                        time = "昨天";
                    } else {
                        SimpleDateFormat formatday = new SimpleDateFormat("yyyy年MM月dd日");
                        time = formatday.format(loadTime);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }


    /**
     * 取两个指定时间的日期差值
     *
     * @param begin  比较大的日期
     * @param end    比较小的日期
     * @param format 格式
     * @return
     */
    public static long diffDay(String begin, String end, String format) {
        long rday = 0l;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date cbegin = sdf.parse(begin);
            Date cend = sdf.parse(end);
            long l = cbegin.getTime() - cend.getTime();
            rday = l / (24 * 60 * 60 * 1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rday;

    }


    /**
     * 年月日 转 时间戳
     *
     * @param time
     * @return
     */
    public static long getTimeyyyyMMdd(String time) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(time);
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }


//    public static long time(){
////        diffDay();
//    }
//    DateUtils.diffDay(DateUtils.getCurrentDateString(),map.get("birthday").toString(), "yyyy-MM-dd");

}
