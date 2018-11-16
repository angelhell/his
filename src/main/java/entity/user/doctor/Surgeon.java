package entity.user.doctor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by celenmeh on 15.11.2018
 * 23:23
 */
@Entity
public class Surgeon extends Doctor {
    @Enumerated(EnumType.STRING)
    private SurgeonType surgeonType;


    public SurgeonType getSurgeonType() {
        return surgeonType;
    }

    public void setSurgeonType(SurgeonType surgeonType) {
        this.surgeonType = surgeonType;
    }
}
