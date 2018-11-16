package dao.impl;

import dao.PatientFolderDao;
import entity.patient.PatientFolder;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 * Created by celenmeh on 16.11.2018
 * 01:35
 */
public class PatientFolderDaoImpl implements PatientFolderDao {
    public boolean save(PatientFolder patientFolder) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(patientFolder);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public boolean delete(PatientFolder patientFolder) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(patientFolder);
        session.getTransaction().commit();
        session.close();
        return true;
    }
}
