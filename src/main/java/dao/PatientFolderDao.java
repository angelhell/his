package dao;

import entity.patient.PatientFolder;

import java.util.ArrayList;

/**
 * Created by celenmeh on 16.11.2018
 * 01:25
 */
public interface PatientFolderDao {

    boolean save(PatientFolder patientFolder);

    boolean delete(Long patientFolderId);

    ArrayList<PatientFolder> findPatientFoldersByOncologist(Long oncologistId);



}
