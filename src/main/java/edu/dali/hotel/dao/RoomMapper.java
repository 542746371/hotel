package edu.dali.hotel.dao;

import edu.dali.hotel.model.Room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author z360-y
 * @create 2022-12-14  8:00
 */

@Mapper
public interface RoomMapper {
    /**
     *查询所有房间
     * @return
     */
    public List<Room> getAllRoom();

    public Room getRoomById(int id);


    /**
     * 通过room数据修改对应的房间
     * @param room
     * @return
     */
    public int updateRoom(Room room);

    /**
     * 通过id删除对应的房间
     * @param id
     * @return
     */
    public int deleteRoomById(int id);

    /**
     * 添加房间
     * @param room
     * @return
     */
    public int addRoom(Room room);

}
