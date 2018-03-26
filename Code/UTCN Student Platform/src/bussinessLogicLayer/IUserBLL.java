package bussinessLogicLayer;

import repositoryLayer.User;

public interface IUserBLL {
    User login(String username, String password);
}
