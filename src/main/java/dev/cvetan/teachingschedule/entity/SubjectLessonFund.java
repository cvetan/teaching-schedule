package dev.cvetan.teachingschedule.entity;

import dev.cvetan.teachingschedule.model.enums.LessonType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "subject_lesson_funds")
@Getter
@Setter
public class SubjectLessonFund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @Column(name = "lesson_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private LessonType lessonType;

    @Column(name = "lesson_number", nullable = false)
    private Integer lessonNumber;
}