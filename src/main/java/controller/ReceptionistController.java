package controller;

import dao.impl.PatientDaoImpl;
import dao.impl.PatientFolderDaoImpl;
import dao.impl.UserDaoImpl;
import entity.patient.Patient;
import entity.patient.PatientFolder;
import entity.user.USER_ROLE;
import entity.user.User;

import java.util.ArrayList;

/**
 * Created by celenmeh on 16.11.2018
 * 05:02
 */
//TODO: insurance is not implemented yet. && oncologist assignment is not impleemnted yet
public class ReceptionistController implements LoginController {
    private PatientDaoImpl patientDao = new PatientDaoImpl();
    private PatientFolderDaoImpl patientFolderDao = new PatientFolderDaoImpl();
    private static UserDaoImpl userDao = new UserDaoImpl();

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

    public boolean login(String username, String password) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            return false;
        } else if (!user.getPassword().equals(password)) {
            return false;
        } else if (!user.getUserRole().equals(USER_ROLE.ROLE_RECEPTIONIST)) {
            return false;
        } else {
            return true;
        }
    }
}
