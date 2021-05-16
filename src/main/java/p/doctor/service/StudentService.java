package p.doctor.service;

import p.doctor.dto.SignedExam;
import p.doctor.dto.StudentDto;
import p.doctor.entity.Student;
import p.doctor.form.RegisterForm;

import java.util.List;

public interface StudentService {
    Student findStudentByUserName(String userName);
    Boolean judgeUserName(String userName);
    Boolean addNewStudent(RegisterForm registerForm);
    List<String> findAllMajors();
    StudentDto findStudent(String userName);
    List<SignedExam> findAllSignedExam(String userName,Integer pageNo,Integer pageSize);
    Integer loadTotalPageNo(String userName,Integer pageSize);
}
