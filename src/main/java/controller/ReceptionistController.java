package controller;

import dao.PatientFolderDao;
import dao.impl.PatientDaoImpl;
import dao.impl.PatientFolderDaoImpl;
import entity.patient.Patient;
import entity.patient.PatientFolder;

import java.util.ArrayList;

/**
 * Created by celenmeh on 16.11.2018
 * 05:02
 */
//TODO: insurance is not implemented yet. && oncologist assignment is not impleemnted yet
public class ReceptionistController {
    private PatientDaoImpl patientDao = new PatientDaoImpl();
    private PatientFolderDaoImpl patientFolderDao = new PatientFolderDaoImpl();

    public ArrayList<Patient> listPatients() {
        return patientDao.listPatients();
    }

    public boolean openNewPatientFolder(String patientIdCode,
                                        String patientName,
                                        String patientSurname,
                                        String patientBirthDate,
                                        String patientInsuranceCode, //TODO: national or private?
                                        String patientInsuranceCompanyName,
                                        String patientFirstVisitDate) {

        Patient patient = new Patient();
        patient.setIdCode(patientIdCode);
        patient.setName(patientName);
        patient.setSurname(patientSurname);
        patient.setBirthDate(patientBirthDate);

        PatientFolder patientFolder = new PatientFolder();
        patientFolder.setFirstVisitDate(patientFirstVisitDate);

        patient.setPatientFolder(patientFolder);
        patientFolder.setPatient(patient);


        return patientFolderDao.save(patientFolder) && patientDao.save(patient);
    }
}
