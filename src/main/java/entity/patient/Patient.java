package entity.patient;

import entity.Insurance.Insurance;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by celenmeh on 15.11.2018
 * 21:33
 */
@Entity
public class Patient implements Serializable {
    private static final long serialVersionUID = -778781869046699160L;
    @Id
    private String idCode;
    private String name;
    private String surname;
    private String birthDate;
    @OneToOne
    private Insurance insurance;
    @OneToOne
    private PatientFolder patientFolder;

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public PatientFolder getPatientFolder() {
        return patientFolder;
    }

    public void setPatientFolder(PatientFolder patientFolder) {
        this.patientFolder = patientFolder;
    }
}
