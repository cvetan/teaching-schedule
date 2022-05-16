package dev.cvetan.teachingschedule.controller;

import dev.cvetan.teachingschedule.controller.definition.LessonsApi;
import dev.cvetan.teachingschedule.model.dto.LessonDTO;
import dev.cvetan.teachingschedule.model.dto.ListDTO;
import dev.cvetan.teachingschedule.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LessonsController implements LessonsApi {

    private final LessonService lessonService;

    @Override
    public ListDTO<LessonDTO> fetchSubjects() {
        return lessonService.fetchLessons();
    }
}
