package com.netease.course.service;


import com.netease.course.dao.UserDao;
import com.netease.course.meta.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserDao userDao;

    @Autowired
    public void setUserDAO(UserDao userDAO) {
        this.userDao = userDAO;
    }

    public Boolean isLogin(User user) {
        String password = userDao.getUserPassword(user.getUserName());

        if (password != null && password.equals(user.getPassword())) {
            return true;
        }
        return false;
    }

    public User getUserByName(String userName) {
        return userDao.getUserByUserName(userName);
    }
}
