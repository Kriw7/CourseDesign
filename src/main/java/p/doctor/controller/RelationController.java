package p.doctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import p.doctor.controller.base.BaseController;
import p.doctor.dto.base.JsonResult;
import p.doctor.service.ExamService;
import p.doctor.service.StudentService;

@Controller
@RequestMapping("/relation")
public class RelationController  extends BaseController {
    @Autowired
    ExamService examService;
    @Autowired
    StudentService studentService;

    @PostMapping("/signNewExam.do")
//    @GetMapping("/signNewExam.do")
    @ResponseBody
    public JsonResult<Integer> doSignNewExam(String userName,String examName){
        Integer result= examService.signNewRelation(userName, examName);
        if(result==0) return this.error("报名失败！不在报名时间内！");
        else if (result==1) return this.error("同种类型的考试只能报名其中一场！请斟酌选择。");
        else if (result==2) return this.error("时间段重复了！该时间段内有考试！请修改您的安排～");
        else if (result==3) return this.success("报名成功！");
        return this.error("抱歉，系统开了一点小差。请重试。");
    }

    @PostMapping("/cancelOldRelation.do")
    @ResponseBody
    public JsonResult<Integer> doCancelOldRelation(String userName,String examName){
        System.out.println("来到了控制器来处理退选.");
        Integer result = examService.cancelOldRelation(userName, examName);
        System.out.println("控制器已经处理完退选过程了");
        System.out.println(result);
        if (result==-1) return this.error("已超过报名时间，不能退选");
        else return this.success("退选成功！");
    }

}
