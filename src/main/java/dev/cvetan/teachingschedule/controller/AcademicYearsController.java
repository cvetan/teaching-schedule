package dev.cvetan.teachingschedule.controller;

import dev.cvetan.teachingschedule.controller.definition.AcademicYearsApi;
import dev.cvetan.teachingschedule.model.dto.AcademicYearDTO;
import dev.cvetan.teachingschedule.model.dto.ListDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AcademicYearsController implements AcademicYearsApi {


    @Override
    public ListDTO<AcademicYearDTO> fetchAcademicYears() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
