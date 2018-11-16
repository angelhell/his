package controller;

import dao.impl.PatientFolderDaoImpl;
import dao.impl.UserDaoImpl;
import entity.user.USER_ROLE;
import entity.user.User;
import entity.user.doctor.*;

import java.util.ArrayList;

/**
 * Created by celenmeh on 16.11.2018
 * 02:47
 */
public class AdminController implements LoginController {
    private static UserDaoImpl userDao = new UserDaoImpl();
    private PatientFolderDaoImpl patientFolderDao = new PatientFolderDaoImpl();

    public boolean addNewSurgeon(String username,
                                 String password,
                                 String name,
                                 String surname,
                                 String profId,
                                 SurgeonType surgeonType) {

        Surgeon surgeon = new Surgeon();
        surgeon.setUsername(username);
        surgeon.setPassword(password);
        surgeon.setName(name);
        surgeon.setUserRole(USER_ROLE.ROLE_DOCTOR);
        surgeon.setSurname(surname);
        surgeon.setProfId(profId);
        surgeon.setSurgeonType(surgeonType);

        return userDao.save(surgeon);
    }

    public static boolean addNewOncologist(String username,
                                           String password,
                                           String name,
                                           String surname,
                                           String profId,
                                           OncologistType oncologistType,
                                           LevelOfCareer levelOfCareer) {

        Oncologist oncologist = new Oncologist();
        oncologist.setUsername(username);
        oncologist.setPassword(password);
        oncologist.setName(name);
        oncologist.setSurname(surname);
        oncologist.setProfId(profId);
        oncologist.setOncologistType(oncologistType);
        oncologist.setLevelOfCareer(levelOfCareer);
        oncologist.setUserRole(USER_ROLE.ROLE_DOCTOR);

        return userDao.save(oncologist);
    }

    public ArrayList<Surgeon> listSurgeons() {
        return userDao.listSurgeons();
    }

    public ArrayList<Oncologist> listOncologists() {
        return userDao.listOncologists();
    }

    //TODO: therapy clinical test patient all need to be deleted from DB
    public boolean deletePatientFolder(Long patientFolderId) {
        return patientFolderDao.delete(patientFolderId);
    }


    public boolean login(String username, String password) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            return false;
        } else if (!user.getPassword().equals(password)) {
            return false;
        } else if (!user.getUserRole().equals(USER_ROLE.ROLE_ADMIN)) {
            return false;
        } else {
            return true;
        }
    }
}
