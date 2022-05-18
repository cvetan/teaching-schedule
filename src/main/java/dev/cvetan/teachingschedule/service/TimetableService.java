package dev.cvetan.teachingschedule.service;

import dev.cvetan.teachingschedule.solver.Timetable;

public interface TimetableService {

    Timetable getTimeTable(Long id);

    void save(Timetable timetable);
}
