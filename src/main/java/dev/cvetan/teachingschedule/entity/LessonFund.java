package dev.cvetan.teachingschedule.entity;

import dev.cvetan.teachingschedule.model.LessonType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "lesson_funds")
@Getter
@Setter
public class LessonFund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "lesson_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private LessonType lessonType;

    @Column(name = "lesson_number", nullable = false)
    private Integer lessonNumber;
}