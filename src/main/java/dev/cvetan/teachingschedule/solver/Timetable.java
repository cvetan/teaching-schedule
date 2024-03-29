package dev.cvetan.teachingschedule.solver;

import dev.cvetan.teachingschedule.entity.Classroom;
import dev.cvetan.teachingschedule.entity.Lesson;
import dev.cvetan.teachingschedule.entity.Timeslot;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.SolverStatus;

import java.util.List;

@PlanningSolution
@Getter
@Setter
@NoArgsConstructor
public class Timetable {

    @ValueRangeProvider(id = "timeslotRange")
    @ProblemFactCollectionProperty
    private List<Timeslot> timeslots;

    @ValueRangeProvider(id = "classroomRange")
    @ProblemFactCollectionProperty
    private List<Classroom> classrooms;

    @PlanningEntityCollectionProperty
    private List<Lesson> lessons;

    @PlanningScore
    private HardSoftScore score;

    private SolverStatus solverStatus;

    public Timetable(
            List<Timeslot> timeslots,
            List<Classroom> classrooms,
            List<Lesson> lessons
    ) {
        this.timeslots = timeslots;
        this.classrooms = classrooms;
        this.lessons = lessons;
    }
}