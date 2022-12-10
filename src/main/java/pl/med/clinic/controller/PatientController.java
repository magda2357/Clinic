package pl.med.clinic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/")
    public List<PatientDtoResponse> getAll() {
        return patientService.getAll();
    }

    @PostMapping("/")
    public int addAll(@RequestBody List<PatientEntity> newPatients) {
        patientService.savePatients(newPatients);
        return 1;
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") Long id, @RequestBody PatientEntity updatedPatient) {
        patientService.updatePatient(id, updatedPatient);
        return 1;
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") Long id) {
        patientService.deletePatientById(id);
        return 1;
    }
}
