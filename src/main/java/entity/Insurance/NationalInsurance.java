package entity.Insurance;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by celenmeh on 15.11.2018
 * 22:00
 */
@Entity
public class NationalInsurance extends Insurance {

    @Id
    private String insuranceCode;


    @Override
    public String getInsuranceCode() {
        return insuranceCode;
    }


    public void setInsuranceCode(String patientID, String patientSurname) {
        this.insuranceCode = patientSurname + patientID;
    }
}
