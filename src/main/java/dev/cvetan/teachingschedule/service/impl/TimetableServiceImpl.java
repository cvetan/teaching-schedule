package dev.cvetan.teachingschedule.service.impl;

import dev.cvetan.teachingschedule.repository.ClassroomRepository;
import dev.cvetan.teachingschedule.repository.LessonRepository;
import dev.cvetan.teachingschedule.repository.TimeslotRepository;
import dev.cvetan.teachingschedule.service.TimetableService;
import dev.cvetan.teachingschedule.solver.Timetable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TimetableServiceImpl implements TimetableService {

    private final TimeslotRepository timeslotRepository;
    private final ClassroomRepository classroomRepository;
    private final LessonRepository lessonRepository;

    @Override
    public Timetable getTimeTable(Long id) {
        return new Timetable(
                timeslotRepository.findAll(),
                classroomRepository.findAll(),
                lessonRepository.findAll()
        );
    }

    @Override
    @Transactional
    public void save(Timetable timetable) {
        lessonRepository.saveAll(timetable.getLessons());
    }
}
