package dev.cvetan.teachingschedule.controller;

import dev.cvetan.teachingschedule.controller.definition.TeachersApi;
import dev.cvetan.teachingschedule.controller.definition.filter.TeacherListFilters;
import dev.cvetan.teachingschedule.model.dto.ListDTO;
import dev.cvetan.teachingschedule.model.dto.TeacherDTO;
import dev.cvetan.teachingschedule.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TeachersController implements TeachersApi {

    private final TeacherService teacherService;

    @Override
    public ListDTO<TeacherDTO> fetchTeachers(TeacherListFilters filters) {
        return teacherService.fetchTeachers(filters);
    }

    @Override
    public TeacherDTO fetchTeacher(Long id) {
        return teacherService.fetchTeacher(id);
    }
}
