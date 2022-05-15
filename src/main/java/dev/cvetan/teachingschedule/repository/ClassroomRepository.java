package dev.cvetan.teachingschedule.repository;

import dev.cvetan.teachingschedule.entity.Classroom;
import org.springframework.data.repository.CrudRepository;

public interface ClassroomRepository extends CrudRepository<Classroom, Long> {
}
