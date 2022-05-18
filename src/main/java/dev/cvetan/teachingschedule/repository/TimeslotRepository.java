package dev.cvetan.teachingschedule.repository;

import dev.cvetan.teachingschedule.entity.Timeslot;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TimeslotRepository extends CrudRepository<Timeslot, Long> {

    @Override
    List<Timeslot> findAll();
}
