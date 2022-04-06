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

    @OneToMany
    @JoinColumn(name = "subject_id")
    private Set<LessonFund> lessonFunds;
}