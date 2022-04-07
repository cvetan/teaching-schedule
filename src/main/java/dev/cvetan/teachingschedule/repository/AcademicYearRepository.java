package dev.cvetan.teachingschedule.repository;

import dev.cvetan.teachingschedule.entity.AcademicYear;
import org.springframework.data.repository.CrudRepository;

public interface AcademicYearRepository extends CrudRepository<AcademicYear, Long> {
}