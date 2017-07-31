package com.netease.course.dao;


import com.netease.course.meta.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    @Select("SELECT password from person where userName = #{userName}")
    String getUserPassword(String userName);


    @Select("SELECT id, userName, password, nickName, userType from person where userName = #{userName}")
    User getUserByUserName(String userName);

}
