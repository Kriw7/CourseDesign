package Dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import p.doctor.dto.*;
import p.doctor.entity.Manager;
import p.doctor.entity.Student;
import p.doctor.form.RegisterForm;
import p.doctor.service.ExamService;
import p.doctor.service.ManagerService;
import p.doctor.service.RoomService;
import p.doctor.service.StudentService;
import p.doctor.utils.StudentChange;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:conf/applicationContext.xml"})
@WebAppConfiguration
public class ServiceTest {
    @Autowired
    StudentService studentService;
    @Autowired
    ManagerService managerService;
    @Autowired
    RoomService roomService;
    @Autowired
    ExamService examService;


    @Test
    public void studentTest() {
        Student q = studentService.findStudentByUserName("kriw");
        if (q==null) System.out.println("不存在！！！！");
        else {
            System.out.println(q);
            StudentDto studentDto = new StudentDto();
            studentDto = StudentChange.changeToDto(q);
            System.out.println(studentDto);
        }
    }

    @Test
    public void addTest() {
        RegisterForm registerForm = new RegisterForm("d","ddd","dd","男",16,1,2,"ww");
        studentService.addNewStudent(registerForm);
    }

    @Test
    public void majorTest() {
        studentService.findAllMajors();
    }

    @Test
    public void ExamService() {
        examService.findFirstByExamName("全国计算机一级考试");
    }

    @Test
    public void deleteTest() {
        examService.deleteOneExam("阿库娅");
        //删除exam，relation会一同删除
    }

    @Test
    public void ssdto() {
        StudentDto kriw = studentService.findStudent("kriw");
        System.out.println(kriw);
    }

    @Test
    public void permittedLoadTest() {
        List<PermittedExam> permittedExams = examService.loadPermittedExams("kriw", 1, 8);
        for (PermittedExam e:permittedExams) System.out.println(e);
    }

    @Test
    public void name() {
        List<SignedExam> kriw = studentService.findAllSignedExam("kriw", 3, 3);
        for (SignedExam e:kriw) System.out.println(e);
    }



    @Test
    public void examServiceTest() {
        List<ExamDto> examsByPage = examService.findExamsByPage(1, 20);
        for (ExamDto examDto:examsByPage) System.out.println(examDto);
    }

    @Test
    public void roomTestAs() {//记得回来测试分配考场后能不能正确显示
        List<SignedExam> kriw = studentService.findAllSignedExam("kriw", 1, 20);
        for (SignedExam signedExam:kriw) System.out.println(signedExam);
    }

    @Test
    public void studentListTest() {
        List<PermittedExam> permittedExams = examService.loadPermittedExams("kriw", 1, 20);
        for (PermittedExam exam:permittedExams) System.out.println(exam);
    }

    @Test
    public void RoomTest() {
        List<RoomDto> allByPage = roomService.findAllByPage(1, 10);

    }
}
