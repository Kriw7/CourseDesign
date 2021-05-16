package p.doctor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import p.doctor.dao.ManagerDao;
import p.doctor.entity.Manager;
import p.doctor.service.ManagerService;

import javax.transaction.Transactional;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerDao managerDao;

    @Override
    public Manager findManagerByUserName(String userName) {
        Manager manager = managerDao.findFirstByUserName(userName);
        return manager;
    }
}
