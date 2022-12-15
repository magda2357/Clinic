package pl.med.clinic.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.med.clinic.dto.PatientDtoRequest;

import javax.persistence.*;

@Entity
@Table(name = "patient")
@NoArgsConstructor
@Getter
@Setter
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String pesel;
    private String gender;

    public PatientEntity(PatientDtoRequest patient) {
        this.firstName = patient.getFirstName();
        this.lastName = patient.getLastName();
        this.pesel = patient.getPesel();
        this.gender = patient.getGender();
    }
}
