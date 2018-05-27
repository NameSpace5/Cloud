package ai.inlight.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimeSwitcher {
    /**
     * 返回指定格式时间 如"yyyy-MM-dd"
     */
    public String timeStamp2Date(String timeString,String format){
        long timeStamp = Long.parseLong(timeString);
        return new SimpleDateFormat(format).format(new Date(timeStamp));
    }

    /**
     * 返回默认yyyy-MM-dd HH:mm:ss格式时间
     */
    public String timeStamp2Date(String timeString){
        long timeStamp = Long.parseLong(timeString);
        String format = "yyyy-MM-dd HH:mm:ss";
        return new SimpleDateFormat(format).format(new Date(timeStamp));
    }

    /**
     * 返回指定时间时间戳 pattern为指定格式 如"yyyy-MM-dd HH:mm:ss"
     */
    public long date2TimeStamp(String date,String pattern) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date res = simpleDateFormat.parse(date);
        return (simpleDateFormat.parse(simpleDateFormat.format(res))).getTime() /1000;
    }

    /**
     * 返回当前时间时间戳
     */
    public long date2TimeStamp(){
        return new Date().getTime();
    }
}
