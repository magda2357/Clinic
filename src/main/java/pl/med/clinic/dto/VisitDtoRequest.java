package pl.med.clinic.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.med.clinic.entity.Paid;
import pl.med.clinic.entity.Payment;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@AllArgsConstructor
public class VisitDtoRequest {

    private Date visitDateTime;
    private Paid paid;
    private String description;
    private Payment payment;
}
