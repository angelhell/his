package dao.impl;

import dao.PatientFolderDao;
import entity.patient.PatientFolder;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 * Created by celenmeh on 16.11.2018
 * 01:35
 */
@SuppressWarnings("Duplicates")
public class PatientFolderDaoImpl implements PatientFolderDao {
    public boolean save(PatientFolder patientFolder) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(patientFolder);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Long id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            PatientFolder patientFolder = session.get(PatientFolder.class, id);
            session.delete(patientFolder);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
