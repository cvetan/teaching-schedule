package dev.cvetan.teachingschedule.service.impl;

import dev.cvetan.teachingschedule.repository.LessonRepository;
import dev.cvetan.teachingschedule.repository.ProgrammeSubjectAssignmentRepository;
import dev.cvetan.teachingschedule.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final ProgrammeSubjectAssignmentRepository programmeSubjectAssignmentRepository;

    @Override
    public void generateLessonsStub() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
