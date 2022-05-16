package dev.cvetan.teachingschedule.repository;

import dev.cvetan.teachingschedule.entity.StudentGroup;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface StudentGroupRepository extends CrudRepository<StudentGroup, Long> {

    Set<StudentGroup> findAllByOrderByNameAsc();
}
