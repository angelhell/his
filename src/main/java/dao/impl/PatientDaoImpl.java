package dao.impl;

import dao.PatientDao;
import entity.patient.Patient;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.ArrayList;

/**
 * Created by celenmeh on 15.11.2018
 * 22:57
 */
public class PatientDaoImpl implements PatientDao {
    public boolean save(Patient patient) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(patient.getInsurance());
        session.saveOrUpdate(patient);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public ArrayList<Patient> listPatients() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ArrayList<Patient> patientList = (ArrayList<Patient>) session.createQuery("select p from Patient p").list();
        session.getTransaction().commit();
        session.close();
        return patientList;
    }
}
