package pl.med.clinic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.med.clinic.dto.PatientDtoResponse;
import pl.med.clinic.service.PatientService;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/{id}")
    public PatientDtoResponse get(@PathVariable Long id) {
        return patientService.get(id);
    }
}
