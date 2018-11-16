package entity.medicine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by celenmeh on 16.11.2018
 * 02:27
 */
@Entity
public class Medicine implements Serializable {
    private static final long serialVersionUID = 6003380030684092806L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String pharmCompany;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPharmCompany() {
        return pharmCompany;
    }

    public void setPharmCompany(String pharmCompany) {
        this.pharmCompany = pharmCompany;
    }
}
