package dev.cvetan.teachingschedule.entity;

import dev.cvetan.teachingschedule.model.Semester;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "programe_subject_assignments")
@Getter
@Setter
public class ProgrameSubjectAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "study_programme_id", nullable = false)
    private StudyProgramme studyProgramme;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @Column(name = "semester", nullable = false)
    @Enumerated(EnumType.STRING)
    private Semester semester;

}