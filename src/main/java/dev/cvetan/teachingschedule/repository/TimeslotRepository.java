package dev.cvetan.teachingschedule.repository;

import dev.cvetan.teachingschedule.entity.Timeslot;
import org.springframework.data.repository.CrudRepository;

public interface TimeslotRepository extends CrudRepository<Timeslot, Long> {
}
