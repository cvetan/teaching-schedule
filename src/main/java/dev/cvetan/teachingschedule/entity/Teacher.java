package dev.cvetan.teachingschedule.entity;

import dev.cvetan.teachingschedule.model.TeachingPosition;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
@Getter
@Setter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "teaching_position", nullable = false)
    @Enumerated(EnumType.STRING)
    private TeachingPosition teachingPosition;
}