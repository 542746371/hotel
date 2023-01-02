package edu.dali.hotel.service;


public interface  OrderService {

    public void orderInsert(int id, String name, String bTime, String aTime, String phone, String oldPhone, String email);
    public int MaxOrderId();
    public void orderRoomInsert(int id, String roomid, String nums);

}