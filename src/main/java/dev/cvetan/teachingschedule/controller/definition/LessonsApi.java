package dev.cvetan.teachingschedule.controller.definition;

import dev.cvetan.teachingschedule.model.dto.LessonDTO;
import dev.cvetan.teachingschedule.model.dto.ListDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.DayOfWeek;

@Tag(name = "Lessons API", description = "Endpoints related to lessons")
public interface LessonsApi {

    @Operation(summary = "Returns list of all lessons")
    @GetMapping(value = "/api/lessons", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    ListDTO<LessonDTO> fetchAllLessons();

    @Operation(summary = "Return list of lessons by student group")
    @GetMapping(value = "/api/lessons/student-group/{studentGroup}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    ListDTO<LessonDTO> fetchLessonsByStudentGroup(@PathVariable String studentGroup);

    @Operation(summary = "Return list of lessons by day of week")
    @GetMapping(value = "/api/lessons/day-of-week/{dayOfWeek}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    ListDTO<LessonDTO> fetchLessonsByDayOfWeek(@PathVariable DayOfWeek dayOfWeek);

    @Operation(summary = "Return list of lessons by classroom")
    @GetMapping(value = "/api/lessons/classroom/{classroom}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    ListDTO<LessonDTO> fetchLessonsByClassroom(@PathVariable String classroom);
}
