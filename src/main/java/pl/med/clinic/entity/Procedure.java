package pl.med.clinic.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "procedure")
@NoArgsConstructor
@Getter
@Setter
public class Procedure {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String chapterId;
    private String chapter;
    private String subchapterId;
    private String subchapter;
    private String mainCategoryId;
    private String mainCategory;
    private String detailedCategoryId;
    private String detailedCategory;
}
