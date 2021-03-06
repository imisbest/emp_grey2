package com.csw.dao;

import com.csw.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    User queryByUsernameAndPassword(@Param("username") String username,
                                    @Param("password") String password);

    void addUser(@Param("user") User user);

    User queryBy(@Param("username") String username);

}
