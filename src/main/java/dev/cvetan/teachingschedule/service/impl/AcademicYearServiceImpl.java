package dev.cvetan.teachingschedule.service.impl;

import dev.cvetan.teachingschedule.model.dto.AcademicYearDTO;
import dev.cvetan.teachingschedule.model.dto.ListDTO;
import dev.cvetan.teachingschedule.service.AcademicYearService;
import org.springframework.stereotype.Service;

@Service
public class AcademicYearServiceImpl implements AcademicYearService {


    @Override
    public ListDTO<AcademicYearDTO> fetchAcademicYears() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
