package p.doctor.service;

import p.doctor.dto.RoomDto;
import p.doctor.form.ArrangeRoomForm;

import java.util.List;

public interface RoomService {
    List<RoomDto> findAllByPage(Integer pageNo,Integer pageSize);
    Integer findTotalPageNo(Integer pageSize);
    String arrangeRoomForExam(ArrangeRoomForm arrangeRoomForm);
    boolean addNewRoom(String roomPlace,Integer roomSize);
}
