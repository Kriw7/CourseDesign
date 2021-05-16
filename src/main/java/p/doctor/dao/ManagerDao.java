package p.doctor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import p.doctor.entity.Manager;

public interface ManagerDao extends JpaRepository<Manager,Integer>, JpaSpecificationExecutor<Manager> {
    Manager findFirstByUserName(String userName);
}
