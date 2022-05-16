package dev.cvetan.teachingschedule.model.dto;

import dev.cvetan.teachingschedule.model.enums.LessonType;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.security.SecureRandom;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
public class LessonDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = new SecureRandom().nextLong();

    private String studentGroup;
    private String subject;
    private String classroom;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private LessonType lessonType;
}
