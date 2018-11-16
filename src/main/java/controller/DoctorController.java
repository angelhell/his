package controller;

import dao.impl.MedicineDaoImpl;
import entity.medicine.Medicine;

import java.util.ArrayList;

/**
 * Created by celenmeh on 16.11.2018
 * 05:29
 */
public class DoctorController {
    private MedicineDaoImpl medicineDao = new MedicineDaoImpl();

    public boolean addMedicineToCatalogue(String medicineName,
                                          String medicinePharmCompany) {

        Medicine medicine = new Medicine();
        medicine.setName(medicineName);
        medicine.setPharmCompany(medicinePharmCompany);
        return medicineDao.save(medicine);
    }

    public ArrayList<Medicine> listMedicines() {
        return medicineDao.listMedicines();
    }
}
