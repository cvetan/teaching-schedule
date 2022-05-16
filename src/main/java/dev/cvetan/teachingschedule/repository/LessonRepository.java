package dev.cvetan.teachingschedule.repository;

import dev.cvetan.teachingschedule.entity.Lesson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface LessonRepository extends CrudRepository<Lesson, Long> {

    @Query("select l from Lesson l")
//    @Query("select l from Lesson l order by l.timeslot.dayOfWeek asc, l.timeslot.startTime asc")
    Set<Lesson> findAllSorted();
}
