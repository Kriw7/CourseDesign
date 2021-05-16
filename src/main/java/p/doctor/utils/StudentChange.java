package p.doctor.utils;

import org.springframework.beans.BeanUtils;
import p.doctor.dto.StudentDto;
import p.doctor.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentChange {
    public static StudentDto changeToDto(Student student){
        StudentDto studentDto = new StudentDto();
        BeanUtils.copyProperties(student,studentDto);
        return studentDto;
    }

    public static List<StudentDto> changeToDto(List<Student> students){
        List<StudentDto> studentDtos = new ArrayList<>();
        for (Student s:students){
            StudentDto studentDto = new StudentDto();
            BeanUtils.copyProperties(s,studentDto);
            studentDtos.add(studentDto);
        }
        return studentDtos;
    }

}
