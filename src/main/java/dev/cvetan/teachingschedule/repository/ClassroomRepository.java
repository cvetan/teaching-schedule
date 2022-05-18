package dev.cvetan.teachingschedule.repository;

import dev.cvetan.teachingschedule.entity.Classroom;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClassroomRepository extends CrudRepository<Classroom, Long> {

    @Override
    List<Classroom> findAll();
}
