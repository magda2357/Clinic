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

    public PatientEntity(String firstName, String lastName, String pesel, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.gender = gender;
    }
}
