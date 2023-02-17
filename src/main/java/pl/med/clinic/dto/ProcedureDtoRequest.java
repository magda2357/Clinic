package pl.med.clinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProcedureDtoRequest {

    private String chapterId;
    private String chapter;
    private String subchapterId;
    private String subchapter;
    private String mainCategoryId;
    private String mainCategory;
    private String detailedCategoryId;
    private String detailedCategory;

}
