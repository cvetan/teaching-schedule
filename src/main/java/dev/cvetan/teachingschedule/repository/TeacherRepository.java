package dev.cvetan.teachingschedule.repository;

import dev.cvetan.teachingschedule.entity.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}