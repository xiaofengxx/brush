package site.zido.brush.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**身份证号码转换年龄
 * Created by CDDC on 2017/6/16.
 */

public class AgeUtils {
    /**
     *通过输入的身份证读出年龄
     */
    public Object getAgeByIDCard(String bindCard) throws ParseException {

        int leh = bindCard.length();
        if (leh != 18 && leh != 15){
            return "请输入正确的身份证号！";
        }else{
            if (leh == 18) {
                String s1 = bindCard.substring(6,14);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                    Calendar c = Calendar.getInstance();
                    c.setTime(sdf.parse(s1));
                    Date d = c.getTime();
                    int age = (int) ((new Date().getTime()-d.getTime())/1000/60/60/24/365);
                    return age;
                }else {
                String s1 = bindCard.substring(6,12);
                String s2 = "19" + s1;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                Calendar c = Calendar.getInstance();
                c.setTime(sdf.parse(s2));
                Date d = c.getTime();
                int age = (int) ((new Date().getTime()-d.getTime())/1000/60/60/24/365);
                return age;
            }
        }
    }
}
