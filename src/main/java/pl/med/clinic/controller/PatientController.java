package pl.med.clinic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.med.clinic.dto.PatientDtoRequest;
import pl.med.clinic.dto.PatientDtoResponse;
import pl.med.clinic.service.PatientService;

import javax.validation.Valid;

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
    public ResponseEntity<SimplePageForPagingAndSorting<PatientDtoResponse>> getAllPaged(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return ResponseEntity.ok(patientService.getAllPaged(pageNo, pageSize, sortBy));
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
