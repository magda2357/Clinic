package pl.med.clinic.dto;

import lombok.Getter;
import pl.med.clinic.entity.VisitEntity;

import java.time.LocalDate;

@Getter
public class VisitDto {

    private final LocalDate visitDate;

    public VisitDto(VisitEntity entity) {
        this.visitDate = entity.getVisitDate();
    }

}
