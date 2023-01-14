package pl.med.clinic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.med.clinic.dto.PatientDtoRequest;
import pl.med.clinic.dto.PatientDtoResponse;
import pl.med.clinic.service.PatientService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.ACCEPTED;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/{id}")
    public PatientDtoResponse get(@PathVariable Long id) {
        return patientService.get(id);
    }

    @GetMapping
    public List<PatientDtoResponse> getAll() {
        return patientService.getAll();
    }

    @PostMapping
    public PatientDtoResponse add(@Valid @RequestBody PatientDtoRequest newPatient) {
        return patientService.savePatient(newPatient);
    }

    @PutMapping("/{id}")
    public PatientDtoResponse update(@PathVariable Long id, @RequestBody PatientDtoRequest updatedPatient) {
        return patientService.updatePatient(id, updatedPatient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = ACCEPTED, reason = "Patient has been deleted")
    public void delete(@PathVariable Long id) {
        patientService.deletePatientById(id);
    }

}
