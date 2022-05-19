package dev.cvetan.teachingschedule.controller;

import dev.cvetan.teachingschedule.controller.definition.LessonsApi;
import dev.cvetan.teachingschedule.model.dto.LessonDTO;
import dev.cvetan.teachingschedule.model.dto.ListDTO;
import dev.cvetan.teachingschedule.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;

@RestController
@RequiredArgsConstructor
public class LessonsController implements LessonsApi {

    private final LessonService lessonService;

    @Override
    public ListDTO<LessonDTO> fetchAllLessons() {
        return lessonService.fetchLessons();
    }

    @Override
    public ListDTO<LessonDTO> fetchLessonsByStudentGroup(String studentGroup) {
        return lessonService.fetchLessonsByStudentGroup(studentGroup);
    }

    @Override
    public ListDTO<LessonDTO> fetchLessonsByDayOfWeek(DayOfWeek dayOfWeek) {
        return lessonService.fetchLessonsByDayOfWeek(dayOfWeek);
    }

    @Override
    public ListDTO<LessonDTO> fetchLessonsByClassroom(String classroom) {
        return lessonService.fetchLessonsByClassroom(classroom);
    }
}
