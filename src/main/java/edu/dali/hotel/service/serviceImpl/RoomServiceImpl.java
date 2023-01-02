package edu.dali.hotel.service.serviceImpl;

import edu.dali.hotel.dao.RoomMapper;
import edu.dali.hotel.model.Room;
import edu.dali.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author z360-y
 * @create 2022-12-14  8:36
 */
@Service
public class RoomServiceImpl implements RoomService {

    //使用注解
    @Autowired
    RoomMapper roomMapper;


    @Override
    public List<Room> getAllRoomList() {
        return roomMapper.getAllRoom();
    }

//    @Autowired
    @Override
    public Room getRoomById(int id) {
        return roomMapper.getRoomById(id);
    }

    @Override
    public int updateRoom(Room room) {
         return roomMapper.updateRoom(room);
    }

    @Override
    public int deleteRoomById(int id) {
        return roomMapper.deleteRoomById(id);
    }

    @Override
    public int addRoom(Room room) {
        return  roomMapper.addRoom(room);
    }


}
