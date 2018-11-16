package dao.impl;

import dao.MedicineDao;
import entity.medicine.Medicine;
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
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(medicine);
        session.getTransaction().commit();
        session.close();
        return true;
    }


    public boolean delete(Medicine medicine) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(medicine);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public ArrayList<Medicine> listMedicines() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ArrayList<Medicine> medicines = (ArrayList<Medicine>) session.createQuery("select m from Medicine m").list();
        session.getTransaction().commit();
        session.close();
        return medicines;
    }
}
