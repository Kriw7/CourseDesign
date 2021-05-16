package p.doctor.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import p.doctor.dao.ExamDao;
import p.doctor.dao.ManagerDao;
import p.doctor.dao.RoomDao;
import p.doctor.dao.StudentDao;
import p.doctor.dto.ExamDto;
import p.doctor.dto.PermittedExam;
import p.doctor.entity.Exam;
import p.doctor.entity.Manager;
import p.doctor.entity.Room;
import p.doctor.entity.Student;
import p.doctor.service.ExamService;
import p.doctor.utils.ExamChange;
import p.doctor.utils.LockUtil;
import p.doctor.utils.TimeCheck;
import p.doctor.utils.UserLock;

import javax.transaction.Transactional;

import java.util.*;

@Service
@Transactional
public class ExamServiceImpl implements ExamService {
    @Autowired
    ExamDao examDao;
    @Autowired
    ManagerDao managerDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    RoomDao roomDao;

    @Override
    public List<ExamDto> findExamsByPage(Integer pageNo, Integer pageSize) {
        Pageable pageable = new PageRequest(pageNo-1,pageSize);
        Page<Exam> page = examDao.findAll(pageable);
        List<Exam> exams = page.getContent();
        for (Exam exam:exams){
            if (exam.getStatus().equals("open") && TimeCheck.CheckSignClose(exam)) {//检查状态
                exam.setStatus("close");
                examDao.save(exam);
            }
        }
        List<ExamDto> examDtos = ExamChange.changeToDto(exams);
        return examDtos;
    }

    @Override
    public Integer getTotalPage(Integer pageSize) {
        List<Exam> exams = examDao.findAll();
        if (!exams.isEmpty()){
            Integer totalSize =  exams.size();
            Integer add = 0;
            if (totalSize%pageSize!=0) add++;
            totalSize=totalSize/pageSize+add;
            return totalSize;
        }else return 0;
    }

    @Override
    public synchronized boolean addNewExam(ExamDto examDto,String userName) {
        try {
            Exam exam = new Exam();
            BeanUtils.copyProperties(examDto, exam);
            exam.setNums(0);
            exam.setStatus("open");
            exam = examDao.save(exam);
            Manager manager = managerDao.findFirstByUserName(userName);
            exam.setManager(manager);
            examDao.save(exam);
        }catch (Exception e){
            System.out.println("出现了异常");
            return false;
        }
        return true;
    }

    @Override
    public synchronized boolean updateExam(ExamDto examDto, String userName) {
        Integer id = examDto.getId();
        Exam exam = examDao.findFirstById(id);
        //更新基本的信息
        exam = ExamChange.updateExam(exam,examDto);
        exam.setMaxGrade(examDto.getMaxGrade());
        //添加管理员的信息
        exam = examDao.save(exam);
        Manager manager = managerDao.findFirstByUserName(userName);
        exam.setManager(manager);
        exam = examDao.save(exam);
        return true;
    }

    @Override
    public ExamDto findFirstByExamName(String examName) {
        Exam exam = examDao.findFirstByName(examName);
        if (exam==null) return null;
        ExamDto examDto = ExamChange.changeToDto(exam);
        examDto.setExamController(exam.getManager().getName());
        return examDto;
    }

    @Override
    public synchronized boolean deleteOneExam(String examName) {
        Exam exam = examDao.findFirstByName(examName);
        if (exam==null) return false;
        if(exam.getRoomSet()!=null || !exam.getRoomSet().isEmpty()){//如果已经分配了教室
            Set<Room> roomSet = exam.getRoomSet();
            Iterator<Room> iterator = roomSet.iterator();
            while (iterator.hasNext()){
                Room next = iterator.next();
                next.setExam(null);
                next.setStatus("free");
                roomDao.save(next);
            }
        }
        examDao.delete(exam);
        return true;
    }

    @Override
    public List<PermittedExam> loadPermittedExams(String userName, Integer pageNo, Integer pageSize) {
        //1.17现在添加对考试状态检测，可在全部考试查询的时候添加，也可为允许的考试列表添加。
        //个人考虑，为过滤后的考试列表添加，反正用户肯定会翻页查看列表，效率更重要。
        Student student = studentDao.findFirstByUserName(userName);
        if (student==null) return null;
        List<Exam> allExams = examDao.findAll();
        List<Exam> permittedExams = new ArrayList<>();
        Integer studentGrade = student.getGrade();
        String studentMajor = student.getMajor();
        for (Exam exam:allExams){//遍历判断
            Integer maxGrade = exam.getMaxGrade();
            String permittedMajors = exam.getPermittedMajors();
            //年级和专业都ok的话
            if (studentGrade<=maxGrade && (permittedMajors.equals("all") || permittedMajors.contains(studentMajor)))
                permittedExams.add(exam);
        }
        Integer startIndex = (pageNo-1)*pageSize;
        Integer endIndex = pageNo*pageSize;
        Integer size = permittedExams.size();
        if (size>endIndex) permittedExams = permittedExams.subList(startIndex,endIndex);
        else if (size>startIndex){
            permittedExams = permittedExams.subList(startIndex,size);
        }else
            permittedExams = permittedExams.subList(0,0);
        //到此为止，获得了对应页面所需的信息考试信息，接下来需要添加之间的关系信息
        List<PermittedExam> result = new ArrayList<>();
        for (Exam exam:permittedExams){
            boolean contains = false;
            Set<Student> students = exam.getStudents();
            if (!students.isEmpty()){
                for (Student s:students) {
                    if (s.getUserName().equals(userName)) {
                        contains = true;
                        break;
                    }
                }
            }
            //新添加检测考试状态的部分.
            if (exam.getStatus().equals("open") && TimeCheck.CheckSignClose(exam)){
                exam.setStatus("close");
                examDao.save(exam);
            }
            PermittedExam oneTarget = ExamChange.changeToPermitted(exam);
            if (contains){//如果该学生已经报名了该考试，设置
                oneTarget.setRelation(true);
            }else  oneTarget.setRelation(false);
            result.add(oneTarget);
        }
        return result;
    }

    @Override
    public Integer getTotalPermittedPage(String userName, Integer pageSize) {
        Student student = studentDao.findFirstByUserName(userName);
        if (student==null) return 0;
        List<Exam> allExams = examDao.findAll();
        List<Exam> permittedExams = new ArrayList<>();
        Integer studentGrade = student.getGrade();
        String studentMajor = student.getMajor();
        for (Exam exam:allExams){//遍历判断
            Integer maxGrade = exam.getMaxGrade();
            String permittedMajors = exam.getPermittedMajors();
            if (studentGrade<=maxGrade && (permittedMajors.equals("all") || permittedMajors.contains(studentMajor)))
                permittedExams.add(exam);
        }
        if (!permittedExams.isEmpty()){
            Integer totalSize =  permittedExams.size();
            Integer add = 0;
            if (totalSize%pageSize!=0) add++;
            totalSize=totalSize/pageSize+add;
            return totalSize;
        }else return 0;
    }

    @Override
    public  Integer signNewRelation(String userName, String examName) {
        //返回值0代表时间不对，1代表已经报名了同类型，2代表时间重复，3代表报名成功，-1代表服务器异常

        //首先进行进行加锁控制. 改进。为了更好的封装性，需要在这里将非空处理包装到工具类的内部。
//        UserLock userLock = UserLock.getInstance();
//        userLock.putIfAbsent(userName, false);

        //加锁.然后处理业务。2021.4.19使用了一个单例的HashMap对象进行加锁。
        synchronized(LockUtil.getLockObject(userName)){
            System.out.println(Thread.currentThread().getName()+"获得了锁");
            Student student = studentDao.findFirstByUserName(userName);
            Exam exam = examDao.findFirstByName(examName);

            //查询获得的信息和这下面的逻辑判断脱节了，多线程的情况下会出现问题。2021.4.18在Service层加锁。

            //报名需要控制三点
            //其一，是报名时间. 判断的方法是在当前时间与报名的开始与结束的时间的比较
            Date signBeginTime = exam.getSignBeginTime();
            Date signEndTime = exam.getSignEndTime();
            Date currentTime = new Date();
            if (currentTime.after(signEndTime) || currentTime.before(signBeginTime)) return 0;
            //其二，是同类型检测
            //其三，是那个时间段上是否已经报名了
            String examType = exam.getType();
            Set<Exam> exams = student.getExams();
            Iterator<Exam> iterator = exams.iterator();
            Date beginTime = exam.getBeginTime();
            Date endTime = exam.getEndTime();
            long bt = beginTime.getTime();
            long et = beginTime.getTime();
            while (iterator.hasNext()){//遍历当前学生已经报名的所有的考试
                Exam next = iterator.next();
                //判断类型重复
                if (next.getType().equals(examType)){
                    return 1;
                }
                //判断时间片重复->方法是判断考试时间内是否有重叠
                Date nextBeginTime = next.getBeginTime();
                Date nextEndTime = next.getEndTime();
                //这种方式在相同的时间是检测不出来的
//            if ((nextBeginTime.after(beginTime) && nextBeginTime.before(endTime)) ||
//                    (nextEndTime.after(beginTime) && nextEndTime.before(endTime))) return 2;
                long beginT = nextBeginTime.getTime();
                long endT = nextEndTime.getTime();
                if (!(bt>endT || et<beginT)) return 2;
            }
            boolean result = exam.getStudents().add(student);
            if (result){
                //别忘记！！！报名人数加一
                exam.setNums(exam.getNums()+1);
                examDao.save(exam);
                return 3;
            }else return -1;

        }

    }

    @Override
    public synchronized Integer cancelOldRelation(String userName, String examName) {
        //退选需要注意！如果考试已经不是open状态，不能退选.
        Exam exam = examDao.findFirstByName(examName);
        if (!exam.getStatus().equals("open")) return -1;
        Set<Student> students = exam.getStudents();
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {//遍历选了这场考试的学生
            Student next = iterator.next();
            if (next.getUserName().equals(userName)){
                    System.out.println("找到了同名的对象了");
                students.remove(next);
                exam.setStudents(students);
                exam = examDao.save(exam);
                    System.out.println("删除了关系");
                //别忘记！！！报名人数减一
                exam.setNums(exam.getNums() - 1);
                examDao.save(exam);
                break;
            }
        }
        System.out.println("退选成功!");
        return 1;
    }

    @Override
    public String loadExamRooms(String examName) {
        Exam exam = examDao.findFirstByName(examName);
        if (!exam.getStatus().equals("show")) return "";
        else {
            String result="";
            Set<Room> roomSet = exam.getRoomSet();
            Iterator<Room> iterator = roomSet.iterator();
            while(iterator.hasNext()){
                Room next = iterator.next();
                String place = next.getPlace();
                if (result=="") result+=place;
                else result+= ", "+place;
            }
            return result;
        }
    }

}

