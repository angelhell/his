package controller;

import dao.impl.UserDaoImpl;
import entity.user.USER_ROLE;
import entity.user.User;

/**
 * Created by celenmeh on 16.11.2018
 * 02:47
 */
public class UserController {
    private static UserDaoImpl userDao = new UserDaoImpl();

    public static boolean register(String username, String password, USER_ROLE userRole) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setUserRole(userRole);

        return userDao.save(user);
    }
}
