package p.doctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import p.doctor.controller.base.BaseController;
import p.doctor.dto.RoomDto;
import p.doctor.dto.base.JsonResult;
import p.doctor.entity.Room;
import p.doctor.form.ArrangeRoomForm;
import p.doctor.service.ExamService;
import p.doctor.service.RoomService;
import p.doctor.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/room")
public class RoomController extends BaseController {
    @Autowired
    ExamService examService;
    @Autowired
    StudentService studentService;
    @Autowired
    RoomService roomService;

    @PostMapping("/loadAllRoomByPage.do")
    @ResponseBody
    public JsonResult<List<RoomDto>> doLoadAllRoomByPage(Integer pageNo, Integer pageSize){
        List<RoomDto> rooms = roomService.findAllByPage(pageNo, pageSize);
        return this.success(rooms);
    }

    @PostMapping("/loadTotalPage.do")
    @ResponseBody
    public JsonResult<Integer> doLoadTotalPage(Integer pageSize){
        Integer totalPageNo = roomService.findTotalPageNo(pageSize);
        return this.success(totalPageNo);
    }

    @PostMapping("/arrangeRoomForExam.do")
    public ModelAndView doArrangeRoomForExam(ArrangeRoomForm arrangeRoomForm){
        ModelAndView mv = new ModelAndView();
        String message = roomService.arrangeRoomForExam(arrangeRoomForm);
        mv.addObject("message",message);
        mv.addObject("examName",arrangeRoomForm.getExamName());
        mv.setViewName("manager/examDetail");
        return mv;
    }

    @PostMapping("/addNewRoom.do")
    public ModelAndView doAddNewRoom(String roomPlace,Integer roomSize){
        ModelAndView mv = new ModelAndView();
        boolean result = roomService.addNewRoom(roomPlace, roomSize);
        if (result){
            mv.addObject("message","教室添加成功！");
        }else
            mv.addObject("message","教室添加失败！请重试");
        mv.setViewName("manager/addRoom");
        return mv;
    }
}
