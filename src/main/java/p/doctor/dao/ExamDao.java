package p.doctor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import p.doctor.entity.Exam;

import java.util.List;

public interface ExamDao extends JpaRepository<Exam,Integer>, JpaSpecificationExecutor<Exam> {
    Exam findFirstByName(String name);
    Exam findFirstById(Integer id);
}
