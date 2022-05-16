package dev.cvetan.teachingschedule.repository;

import dev.cvetan.teachingschedule.entity.ProgrammeSubjectAssignment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ProgrammeSubjectAssignmentRepository extends CrudRepository<ProgrammeSubjectAssignment, Long> {

    @Query(
            "select psa " +
                    "from ProgrammeSubjectAssignment psa " +
                    "order by " +
                    "psa.studyProgramme.name asc, " +
                    "psa.subject.name asc"
    )
    Set<ProgrammeSubjectAssignment> findAllSorted();
}
