package dev.cvetan.teachingschedule.service;

import dev.cvetan.teachingschedule.model.dto.LessonDTO;
import dev.cvetan.teachingschedule.model.dto.ListDTO;

public interface LessonService {

    void generateLessonsStub();

    ListDTO<LessonDTO> fetchLessons();
}
