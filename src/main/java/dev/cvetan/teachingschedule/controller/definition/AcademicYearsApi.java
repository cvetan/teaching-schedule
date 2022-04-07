package dev.cvetan.teachingschedule.controller.definition;

import dev.cvetan.teachingschedule.entity.AcademicYear;
import dev.cvetan.teachingschedule.model.dto.AcademicYearDTO;
import dev.cvetan.teachingschedule.model.dto.ListDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@Tag(name = "Academic years API", description = "API endpoints related to academic years")
public interface AcademicYearsApi {

    @Operation(summary = "This endpoint returns all academic years")
    @GetMapping(
            value = "/v1/api/academic-years",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    ListDTO<AcademicYearDTO> fetchAcademicYears();
}
