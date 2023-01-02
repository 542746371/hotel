package edu.dali.hotel.service;

/**
 * @author z360-y
 * @create 2022-11-08  12:16
 */


import edu.dali.hotel.model.User;
import jakarta.servlet.http.HttpServlet;

import java.sql.SQLException;


public interface UserService {

//    public void userInsert(String name, String password, String sex, String where, String id, String type);
    /**
     * 传递user数据，完成数据添加user数据的操作
     * @param user
     */
    public void userInsert(User user );

    /**
     * 根据id和password完成查询操作
     * @param id
     * @param password
     * @return
     */
    public User selectUserByid(String id, String password) ;     //是否是用户


}

