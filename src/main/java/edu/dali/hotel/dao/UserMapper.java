package edu.dali.hotel.dao;

import edu.dali.hotel.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author z360-y
 * @create 2022-12-20  9:36
 */
@Mapper
public interface UserMapper {


   // public void insertUser(String name, String password, String sex, String where, String id, String type);

    /**
     * 通过user数据在数据库中添加一个新的用户
     * @param user
     */
    public void insertUser(User user);

    /**
     * 通过id和password查找user
     * @param id
     * @param password
     * @return
     */
    public User getUserById(@Param("id") String id, @Param("password") String password);

}
