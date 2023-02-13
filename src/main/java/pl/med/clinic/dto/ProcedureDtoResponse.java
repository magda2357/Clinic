package pl.med.clinic.dto;


import lombok.Getter;
import pl.med.clinic.entity.Procedure;

@Getter
public class ProcedureDtoResponse {

    private final String chapterId;
    private final String chapter;
    private final String subchapterId;
    private final String subchapter;
    private final String mainCategoryId;
    private final String mainCategory;
    private final String detailedCategoryId;
    private final String detailedCategory;

    public ProcedureDtoResponse(Procedure procedure) {
        this.chapterId = procedure.getChapterId();
        this.chapter = procedure.getChapter();
        this.subchapterId = procedure.getSubchapterId();
        this.subchapter = procedure.getSubchapter();
        this.mainCategoryId = procedure.getMainCategoryId();
        this.mainCategory = procedure.getMainCategory();
        this.detailedCategoryId = procedure.getDetailedCategoryId();
        this.detailedCategory = procedure.getDetailedCategory();
    }
}
