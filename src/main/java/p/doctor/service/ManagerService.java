package p.doctor.service;

import org.springframework.beans.factory.annotation.Autowired;
import p.doctor.dao.ManagerDao;
import p.doctor.entity.Manager;

public interface ManagerService {
    Manager findManagerByUserName(String userName);
}
