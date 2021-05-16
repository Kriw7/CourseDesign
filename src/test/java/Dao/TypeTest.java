package Dao;

import org.junit.Test;
import p.doctor.dto.ExamDto;
import p.doctor.entity.Exam;
import p.doctor.utils.ExamChange;

import java.util.ArrayList;
import java.util.List;

public class TypeTest {
    @Test
    public void IntegerToString() {
        String number = "xxx";
        int i =0;
        try{
            i = Integer.parseInt(number);
        }catch (Exception e){
            System.out.println("foolDog");
        }
        System.out.println(i);
    }

    @Test
    public void sub() {
        String major = "Test";
        String majors = "软件工程,XXX,Test";
        System.out.println(majors.contains(major));
    }

    @Test
    public void ArrayTest() {
        List<String> lists = new ArrayList<>();
        for (int i =0;i<4;i++) lists.add("test"+i);
        Integer pageNo = 1;
        Integer pageSize = 4;
        Integer startIndex = (pageNo-1)*pageSize;
        Integer endIndex = pageNo*pageSize;
        Integer size = lists.size();
        if (size>endIndex) lists = lists.subList(startIndex,endIndex);
        else if (size>startIndex){
            lists = lists.subList(startIndex,size);
        }else
            lists = lists.subList(0,0);
        for (String s:lists){
            System.out.println(s);
        }
    }

    @Test
    public void changTest() {
        List<Exam> exams = new ArrayList<>();
        List<ExamDto> examDtos = ExamChange.changeToDto(exams);
        for (ExamDto e:examDtos) System.out.println(e);
    }
}
