package dev.cvetan.teachingschedule.entity;

import dev.cvetan.teachingschedule.model.LessonType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "student_group_id", nullable = false)
    private StudentGroup studentGroup;

    @ManyToOne
    @JoinColumn(name = "timeslot_id", nullable = false)
    private Timeslot timeslot;

    @Column(name = "lesson_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private LessonType lessonType;

}