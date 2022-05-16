package dev.cvetan.teachingschedule.mapper;

import dev.cvetan.teachingschedule.entity.Lesson;
import dev.cvetan.teachingschedule.model.dto.LessonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LessonsMapper {

    @Mapping(target = "studentGroup", source = "studentGroup.name")
    @Mapping(target = "subject", source = "subject.name")
    @Mapping(target = "classroom", source = "classroom.name")
    @Mapping(target = "dayOfWeek", source = "timeslot.dayOfWeek")
    @Mapping(target = "startTime", source = "timeslot.startTime")
    @Mapping(target = "endTime", source = "timeslot.endTime")
    LessonDTO map(Lesson lesson);
}
