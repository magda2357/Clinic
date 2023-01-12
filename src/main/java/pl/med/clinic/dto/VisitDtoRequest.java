package pl.med.clinic.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.med.clinic.entity.Paid;
import pl.med.clinic.entity.Payment;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class VisitDtoRequest {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime visitDateTime;
    private Paid paid;
    private String description;
    private Payment payment;
}
