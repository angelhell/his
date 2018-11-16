package dao;

import entity.patient.PatientFolder;

/**
 * Created by celenmeh on 16.11.2018
 * 01:25
 */
public interface PatientFolderDao {

    boolean save(PatientFolder patientFolder);
    boolean delete(PatientFolder patientFolder);

}
