package pl.med.clinic.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "visit")
@NoArgsConstructor
@Getter
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private LocalDate visitDate;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;

    public VisitEntity(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

}
