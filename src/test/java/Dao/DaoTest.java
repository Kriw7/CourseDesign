package Dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import p.doctor.dao.ExamDao;
import p.doctor.dao.ManagerDao;
import p.doctor.dao.RoomDao;
import p.doctor.dao.StudentDao;
import p.doctor.entity.Exam;
import p.doctor.entity.Manager;
import p.doctor.entity.Room;
import p.doctor.entity.Student;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:conf/applicationContext.xml"})
@WebAppConfiguration
public class DaoTest {
    @Autowired
    StudentDao studentDao;
    @Autowired
    ExamDao examDao;
    @Autowired
    RoomDao roomDao;
    @Autowired
    ManagerDao managerDao;

    @Test
    public void roomTest() {
        List<Room> all = roomDao.findAll();
        for (Room r:all) System.out.println(r);
    }

    @Test
    public void StudentTest() {
        List<Student> all = studentDao.findAll();
        for (Student s:all) System.out.println(s);
    }

    @Test
    public void ExamTest() {
        List<Exam> all = examDao.findAll();
        for (Exam e:all) System.out.println(e);
    }

    @Test
    public void ManagerTest() {
        List<Manager> all = managerDao.findAll();
        for (Manager m:all) System.out.println(m);
    }

    @Test
    public void ManagerDao() {
        Manager kriw = managerDao.findFirstByUserName("kriw");
        System.out.println(kriw);
    }

    @Test
    public void RoomTest() {
        Pageable pageable = new PageRequest(0,5);
        Page<Room> page = roomDao.findAll(pageable);
        List<Room> all = page.getContent();
        for (Room room:all) System.out.println(room);
    }
}
