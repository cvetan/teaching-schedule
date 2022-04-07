package dev.cvetan.teachingschedule.service;

import dev.cvetan.teachingschedule.model.dto.AcademicYearDTO;
import dev.cvetan.teachingschedule.model.dto.ListDTO;

public interface AcademicYearService {

    ListDTO<AcademicYearDTO> fetchAcademicYears();
}
