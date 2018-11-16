package patient_folder_tests;

import entity.patient.Patient;
import entity.patient.PatientFolder;
import entity.user.doctor.LevelOfCareer;
import entity.user.doctor.Oncologist;
import entity.user.doctor.OncologistType;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

import static org.junit.Assert.assertEquals;

/**
 * Created by celenmeh on 16.11.2018
 * 01:38
 */
public class PatientFolderPersistenceIntegrationTests {

    @Test
    public void checkPatientFolderPersisted_whenPersistPatientFolder() {
        Patient patient = new Patient();
        patient.setIdCode("123");
        patient.setBirthDate("456/123/123");
        patient.setName("hello");
        patient.setSurname("systemsModelling");

        Oncologist oncologist = new Oncologist();
        oncologist.setName("oncologist");
        oncologist.setOncologistType(OncologistType.DOCTOR_TYPE_GYNECOLOGIC);
        oncologist.setLevelOfCareer(LevelOfCareer.LEVEL_OF_CAREER_SPECIALIST);

        PatientFolder patientFolder = new PatientFolder();
        patientFolder.setFirstVisitDate("13/2/2225");
        patientFolder.setPatient(patient);
        patientFolder.setSpecialistOncologist(oncologist);
        patient.setPatientFolder(patientFolder);


        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(patient);
        session.saveOrUpdate(oncologist);
        session.saveOrUpdate(patientFolder);
        session.getTransaction().commit();
        PatientFolder returnedPatientFolder = session.get(PatientFolder.class, patientFolder.getId());
        session.close();
        assertEquals(patientFolder.getId(), returnedPatientFolder.getId());
    }


}
