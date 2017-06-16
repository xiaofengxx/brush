package site.zido.brush.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**身份证号码自动生成年龄
 * Created by CDDC on 2017/6/16.
 */

public class AgeUtils {

    public static Integer getAgeByIDCard(String IDCard) throws ParseException {

        int leh = IDCard.length();
        if (leh != 18 && leh != 15){
            return null;
        }else {
            if (leh == 18) {
                String s1 = IDCard.substring(6, 14);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                Calendar c = Calendar.getInstance();
                c.setTime(sdf.parse(s1));
                Date d = c.getTime();
                return (int) ((new Date().getTime() - d.getTime()) / 1000 / 60 / 60 / 24 / 365);
            } else {
                String s1 = IDCard.substring(6, 12);
                String s2 = "19" + s1;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                Calendar c = Calendar.getInstance();
                c.setTime(sdf.parse(s2));
                Date d = c.getTime();
                return (int) ((new Date().getTime() - d.getTime()) / 1000 / 60 / 60 / 24 / 365);
            }

        }
    }
}
