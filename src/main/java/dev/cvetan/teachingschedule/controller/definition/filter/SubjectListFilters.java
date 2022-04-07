package dev.cvetan.teachingschedule.controller.definition.filter;

import io.swagger.v3.oas.annotations.media.Schema;

public class SubjectListFilters {

    @Schema(defaultValue = "1", minimum = "1")
    Integer page;

    @Schema(defaultValue = "10", minimum = "1")
    Integer size;
}
