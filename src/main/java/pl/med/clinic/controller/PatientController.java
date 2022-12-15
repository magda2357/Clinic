package pl.med.clinic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.med.clinic.dto.PatientDtoRequest;
import pl.med.clinic.dto.PatientDtoResponse;
import pl.med.clinic.entity.PatientEntity;
import pl.med.clinic.service.PatientService;

import java.util.List;

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
    public void add(@RequestBody PatientDtoRequest newPatient) {
        patientService.savePatient(newPatient);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody PatientEntity updatedPatient) {
        patientService.updatePatient(id, updatedPatient);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        patientService.deletePatientById(id);
    }
}
