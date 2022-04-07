package dev.cvetan.teachingschedule.controller;

import dev.cvetan.teachingschedule.controller.definition.SubjectsApi;
import dev.cvetan.teachingschedule.controller.definition.filter.SubjectListFilters;
import dev.cvetan.teachingschedule.model.dto.ListDTO;
import dev.cvetan.teachingschedule.model.dto.SubjectDTO;
import dev.cvetan.teachingschedule.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SubjectsController implements SubjectsApi {

    private final SubjectService subjectService;

    @Override
    public ListDTO<SubjectDTO> fetchSubjects(SubjectListFilters filters) {
        return subjectService.fetchSubjects(filters);
    }

    @Override
    public SubjectDTO fetchTeacher(Long id) {
        return subjectService.fetchSubject(id);
    }
}
