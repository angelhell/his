package controller;

import dao.PatientDao;
import dao.impl.MedicineDaoImpl;
import dao.impl.PatientDaoImpl;
import dao.impl.PatientFolderDaoImpl;
import dao.impl.UserDaoImpl;
import entity.medicine.Medicine;
import entity.patient.Patient;
import entity.patient.PatientFolder;
import entity.user.USER_ROLE;
import entity.user.User;

import java.util.ArrayList;

/**
 * Created by celenmeh on 16.11.2018
 * 05:29
 */
public class DoctorController implements LoginController {
    private static MedicineDaoImpl medicineDao = new MedicineDaoImpl();
    private static UserDaoImpl userDao = new UserDaoImpl();
    private static PatientFolderDaoImpl patientFolderDao = new PatientFolderDaoImpl();
    private static PatientDaoImpl patientDao = new PatientDaoImpl();

    public static boolean addMedicineToCatalogue(String medicineName,
                                                 String medicinePharmCompany) {

        Medicine medicine = new Medicine();
        medicine.setName(medicineName);
        medicine.setPharmCompany(medicinePharmCompany);
        return medicineDao.save(medicine);
    }

    public static ArrayList<Medicine> listMedicines() {
        return medicineDao.listMedicines();
    }

    public ArrayList<PatientFolder> listPatientFoldersByOncologist(String loggedDoctorUsername) {
        Long doctorId = userDao.findByUsername(loggedDoctorUsername).getId();
        return patientFolderDao.findPatientFoldersByOncologist(doctorId);
    }

    public boolean addTestsAndAnamnesisToPatientFolder(String patientId, String anamnesisInformation,
                                                       ArrayList<String> outsideTests) {
        Patient patient = patientDao.getPatient(patientId);
        patient.getPatientFolder().setPatientAnamnesis(anamnesisInformation);
        patient.getPatientFolder().setOutsideTestsByCatalogueNumber(outsideTests);
        boolean savedPatientFolder = patientFolderDao.save(patient.getPatientFolder());
        boolean savedPatient = patientDao.save(patient);

        return savedPatientFolder && savedPatient;
    }

    public boolean login(String username, String password) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            return false;
        } else if (!user.getPassword().equals(password)) {
            return false;
        } else if (!user.getUserRole().equals(USER_ROLE.ROLE_DOCTOR)) {
            return false;
        } else {
            return true;
        }
    }
}
