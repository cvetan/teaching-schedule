package dev.cvetan.teachingschedule.entity;

import dev.cvetan.teachingschedule.model.StudyLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "study_programmes")
@Getter
@Setter
public class StudyProgramme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "epsb_points")
    private Integer epsbPoints;

    @Column(name = "number_of_years")
    private Integer numberOfYears;

    @Column(name = "study_level", nullable = false)
    @Enumerated(EnumType.STRING)
    private StudyLevel studyLevel;
}