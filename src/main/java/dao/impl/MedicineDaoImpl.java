package dao.impl;

import dao.MedicineDao;
import entity.medicine.Medicine;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.ArrayList;

/**
 * Created by celenmeh on 16.11.2018
 * 02:34
 */
@SuppressWarnings("Duplicates")
public class MedicineDaoImpl implements MedicineDao {
    public boolean save(Medicine medicine) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(medicine);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean delete(Medicine medicine) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(medicine);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Medicine> listMedicines() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            ArrayList<Medicine> medicines = (ArrayList<Medicine>) session.createQuery("select m from Medicine m").list();
            session.getTransaction().commit();
            session.close();
            return medicines;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
