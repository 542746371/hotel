package edu.dali.hotel.dao;

import org.apache.ibatis.annotations.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author z360-y
 * @create 2022-12-21  15:08
 */
@Mapper
public interface OrderMapper {

    public int MaxOrderId() ;
    public void orderInsert(int id,String name, String bTime, String aTime, String phone, String oldPhone, String email);
    public void orderRoomInsert(int id,String roomid,String nums);
}
