package com.utcn.bussinessLogicLayer;

import com.utcn.repositoryLayer.User;

public interface IUserBLL {
    User login(String username, String password);
}
