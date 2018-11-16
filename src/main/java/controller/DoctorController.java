package controller;

import dao.impl.MedicineDaoImpl;
import dao.impl.UserDaoImpl;
import entity.medicine.Medicine;
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
