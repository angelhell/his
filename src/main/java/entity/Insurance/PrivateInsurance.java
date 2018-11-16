package entity.Insurance;

import javax.persistence.Entity;

/**
 * Created by celenmeh on 15.11.2018
 * 22:00
 */
@Entity
public class PrivateInsurance extends Insurance {
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
