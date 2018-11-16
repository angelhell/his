package entity.user.doctor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by celenmeh on 15.11.2018
 * 23:23
 */
@Entity
public class Oncologist extends Doctor {

    @Enumerated(EnumType.STRING)
    private OncologistType oncologistType;
    @Enumerated(EnumType.STRING)
    private LevelOfCareer levelOfCareer;


    public OncologistType getOncologistType() {
        return oncologistType;
    }

    public void setOncologistType(OncologistType oncologistType) {
        this.oncologistType = oncologistType;
    }

    public LevelOfCareer getLevelOfCareer() {
        return levelOfCareer;
    }

    public void setLevelOfCareer(LevelOfCareer levelOfCareer) {
        this.levelOfCareer = levelOfCareer;
    }

}
