package pl.med.clinic.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import pl.med.clinic.entity.Paid;
import pl.med.clinic.entity.Payment;
import pl.med.clinic.entity.VisitEntity;

import java.time.LocalDateTime;

@Getter
public class VisitDto {

    private final Long id;
    private final LocalDateTime visitDateTime;
    private final Paid paid;
    private final String description;
    private final Payment payment;

    public VisitDto(VisitEntity entity) {
        this.id = entity.getId();
        this.visitDateTime = entity.getVisitDateTime();
        this.paid = entity.getPaid();
        this.description = entity.getDescription();
        this.payment = entity.getPayment();
    }

}
