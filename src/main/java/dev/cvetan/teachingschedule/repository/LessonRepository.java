package dev.cvetan.teachingschedule.repository;

import dev.cvetan.teachingschedule.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.DayOfWeek;
import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

    @Query("""
            select l
            from Lesson l
            order by
                l.timeslot.dayOfWeek,
                l.timeslot.startTime""")
    List<Lesson> findAllSorted();

    @Query("""
            select l
            from Lesson l
            where upper(l.studentGroup.name) like upper(concat('%', ?1, '%'))
            order by
                l.timeslot.dayOfWeek,
                l.timeslot.startTime""")
    List<Lesson> findAllByStudentGroup(String studentGroup);

    @Query("""
            select l
            from Lesson l
            where upper(l.classroom.name) like upper(concat('%', ?1, '%'))
            order by
                l.timeslot.dayOfWeek,
                l.timeslot.startTime""")
    List<Lesson> findAllByClassroom(String classroom);

    @Query("""
            select l
            from Lesson l
            where l.timeslot.dayOfWeek = ?1
            order by l.timeslot.startTime""")
    List<Lesson> findAllByDayOfWeek(DayOfWeek dayOfWeek);


}
