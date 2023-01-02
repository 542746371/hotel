package edu.dali.hotel.service.serviceImpl;

import edu.dali.hotel.dao.UserMapper;
import edu.dali.hotel.model.User;
import edu.dali.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author z360-y
 * @create 2022-12-20  9:42
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public void userInsert(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public User selectUserByid(String id, String password) {
        return userMapper.getUserById(id,password);
    }
}
