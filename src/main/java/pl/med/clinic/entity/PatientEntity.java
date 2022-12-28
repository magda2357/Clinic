package pl.med.clinic.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.EnumType.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "patient")
@NoArgsConstructor
@Getter
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String pesel;

    @Enumerated(STRING)
    private Gender gender;
    private LocalDate dateOfBirth;

    public PatientEntity(String firstName, String lastName, String pesel, Gender gender, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }
}
