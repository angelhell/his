package entity.patient;

import entity.user.doctor.Oncologist;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by celenmeh on 16.11.2018
 * 00:43
 */
@Entity
public class PatientFolder implements Serializable {
    private static final long serialVersionUID = -16978959920279647L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Oncologist specialistOncologist;
    private String firstVisitDate;
    @OneToOne
    private Patient patient;
    private String patientAnamnesis;
    @Lob
    private ArrayList<String> outsideTestsByCatalogueNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Oncologist getSpecialistOncologist() {
        return specialistOncologist;
    }

    public void setSpecialistOncologist(Oncologist specialist_oncologist) {
        this.specialistOncologist = specialist_oncologist;
    }

    public String getFirstVisitDate() {
        return firstVisitDate;
    }

    public void setFirstVisitDate(String firstVisitDate) {
        this.firstVisitDate = firstVisitDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getPatientAnamnesis() {
        return patientAnamnesis;
    }

    public void setPatientAnamnesis(String patientAnamnesis) {
        this.patientAnamnesis = patientAnamnesis;
    }

    public ArrayList<String> getOutsideTestsByCatalogueNumber() {
        return outsideTestsByCatalogueNumber;
    }

    public void setOutsideTestsByCatalogueNumber(ArrayList<String> outsideTestsByCatalogueNumber) {
        this.outsideTestsByCatalogueNumber = outsideTestsByCatalogueNumber;
    }
}
