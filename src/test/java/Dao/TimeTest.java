package Dao;

import org.junit.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest {
    @Test
    public void dateTest() throws ParseException {
        String time ="2021-01-14 00:20:00";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(time);
        System.out.println(date);
        System.out.println(simpleDateFormat.format(date));
    }

    @Test
    public void name() throws ParseException {
        String time ="2021-01-14 00:00:00";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(time);

        Date currentTime = new Date();

        System.out.println(currentTime.before(date));
        System.out.println(currentTime.getTime()>date.getTime());

        Timestamp timestamp = new Timestamp(currentTime.getTime());
        System.out.println(timestamp);
    }
}
