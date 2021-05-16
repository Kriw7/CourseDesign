package p.doctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import p.doctor.controller.base.BaseController;
import p.doctor.dto.ExamDto;
import p.doctor.dto.PermittedExam;
import p.doctor.dto.base.JsonResult;
import p.doctor.form.NewExamForm;
import p.doctor.service.ExamService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/exam")
public class ExamController extends BaseController {
    @Autowired
    ExamService examService;

    @PostMapping("/loadExamsByPage.do")
    @ResponseBody
    public JsonResult<List<ExamDto>> doLoadExamsByPage(Integer pageNo, Integer pageSize){
        List<ExamDto> examDtos = examService.findExamsByPage(pageNo, pageSize);
        return this.success(examDtos);
    }

    @PostMapping("/loadTotalPage.do")
    @ResponseBody
    public JsonResult<Integer> doLoadTotalPage(Integer pageSize){
        if (pageSize<0 || pageSize>10) return this.error("传递的一页数量有误!");
        Integer totalPage = examService.getTotalPage(pageSize);
        return this.success(totalPage);
    }

    @PostMapping("/addNewExam.do")
    public ModelAndView doAddNewExam(NewExamForm form,String userName) throws ParseException {
        ModelAndView mv = new ModelAndView();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date beginTime = simpleDateFormat.parse(form.getBeginTime());
        Date endTime = simpleDateFormat.parse(form.getEndTime());
        Date signBeginTime = simpleDateFormat.parse(form.getSignBeginTime());
        Date signEndTime = simpleDateFormat.parse(form.getSignEndTime());
        ExamDto examDto  = new ExamDto(form.getType(),Integer.parseInt(form.getLevel()),form.getName(),form.getContent(),
                beginTime,endTime,signBeginTime,signEndTime);
        //数字的判断交给前端。
        String majors = "";
        for (String s:form.getPermittedMajors()){
            if (majors.equals("")) majors+=s;
            else majors+=","+s;
        }
        examDto.setPermittedMajors(majors);
        examDto.setMaxGrade(form.getMaxGrade());
        boolean result = examService.addNewExam(examDto,userName);
        if (result) mv.addObject("addExamResult","新一场考试添加成功！");
        else  mv.addObject("addExamResult","抱歉系统出现了一点问题，请重试！");
        mv.setViewName("manager/addExam");
        return mv;
    }

    @PostMapping("/updateExam.do")
    public ModelAndView doUpdateExam(NewExamForm form,String userName,Integer examId) throws ParseException {
        ModelAndView mv = new ModelAndView();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date beginTime = simpleDateFormat.parse(form.getBeginTime());
        Date endTime = simpleDateFormat.parse(form.getEndTime());
        Date signBeginTime = simpleDateFormat.parse(form.getSignBeginTime());
        Date signEndTime = simpleDateFormat.parse(form.getSignEndTime());
        ExamDto examDto  = new ExamDto(form.getType(),Integer.parseInt(form.getLevel()),form.getName(),form.getContent(),
                beginTime,endTime,signBeginTime,signEndTime);
        //获取专业的String组合
        String majors = "";
        for (String s:form.getPermittedMajors()){
            if (majors.equals("")) majors+=s;
            else majors+=","+s;
        }
        examDto.setPermittedMajors(majors);
        examDto.setMaxGrade(form.getMaxGrade());
            System.out.println("————————————————————————");
            System.out.println(examDto.getMaxGrade());
            System.out.println("————————————————————————");
        examDto.setId(examId);
            System.out.println(examDto);
        boolean result = examService.updateExam(examDto,userName);
        if (result) {
            mv.addObject("message","考试更新成功！");
            mv.addObject("examName",form.getName());
            mv.setViewName("manager/examDetail");
        }
        else  {
            mv.addObject("message","抱歉系统出现了一点问题，请重试！");
            mv.setViewName("manager/updateExam");
        }
        return mv;
    }

    @RequestMapping("/loadOneByExamName.do")
    @ResponseBody
    public JsonResult<ExamDto> doLoadOneByExamName(String examName){
        ExamDto examDto = examService.findFirstByExamName(examName);
        return this.success(examDto);
    }

    @RequestMapping("/deleteExam.do")
    @ResponseBody
    public JsonResult<Integer> doDeleteExam(String examName){
        boolean result = examService.deleteOneExam(examName);
        if (result) return this.success("删除成功");
        else return this.error("删除失败！请重试！");
    }

    @RequestMapping("/loadPermittedExams.do")
    @ResponseBody
    public JsonResult<List<PermittedExam>> doLoadPermittedExams(String userName,Integer pageNo,Integer pageSize){
        List<PermittedExam> PermittedExam = examService.loadPermittedExams(userName, pageNo, pageSize);
        return this.success(PermittedExam);
    }

    @RequestMapping("/loadTotalPermittedPage.do")
    @ResponseBody
    public JsonResult<Integer> doLoadTotalPermittedPage(String userName,Integer pageSize){
        Integer result = examService.getTotalPermittedPage(userName, pageSize);
        return this.success(result);
    }

    @RequestMapping("/loadRoomPlace.do")
    @ResponseBody
    public JsonResult<String> doLoadRoomPlace(String examName){
        String result = examService.loadExamRooms(examName);
        if (result.equals("")) return this.error("读取考场失败！请检查与服务器的连接.");
        else return this.success(result);
    }

}
