package dev.cvetan.teachingschedule.service.impl;

import dev.cvetan.teachingschedule.controller.definition.filter.SubjectListFilters;
import dev.cvetan.teachingschedule.model.dto.ListDTO;
import dev.cvetan.teachingschedule.model.dto.SubjectDTO;
import dev.cvetan.teachingschedule.service.SubjectService;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Override
    public ListDTO<SubjectDTO> fetchSubjects(SubjectListFilters filters) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public SubjectDTO fetchSubject(Long id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
