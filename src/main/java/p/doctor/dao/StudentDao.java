package p.doctor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import p.doctor.entity.Student;

import java.util.List;

public interface StudentDao extends JpaRepository<Student,Integer>, JpaSpecificationExecutor<Student> {
    Student findFirstByUserName(String userName);

}
