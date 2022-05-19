package dev.cvetan.teachingschedule.service;

import dev.cvetan.teachingschedule.model.dto.LessonDTO;
import dev.cvetan.teachingschedule.model.dto.ListDTO;

import java.time.DayOfWeek;

public interface LessonService {

    void generateLessonsStub();

    ListDTO<LessonDTO> fetchLessons();

    ListDTO<LessonDTO> fetchLessonsByStudentGroup(String studentGroup);

    ListDTO<LessonDTO> fetchLessonsByDayOfWeek(DayOfWeek dayOfWeek);

    ListDTO<LessonDTO> fetchLessonsByClassroom(String classroom);
}
