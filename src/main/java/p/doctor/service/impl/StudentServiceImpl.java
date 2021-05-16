package p.doctor.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import p.doctor.dao.ExamDao;
import p.doctor.dao.StudentDao;
import p.doctor.dto.SignedExam;
import p.doctor.dto.StudentDto;
import p.doctor.entity.Exam;
import p.doctor.entity.Room;
import p.doctor.entity.Student;
import p.doctor.form.RegisterForm;
import p.doctor.service.StudentService;
import p.doctor.utils.ExamChange;
import p.doctor.utils.StudentChange;
import p.doctor.utils.TimeCheck;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;
    @Autowired
    ExamDao examDao;

    @Override
    public Student findStudentByUserName(String userName) {
        Student student = studentDao.findFirstByUserName(userName);
        return student;
    }

    @Override
    public Boolean judgeUserName(String userName) {
        Student target = studentDao.findFirstByUserName(userName);
        if (target==null) return false;
        else return true;
    }

    @Override
    public Boolean addNewStudent(RegisterForm registerForm) {
        Student student = new Student();
        BeanUtils.copyProperties(registerForm,student);
        try{
            studentDao.save(student);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<String> findAllMajors() {
        List<Student> students = studentDao.findAll();
        List<String> majors = new ArrayList<>();
        if (students.isEmpty()) return majors;//empty
        for (Student student:students){
            String major = student.getMajor();
            if (!majors.contains(major)) majors.add(major);
        }
        return majors;
    }

    @Override
    public StudentDto findStudent(String userName) {
        Student student = studentDao.findFirstByUserName(userName);
        if (student==null) return null;
        StudentDto studentDto = StudentChange.changeToDto(student);
        return studentDto;
    }

    @Override
    public List<SignedExam> findAllSignedExam(String userName, Integer pageNo, Integer pageSize) {
        Student student = studentDao.findFirstByUserName(userName);
        Set<Exam> exams = student.getExams();
        List<SignedExam> signedExams = new ArrayList<>();
        Iterator<Exam> iterator = exams.iterator();
        while (iterator.hasNext()){
            Exam next = iterator.next();
            String nextStatus = next.getStatus();
            //判断考试报名的时间是否已经结束
            if (nextStatus.equals("open") && TimeCheck.CheckSignClose(next)){//如果报名时间已经结束
                next.setStatus("close");
                examDao.save(next);
                nextStatus="close";
            }
            //设置单个DTO变量
            SignedExam signedExam = ExamChange.changeToSignedExam(next);
            //判断是否分配了教室
            if (nextStatus.equals("open") || nextStatus.equals("close")) {
                signedExam.setPlace("未定");
            }else if (nextStatus.equals("show")){
                Set<Room> roomSet = next.getRoomSet();
                if (roomSet.isEmpty()) signedExam.setPlace("未定");
                else {//遍历添加考场
                    String placeRoom="";
                    Iterator<Room> roomIterator = roomSet.iterator();
                    while (roomIterator.hasNext()){
                        Room nextRoom = roomIterator.next();
                        if (placeRoom.equals("")) placeRoom+=nextRoom.getPlace();
                        else placeRoom+="/"+nextRoom.getPlace();
                    }
                    signedExam.setPlace(placeRoom);
                }
            }
            signedExams.add(signedExam);
        }
        //目前为止获得了所有的目录,分页操作。
        Integer startIndex = (pageNo-1)*pageSize;
        Integer endIndex = pageNo*pageSize;
        int size = signedExams.size();
        if (size>endIndex) signedExams = signedExams.subList(startIndex,endIndex);
        else if (size>startIndex){
            signedExams = signedExams.subList(startIndex,size);
        }else
            signedExams = signedExams.subList(0,0);
        return signedExams;
    }

    @Override
    public Integer loadTotalPageNo(String userName, Integer pageSize) {
        Student student = studentDao.findFirstByUserName(userName);
        Set<Exam> exams = student.getExams();
        if (!exams.isEmpty()){
            Integer totalSize =  exams.size();
            Integer add = 0;
            if (totalSize%pageSize!=0) add++;
            totalSize=totalSize/pageSize+add;
            return totalSize;
        }else return 0;
    }
}
