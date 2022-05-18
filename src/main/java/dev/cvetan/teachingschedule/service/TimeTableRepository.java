package dev.cvetan.teachingschedule.service;

import dev.cvetan.teachingschedule.exception.TSRuntimeException;
import dev.cvetan.teachingschedule.repository.ClassroomRepository;
import dev.cvetan.teachingschedule.repository.LessonRepository;
import dev.cvetan.teachingschedule.repository.TimeslotRepository;
import dev.cvetan.teachingschedule.solver.TimeTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TimeTableRepository {

    public static final Long SINGLETON_TIME_TABLE_ID = 1L;

    private final TimeslotRepository timeslotRepository;
    private final ClassroomRepository classroomRepository;
    private final LessonRepository lessonRepository;

    public TimeTable findById(Long id) {
        if (!SINGLETON_TIME_TABLE_ID.equals(id)) {
            throw new TSRuntimeException(String.format(
                    "There is no timetable with ID %d",
                    id
            ));
        }

        return new TimeTable(
                timeslotRepository.findAll(),
                classroomRepository.findAll(),
                lessonRepository.findAll()
        );
    }

    public void save(TimeTable timeTable) {
        lessonRepository.saveAll(timeTable.getLessons());
    }

}
