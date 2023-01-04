package pl.med.clinic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.med.clinic.dto.VisitsDtoResponse;
import pl.med.clinic.service.VisitService;

@RestController
@RequestMapping("/visit")
@RequiredArgsConstructor
public class VisitController {

    private final VisitService visitService;

    @GetMapping("/{patientId}")
    public VisitsDtoResponse get(@PathVariable Long patientId) {
        return visitService.get(patientId);
    }


}
