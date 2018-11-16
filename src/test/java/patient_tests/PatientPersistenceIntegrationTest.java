package patient_tests;

import dao.PatientDao;
import dao.impl.PatientDaoImpl;
import entity.Insurance.NationalInsurance;
import entity.Insurance.PrivateInsurance;
import entity.patient.Patient;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by celenmeh on 15.11.2018
 * 22:10
 */

public class PatientPersistenceIntegrationTest {
    @Test
    public void returnPatient_whenPersistPatient() {
        Patient patient = new Patient();
        patient.setIdCode("123");
        patient.setBirthDate("456/123/123");
        patient.setName("hello");
        patient.setSurname("systemsModelling");
        PrivateInsurance privateInsurance = new PrivateInsurance();
        privateInsurance.setCompanyName("ERGO");
        privateInsurance.setInsuranceCode("4444");
        patient.setInsurance(privateInsurance);
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(privateInsurance);
        session.saveOrUpdate(patient);
        session.getTransaction().commit();
        Patient returnedPatient = session.get(Patient.class, patient.getIdCode());
        session.close();
        assertEquals(patient.getIdCode(), returnedPatient.getIdCode());
    }

    @Test
    public void nationalInsuranceIsGenerated_whenPersistPatientWithNationalInsurance() {
        Patient patient = new Patient();
        patient.setIdCode("234");
        patient.setBirthDate("456/123/123");
        patient.setName("mehmet");
        patient.setSurname("testest");
        NationalInsurance nationalInsurance = new NationalInsurance();
        nationalInsurance.setInsuranceCode("555");
        nationalInsurance.setInsuranceCode(patient.getIdCode(), patient.getSurname());
        patient.setInsurance(nationalInsurance);
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(nationalInsurance);
        session.saveOrUpdate(patient);
        session.getTransaction().commit();
        session.close();
        assertEquals(patient.getInsurance().getInsuranceCode(), "testest234");
    }

    @Test
    public void whenListPatients_thenReturnPatientArrayList() {
        PatientDao patientDao = new PatientDaoImpl();
        ArrayList<Patient> patientArrayList = patientDao.listPatients();
        assertNotNull(patientArrayList);
    }
}
