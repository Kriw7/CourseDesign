package p.doctor.utils;

import org.springframework.beans.BeanUtils;
import p.doctor.dto.RoomDto;
import p.doctor.entity.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomChange {
    public static RoomDto ChangToDto(Room room){
        RoomDto roomDto =new RoomDto();
        BeanUtils.copyProperties(room,roomDto);
        return roomDto;
    }
    public static List<RoomDto> ChangToDto(List<Room> rooms){
        List<RoomDto> roomDtos = new ArrayList<>();
        for (Room room:rooms){
            RoomDto roomDto = new RoomDto();
            BeanUtils.copyProperties(room,roomDto);
            roomDtos.add(roomDto);
        }
        return roomDtos;
    }
}
