package dev.cvetan.teachingschedule.repository;

import dev.cvetan.teachingschedule.entity.Lesson;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, Long> {
}
