package p.doctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import p.doctor.controller.base.BaseController;
import p.doctor.entity.Manager;
import p.doctor.entity.Student;
import p.doctor.form.LoginForm;
import p.doctor.service.ManagerService;
import p.doctor.service.StudentService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/page")
@SessionAttributes(value = {"userName","name"})
public class PageController extends BaseController {
    @Autowired
    StudentService studentService;
    @Autowired
    ManagerService managerService;

    @PostMapping("/login.do")
    public ModelAndView doLogin(LoginForm loginForm){
        ModelAndView mv = new ModelAndView();
        String type = loginForm.getType();
        String userName = loginForm.getUserName();
        String password = loginForm.getPassword();
        if (type.equals("student")){//学生登陆
            Student student = studentService.findStudentByUserName(userName);
            if (student==null) {//用户名不存在
                mv.addObject("message","用户名不存在~");
                mv.setViewName("redirect:/login.jsp");
                return mv;
            }
            if (!student.getPassword().equals(loginForm.getPassword())){//密码错误
                mv.addObject("message","密码错误~");
                mv.setViewName("redirect:/login.jsp");
                return mv;
            }
            //账号密码匹配正确，附带学生信息,跳转到主页
            mv.addObject("userName",userName);
            mv.addObject("name",student.getName());
            mv.setViewName("student/studentHome");
        }else if (type.equals("manager")){//管理员登陆
            Manager manager = managerService.findManagerByUserName(userName);
            if (manager==null){//用户名不存在
                mv.addObject("message","管理员先生，您的用户名不存在~");
                mv.setViewName("redirect:/login.jsp");
                return mv;
            }
            if (!manager.getPassword().equals(loginForm.getPassword())){//密码错误
                mv.addObject("message","管理员先生，您的密码错误~");
                mv.setViewName("redirect:/login.jsp");
                return mv;
            }
            //账号密码匹配正确，附带管理员信息，跳转到主页
            mv.addObject("userName",userName);
            mv.addObject("name",manager.getName());
            mv.setViewName("manager/managerHome");
        }else {//异常状况
            mv.setViewName("redirect:/login.jsp");
        }
        return mv;
    }

    @PostMapping("/logout.do")
    public ModelAndView doLogOut(HttpSession session){
        ModelAndView mv = new ModelAndView();
        session.removeAttribute("userName");
        session.removeAttribute("name");
        mv.setViewName("redirect:/index.jsp");
        return mv;
    }
    @PostMapping("/toManagerHome.do")
    public ModelAndView doToManagerHome(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("manager/managerHome");
        return mv;
    }
    @PostMapping("/toAddExam.do")
    public ModelAndView doToAddExam(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("manager/addExam");
        return mv;
    }
    @PostMapping("/toAddRoom.do")
    public ModelAndView doToAddRoom(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("manager/addRoom");
        return mv;
    }
    @PostMapping("/toExamList.do")
    public ModelAndView doToExamList(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("manager/examList");
        return mv;
    }
    @PostMapping("/toExamDetail.do")
    public ModelAndView doToExamDetail(String examName){
        ModelAndView mv = new ModelAndView();
        mv.addObject("examName",examName);
        mv.setViewName("manager/examDetail");
        return mv;
    }
    @PostMapping("/toUpdateExam.do")
    public ModelAndView doUpdateExam(String examName){
        ModelAndView mv = new ModelAndView();
        mv.addObject("examName",examName);
        mv.setViewName("manager/updateExam");
        return mv;
    }

    @PostMapping("/toStudentHome.do")
    public ModelAndView doToStudentHome(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("student/studentHome");
        return mv;
    }
    @PostMapping("/toPermittedExamList.do")
    public ModelAndView doToPermittedExamList(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("student/permittedExamList");
        return mv;
    }
    @PostMapping("/toArrangeRoom.do")
    public ModelAndView doToArrangeRoom(String examName){
        ModelAndView mv = new ModelAndView();
        mv.addObject("examName",examName);
        mv.setViewName("manager/arrangeRoom");
        return mv;
    }

    @PostMapping("/toSignedExams.do")
    public ModelAndView doToSignedExams(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("student/signedExams");
        return mv;
    }
}
