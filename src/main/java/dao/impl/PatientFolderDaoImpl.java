package dao.impl;

import dao.PatientFolderDao;
import entity.patient.PatientFolder;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.ArrayList;

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

    public ArrayList<PatientFolder> findPatientFoldersByOncologist(Long oncologistId) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            ArrayList<PatientFolder> patientFolders = (ArrayList<PatientFolder>) session.createQuery("select p from PatientFolder p where p.specialistOncologist.id= :oncologistId")
                    .setParameter("oncologistId", oncologistId).list();
            session.getTransaction().commit();
            session.close();
            return patientFolders;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
