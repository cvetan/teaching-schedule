package dev.cvetan.teachingschedule.entity;

import dev.cvetan.teachingschedule.model.enums.Semester;
import dev.cvetan.teachingschedule.model.enums.SubjectType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "programme_subject_assignments")
@Getter
@Setter
public class ProgrammeSubjectAssignment {

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

    @Column(name = "subject_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private SubjectType subjectType;

    @ManyToMany
    @JoinTable(
            name = "programme_subject_assignments_student_groups",
            joinColumns = @JoinColumn(name = "programme_subject_assignment_id"),
            inverseJoinColumns = @JoinColumn(name = "student_group_id")
    )
    private Set<StudentGroup> studentGroups;

}