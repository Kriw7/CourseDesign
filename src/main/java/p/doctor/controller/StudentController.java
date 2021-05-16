package p.doctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import p.doctor.controller.base.BaseController;
import p.doctor.dto.SignedExam;
import p.doctor.dto.StudentDto;
import p.doctor.dto.base.JsonResult;
import p.doctor.entity.Student;
import p.doctor.form.RegisterForm;
import p.doctor.service.ExamService;
import p.doctor.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/student")
@SessionAttributes(value = {"userName","name"})
public class StudentController extends BaseController {
    @Autowired
    StudentService studentService;
    @Autowired
    ExamService examService;

    @PostMapping("/jUserName.do")
    @ResponseBody
    public JsonResult<Integer> doJudgeUserName(String userName){
        //判断是否被使用过了，true表示被使用过了，false表示未被使用过
        //result为1表示已经被使用，0表示还未被使用
        Boolean used = studentService.judgeUserName(userName);
        String message; Integer result;
        if (used) {
            message="该用户名已经被注册！";
            result = 1;
        }
        else {
            message="该用户名可以使用！";
            result =0;
        }
        return this.success(message,result);
    }

    @PostMapping("/register.do")
    public ModelAndView doRegister(RegisterForm registerForm){
        ModelAndView mv = new ModelAndView();
        Boolean result = studentService.addNewStudent(registerForm);
        if (result){
            mv.addObject("userName",registerForm.getUserName());
            mv.addObject("name",registerForm.getName());
            mv.setViewName("student/studentHome");
        }else {//系统出错了
            mv.setViewName("redirect:/register.jsp");
        }
        return mv;
    }

    @PostMapping("/loadMajors.do")
    @ResponseBody
    public JsonResult<List<String>> doLoadMajors(){
        List<String> majors = studentService.findAllMajors();
        return this.success(majors);
    }

    @PostMapping("/loadStudentBasicInfo.do")
    @ResponseBody
    public JsonResult<StudentDto> doLoadStudentBasicInfo(String userName){
        StudentDto student = studentService.findStudent(userName);
        return this.success(student);
    }

    @PostMapping("/loadSignedExams.do")
    @ResponseBody
    public JsonResult<List<SignedExam>> doLoadSignedExams(String userName,Integer pageNo,Integer pageSize){
        List<SignedExam> allSignedExam = studentService.findAllSignedExam(userName, pageNo, pageSize);
        return this.success(allSignedExam);
    }

    @PostMapping("/loadTotalPageNo.do")
    @ResponseBody
    public JsonResult<Integer> doLoadTotalPageNo(String userName,Integer pageSize){
        Integer totalPage = studentService.loadTotalPageNo(userName, pageSize);
        return this.success(totalPage);
    }
}
