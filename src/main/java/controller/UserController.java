package controller;

import dao.impl.UserDaoImpl;
import entity.user.USER_ROLE;
import entity.user.User;

/**
 * Created by celenmeh on 16.11.2018
 * 02:47
 */
public class UserController {
    private UserDaoImpl userDao = new UserDaoImpl();

    public boolean register(String username, String password, USER_ROLE userRole) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setUserRole(userRole);

        return userDao.save(user);
    }

    public USER_ROLE login(String username, String password) {
        User user = userDao.findByUsername(username);
        if (user.getPassword().equals(password)) {
            return user.getUserRole();
        } else {
            return null;
        }
    }
}
