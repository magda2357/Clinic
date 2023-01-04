package pl.med.clinic.dto;

import lombok.Getter;
import pl.med.clinic.entity.VisitEntity;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Getter
public class VisitsDtoResponse {

    private final List<VisitDto> visits;

    public VisitsDtoResponse(List<VisitEntity> visits) {
        this.visits = visits.stream()
                .map(VisitDto::new)
                .collect(toList());
    }

}
