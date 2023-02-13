package pl.med.clinic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.med.clinic.dto.ProcedureDtoResponse;
import pl.med.clinic.service.ProcedureService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/procedure")
public class ProcedureController {

    public final ProcedureService procedureService;

    @GetMapping
    public List<ProcedureDtoResponse> search(String q) {
        return procedureService.search(q);
    }

}


