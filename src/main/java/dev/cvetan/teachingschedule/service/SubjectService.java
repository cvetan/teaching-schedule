package dev.cvetan.teachingschedule.service;

import dev.cvetan.teachingschedule.controller.definition.filter.SubjectListFilters;
import dev.cvetan.teachingschedule.model.dto.ListDTO;
import dev.cvetan.teachingschedule.model.dto.SubjectDTO;

public interface SubjectService {

    ListDTO<SubjectDTO> fetchSubjects(SubjectListFilters filters);

    SubjectDTO fetchSubject(Long id);
}
