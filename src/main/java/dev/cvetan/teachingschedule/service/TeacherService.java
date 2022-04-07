package dev.cvetan.teachingschedule.service;

import dev.cvetan.teachingschedule.controller.definition.filter.TeacherListFilters;
import dev.cvetan.teachingschedule.model.dto.ListDTO;
import dev.cvetan.teachingschedule.model.dto.TeacherDTO;

public interface TeacherService {

    ListDTO<TeacherDTO> fetchTeachers(TeacherListFilters filters);

    TeacherDTO fetchTeacher(Long id);
}
