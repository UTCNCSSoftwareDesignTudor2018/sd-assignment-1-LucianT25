package bussinessLogicLayer.Impl;

import bussinessLogicLayer.IUserBLL;
import dataAccessLayer.UserDAO;
import repositoryLayer.User;

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
