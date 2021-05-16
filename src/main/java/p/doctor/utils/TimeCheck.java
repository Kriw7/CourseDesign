package p.doctor.utils;

import p.doctor.entity.Exam;

import java.util.Date;

public class TimeCheck {
    public static boolean CheckSignClose(Exam exam){
        //该方法用来检测考试的报名时间是否截止了
        Date currentTime = new Date();
        Date signEndTime = exam.getSignEndTime();
        //如果当前时间已经比考试报名的截止时间后了，就返回true表示考试已经截止。如果在之前，则返回false表示还未截止。
        if (currentTime.after(signEndTime)) return true;
        else return false;
    }
}
