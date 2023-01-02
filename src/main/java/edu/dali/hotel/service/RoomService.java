package edu.dali.hotel.service;

/**
 * @author z360-y
 * @create 2022-10-23  10:23
 */


import edu.dali.hotel.controller.RoomController;
import edu.dali.hotel.model.Room;

import java.util.List;


public interface RoomService {




    /**
     * 获取所有房间
     * @return
     */
    public List<Room> getAllRoomList() ;


    //根据id查找
    public Room getRoomById(int id);

    /**
     * 通过room数据来完成修改操作
     * @param room
     * @return
     */
    public int updateRoom(Room room);

    /**
     * 通过id执行删除操作
     * @param id
     * @return
     */
    public int deleteRoomById(int id);

    public int addRoom(Room room);

}

