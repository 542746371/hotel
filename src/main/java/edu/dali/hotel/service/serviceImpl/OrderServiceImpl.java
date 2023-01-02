package edu.dali.hotel.service.serviceImpl;

import edu.dali.hotel.dao.OrderMapper;
import edu.dali.hotel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author z360-y
 * @create 2022-12-21  15:10
 */
@Service
public class OrderServiceImpl  implements OrderService {

    @Autowired
    OrderMapper orderMapper ;

    @Override
    public void orderInsert(int id, String name, String bTime, String aTime, String phone, String oldPhone, String email) {
        orderMapper.orderInsert(id, name, bTime, aTime, phone, oldPhone, email);
    }

    @Override
    public int MaxOrderId() {
        return orderMapper.MaxOrderId();
    }

    @Override
    public void orderRoomInsert(int id, String roomid, String nums) {
        orderMapper.orderRoomInsert(id, roomid, nums);
    }

}
