package dev.cvetan.teachingschedule.service.impl;

import dev.cvetan.teachingschedule.controller.definition.filter.TeacherListFilters;
import dev.cvetan.teachingschedule.model.dto.ListDTO;
import dev.cvetan.teachingschedule.model.dto.TeacherDTO;
import dev.cvetan.teachingschedule.service.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Override
    public ListDTO<TeacherDTO> fetchTeachers(TeacherListFilters filters) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public TeacherDTO fetchTeacher(Long id) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
