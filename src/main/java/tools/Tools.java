package tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by TianYu on 2016/11/7.
 */
public class Tools {

    public Date DateConvert(String input) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(Long.parseLong(input));
        System.out.println(input+" = "+formatter.format(calendar.getTime()));
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sim.parse(formatter.format(calendar.getTime()));
    }

    public String getMD5(String s){
        char[] hex = "0123456789abcdef".toCharArray();
        char[] rs = new char[hex.length*2];
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            md5.update(s.getBytes());
            byte[] data = md5.digest();
            int k = 0;
            for(int i=0;i<hex.length;i++){
                rs[k++] =  hex[data[i]>>>4&0xf];
                rs[k++] =  hex[data[i]&0xf];
            }
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new String(rs);
    }

}
