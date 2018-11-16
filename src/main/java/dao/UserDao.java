package dao;

import entity.user.User;
import entity.user.doctor.Oncologist;
import entity.user.doctor.Surgeon;

import java.util.ArrayList;

/**
 * Created by celenmeh on 16.11.2018
 * 00:23
 */
public interface UserDao {

    boolean save(Class<?> user);
    ArrayList<Surgeon> listSurgeons();
    ArrayList<Oncologist> listOncologists();
}
