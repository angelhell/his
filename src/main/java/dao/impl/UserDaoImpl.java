package dao.impl;

import dao.UserDao;
import entity.user.doctor.Oncologist;
import entity.user.doctor.Surgeon;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.ArrayList;

/**
 * Created by celenmeh on 16.11.2018
 * 00:25
 */
public class UserDaoImpl implements UserDao {
    public boolean save(Class<?> user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public ArrayList<Surgeon> listSurgeons() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ArrayList<Surgeon> surgeons = (ArrayList<Surgeon>) session.createQuery("select s from Surgeon s").list();
        session.getTransaction().commit();
        session.close();
        return surgeons;
    }

    public ArrayList<Oncologist> listOncologists() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ArrayList<Oncologist> oncologists = (ArrayList<Oncologist>) session.createQuery("select o from Oncologist o").list();
        session.getTransaction().commit();
        session.close();
        return oncologists;
    }
}
