package entity.user.doctor;

import entity.user.User;

import javax.persistence.Entity;

/**
 * Created by celenmeh on 15.11.2018
 * 23:13
 */

@Entity
public  class Doctor extends User {

    private static final long serialVersionUID = 858736807681618010L;
    private String name;
    private String surname;
    private String profId;

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

    public String getProfId() {
        return profId;
    }

    public void setProfId(String profId) {
        this.profId = profId;
    }
}
