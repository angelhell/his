package dao;

import entity.medicine.Medicine;

import java.util.ArrayList;

/**
 * Created by celenmeh on 16.11.2018
 * 02:34
 */
public interface MedicineDao {

    boolean save(Medicine medicine);

    boolean delete(Medicine medicine);

    ArrayList<Medicine> listMedicines();
}
