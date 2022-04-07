package dev.cvetan.teachingschedule.controller.definition;

import dev.cvetan.teachingschedule.controller.definition.filter.SubjectListFilters;
import dev.cvetan.teachingschedule.model.dto.ListDTO;
import dev.cvetan.teachingschedule.model.dto.SubjectDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Subjects API", description = "Endpoints related to subjects")
public interface SubjectsApi {

    @Operation(summary = "Returns list of subjects")
    @GetMapping(value = "/v1/subjects", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    ListDTO<SubjectDTO> fetchSubjects(
            @ParameterObject SubjectListFilters filters
    );

    @Operation(summary = "Fetch single subject")
    @GetMapping(value = "/v1/subjects/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    SubjectDTO fetchTeacher(@PathVariable Long id);
}
