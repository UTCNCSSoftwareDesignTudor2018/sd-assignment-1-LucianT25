package com.utcn.bussinessLogicLayer.Impl;

import com.utcn.bussinessLogicLayer.IUserBLL;
import com.utcn.dataAccessLayer.UserDAO;
import com.utcn.repositoryLayer.User;

public class UserBLL implements IUserBLL {

    @Override
    public User login(String username, String password) {
        User currentUser = UserDAO.getUser(username);
        if(password != null && currentUser != null && password.equals(currentUser.getPassword())) {
            return currentUser;
        }
        return null;
    }
}
