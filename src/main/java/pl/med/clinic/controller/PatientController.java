package pl.med.clinic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.med.clinic.dto.PatientDtoResponse;
import pl.med.clinic.entity.PatientEntity;
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

//    @GetMapping("/")
//    public List<PatientEntity> getAll() {
//        return patientService.getAll();
//    }

    @PostMapping("")
    public int add(@RequestBody PatientEntity newPatient){
        patientService.saveToDatabase(newPatient);
        return 1;
    }
}
