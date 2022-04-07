package dev.cvetan.teachingschedule.controller;

import dev.cvetan.teachingschedule.controller.definition.AcademicYearsApi;
import dev.cvetan.teachingschedule.model.dto.AcademicYearDTO;
import dev.cvetan.teachingschedule.model.dto.ListDTO;
import dev.cvetan.teachingschedule.service.AcademicYearService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AcademicYearsController implements AcademicYearsApi {

    private final AcademicYearService academicYearService;

    @Override
    public ListDTO<AcademicYearDTO> fetchAcademicYears() {
        return academicYearService.fetchAcademicYears();
    }
}
