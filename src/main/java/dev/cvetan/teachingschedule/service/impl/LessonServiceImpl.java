package dev.cvetan.teachingschedule.service.impl;

import dev.cvetan.teachingschedule.entity.Lesson;
import dev.cvetan.teachingschedule.mapper.LessonsMapper;
import dev.cvetan.teachingschedule.model.dto.LessonDTO;
import dev.cvetan.teachingschedule.model.dto.ListDTO;
import dev.cvetan.teachingschedule.model.enums.LessonType;
import dev.cvetan.teachingschedule.repository.LessonRepository;
import dev.cvetan.teachingschedule.repository.ProgrammeSubjectAssignmentRepository;
import dev.cvetan.teachingschedule.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final ProgrammeSubjectAssignmentRepository programmeSubjectAssignmentRepository;
    private final LessonRepository lessonRepository;
    private final LessonsMapper lessonsMapper;

    @Override
    @Transactional
    public void generateLessonsStub() {
        var assignments = programmeSubjectAssignmentRepository.findAllSorted();
        var lessons = assignments.stream()
                .flatMap(assignment ->  assignment.getStudentGroups()
                        .stream()
                        .map(studentGroup -> {
                            var subject = assignment.getSubject();

                            var lecture = new Lesson();
                            lecture.setSubject(subject);
                            lecture.setStudentGroup(studentGroup);
                            lecture.setLessonType(LessonType.LECTURES);

                            var exercises = new Lesson();
                            exercises.setSubject(subject);
                            exercises.setStudentGroup(studentGroup);
                            exercises.setLessonType(LessonType.EXERCISES);

                            return List.of(lecture, exercises);
                        })
                )
                .flatMap(Collection::stream)
                .toList();

        lessonRepository.deleteAll();
        lessonRepository.saveAll(lessons);

    }

    @Override
    @Transactional
    public ListDTO<LessonDTO> fetchLessons() {
        var lessons = lessonRepository.findAllSorted();
        List<LessonDTO> lessonDTOs = lessons.stream()
                .map(lessonsMapper::map)
                .toList();

        ListDTO.ListDTOBuilder<LessonDTO> builder = ListDTO.builder();

        return builder.data(lessonDTOs)
                .totalCount(lessons.size())
                .build();
    }
}
