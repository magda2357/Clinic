package pl.med.clinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.med.clinic.entity.Paid;
import pl.med.clinic.entity.Payment;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class VisitDtoRequest {

    private LocalDateTime visitDateTime;
    private Paid paid;
    private String description;
    private Payment payment;
}
