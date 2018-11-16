package entity.Insurance;

import entity.patient.Patient;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by celenmeh on 15.11.2018
 * 21:41
 */
@Entity
public class Insurance {

    @Id
    private String insuranceCode;
    @OneToOne
    Patient patient;

    public String getInsuranceCode() {
        return insuranceCode;
    }

    public void setInsuranceCode(String insuranceCode) {
        this.insuranceCode = insuranceCode;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
