package pl.med.clinic.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "visit")
@NoArgsConstructor
@Getter
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private LocalDateTime visitDateTime;

    @Enumerated(STRING)
    private Paid paid;
    private String description;

    @Enumerated(STRING)
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;

    public VisitEntity(LocalDateTime visitDateTime,
                       Paid paid,
                       String description,
                       Payment payment) {
        this.visitDateTime = visitDateTime;
        this.paid = paid;
        this.description = description;
        this.payment = payment;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

}
