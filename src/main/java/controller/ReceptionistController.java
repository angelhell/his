package controller;

import dao.impl.PatientDaoImpl;
import dao.impl.PatientFolderDaoImpl;
import dao.impl.UserDaoImpl;
import entity.Insurance.NationalInsurance;
import entity.Insurance.PrivateInsurance;
import entity.patient.Patient;
import entity.patient.PatientFolder;
import entity.user.USER_ROLE;
import entity.user.User;

import java.util.ArrayList;

/**
 * Created by celenmeh on 16.11.2018
 * 05:02
 */
//TODO:oncologist assignment is not impleemnted yet
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

        if (!patientInsuranceCode.equals("") && !patientInsuranceCompanyName.equals("")) {
            PrivateInsurance privateInsurance = new PrivateInsurance();
            privateInsurance.setInsuranceCode(patientInsuranceCode);
            privateInsurance.setCompanyName(patientInsuranceCompanyName);
            patient.setInsurance(privateInsurance);
            privateInsurance.setPatient(patient);
        } else {
            NationalInsurance nationalInsurance = new NationalInsurance();
            nationalInsurance.setInsuranceCode(patientIdCode, patientSurname);
            patient.setInsurance(nationalInsurance);
            nationalInsurance.setPatient(patient);
        }
        boolean patientCreated = patientDao.save(patient);

        /*Oncologist dummyOncologist = new Oncologist();
        dummyOncologist.setName("Dummy Onco");
        dummyOncologist.setUserRole(USER_ROLE.ROLE_DOCTOR);
        dummyOncologist.setLevelOfCareer(LevelOfCareer.LEVEL_OF_CAREER_SPECIALIST);
        userDao.save(dummyOncologist);*/


        PatientFolder patientFolder = new PatientFolder();
        patientFolder.setFirstVisitDate(patientFirstVisitDate);
        patient.setPatientFolder(patientFolder);
        patientFolder.setPatient(patient);
        boolean patientFolderCreated = patientFolderDao.save(patientFolder);
        boolean patientBindedToFolder = patientDao.save(patient);

        return patientFolderCreated && patientCreated && patientBindedToFolder;
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
