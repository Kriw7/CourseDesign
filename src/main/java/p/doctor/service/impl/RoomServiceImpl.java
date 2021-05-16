package p.doctor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import p.doctor.dao.ExamDao;
import p.doctor.dao.RoomDao;
import p.doctor.dto.RoomDto;
import p.doctor.entity.Exam;
import p.doctor.entity.Room;
import p.doctor.form.ArrangeRoomForm;
import p.doctor.service.RoomService;
import p.doctor.utils.RoomChange;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomDao roomDao;
    @Autowired
    ExamDao examDao;

    @Override
    public List<RoomDto> findAllByPage(Integer pageNo, Integer pageSize) {
        Pageable pageable = new PageRequest(pageNo-1,pageSize);
        Page<Room> page = roomDao.findAll(pageable);
        List<Room> rooms = page.getContent();
        List<RoomDto> roomDtos = RoomChange.ChangToDto(rooms);
        return roomDtos;
    }

    @Override
    public Integer findTotalPageNo(Integer pageSize) {
        List<Room> rooms = roomDao.findAll();
        if (!rooms.isEmpty()){
            Integer totalSize =  rooms.size();
            Integer add = 0;
            if (totalSize%pageSize!=0) add++;
            totalSize=totalSize/pageSize+add;
            return totalSize;
        }else return 0;
    }

    @Override
    public synchronized String arrangeRoomForExam(ArrangeRoomForm arrangeRoomForm) {
        String examName = arrangeRoomForm.getExamName();
        List<Integer> roomIds = arrangeRoomForm.getSelectRoomId();
        //更新room的信息
        try{
            Exam exam = examDao.findFirstByName(examName);
            for (Integer roomId:roomIds){
                Room room = roomDao.findFirstById(roomId);
                room.setExam(exam);
                room.setStatus("used");
                roomDao.save(room);
            }
            exam.setStatus("show");
            examDao.save(exam);
        }catch (Exception e){
            return "抱歉，系统开了一点小差，请重试。";
        }
        return "考场分配成功";
    }

    @Override
    public boolean addNewRoom(String roomPlace, Integer roomSize) {
        Room room = new Room();
        room.setPlace(roomPlace);
        room.setStatus("free");
        room.setSize(roomSize);
        room.setExam(null);
        roomDao.save(room);
        return true;
    }


}
