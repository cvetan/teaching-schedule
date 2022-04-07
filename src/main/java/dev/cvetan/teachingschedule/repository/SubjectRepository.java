package dev.cvetan.teachingschedule.repository;

import dev.cvetan.teachingschedule.entity.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
}