package dao.impl;

import dao.UserDao;
import entity.user.User;
import entity.user.doctor.Oncologist;
import entity.user.doctor.Surgeon;
import jdk.nashorn.internal.runtime.ECMAException;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.ArrayList;

/**
 * Created by celenmeh on 16.11.2018
 * 00:25
 */
@SuppressWarnings("Duplicates")
public class UserDaoImpl implements UserDao {
    public boolean save(User user) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(user);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (ECMAException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Surgeon> listSurgeons() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            ArrayList<Surgeon> surgeons = (ArrayList<Surgeon>) session.createQuery("select s from Surgeon s").list();
            session.getTransaction().commit();
            session.close();
            return surgeons;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Oncologist> listOncologists() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            ArrayList<Oncologist> oncologists = (ArrayList<Oncologist>) session.createQuery("select o from Oncologist o").list();
            session.getTransaction().commit();
            session.close();
            return oncologists;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public User findByUsername(String username) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            User user = (User) session.createQuery("select u from User u where u.username= :username")
                    .setParameter("username", username).uniqueResult();
            session.getTransaction().commit();
            session.close();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
