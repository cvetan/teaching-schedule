package dev.cvetan.teachingschedule.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "subjects")
@Getter
@Setter
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "epsb_points")
    private Integer epsbPoints;

    @OneToMany(mappedBy = "subject")
    private Set<Lesson> lessons;

    @OneToMany(mappedBy = "subject")
    private Set<ProgrammeSubjectAssignment> programmeSubjectAssignments;

    @OneToMany(mappedBy = "subject")
    private Set<SubjectLessonFund> subjectLessonFunds;

    @OneToMany(mappedBy = "teacher")
    private Set<TeacherSubjectAssignment> teacherSubjectAssignments;

}