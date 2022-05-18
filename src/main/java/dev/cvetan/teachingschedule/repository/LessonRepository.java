package dev.cvetan.teachingschedule.repository;

import dev.cvetan.teachingschedule.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
