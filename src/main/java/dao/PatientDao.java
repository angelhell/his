package dao;

import entity.patient.Patient;

import java.util.ArrayList;

/**
 * Created by celenmeh on 15.11.2018
 * 22:56
 */
public interface PatientDao {

    boolean save(Patient patient);

    ArrayList<Patient> listPatients();
}
