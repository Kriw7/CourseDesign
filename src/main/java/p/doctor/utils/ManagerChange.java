package p.doctor.utils;

import org.springframework.beans.BeanUtils;
import p.doctor.dto.ManagerDto;
import p.doctor.entity.Manager;

import java.util.ArrayList;
import java.util.List;

public class ManagerChange {
    public static ManagerDto changeToDto(Manager manager){
        ManagerDto managerDto = new ManagerDto();
        BeanUtils.copyProperties(manager, managerDto);
        return managerDto;
    }
    public static List<ManagerDto> changeToDto(List<Manager> managers){
        List<ManagerDto> managerDtos = new ArrayList<>();
        for (Manager manager:managers){
            ManagerDto managerDto = new ManagerDto();
            BeanUtils.copyProperties(manager, managerDto);
            managerDtos.add(managerDto);
        }
        return managerDtos;
    }
}
