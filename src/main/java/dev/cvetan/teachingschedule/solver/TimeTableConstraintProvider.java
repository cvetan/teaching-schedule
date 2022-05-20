package dev.cvetan.teachingschedule.solver;

import dev.cvetan.teachingschedule.entity.Lesson;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;
import org.optaplanner.core.api.score.stream.tri.TriConstraintCollector;

import java.util.stream.Collectors;

import static org.optaplanner.core.api.score.stream.ConstraintCollectors.toList;

public class TimeTableConstraintProvider implements ConstraintProvider {

    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[] {
                roomConflict(constraintFactory),
                studentGroupConflict(constraintFactory),
                roomCapacity(constraintFactory)
        };
    }

    private Constraint roomConflict(ConstraintFactory constraintFactory) {
        return constraintFactory
                // Select each pair of 2 different lessons ...
                .forEachUniquePair(Lesson.class,
                        // ... in the same timeslot ...
                        Joiners.equal(Lesson::getTimeslot),
                        // ... in the same room ...
                        Joiners.equal(Lesson::getClassroom))
                // ... and penalize each pair with a hard weight.
                .penalize("Room conflict", HardSoftScore.ONE_HARD);
    }

    private Constraint studentGroupConflict(ConstraintFactory constraintFactory) {
        // A student group can attend at most one lesson at the same time.
        return constraintFactory
                .forEachUniquePair(Lesson.class,
                        Joiners.equal(Lesson::getTimeslot),
                        Joiners.equal(Lesson::getStudentGroup))
                .penalize("Student group conflict", HardSoftScore.ONE_HARD);
    }

    private Constraint roomCapacity(ConstraintFactory constraintFactory) {
        var roomCapacity = 4;

        return constraintFactory
                .forEach(Lesson.class)
                .groupBy(Lesson::getTimeslot, Lesson::getClassroom, toList())
                .filter(((timeslot, classroom, lessons) -> {
                    var studentGroups = lessons.stream()
                            .map(Lesson::getStudentGroup)
                            .collect(Collectors.toSet());

                    return studentGroups.size() <= roomCapacity;
                }))
                .penalize("Room capacity exceeded", HardSoftScore.ONE_HARD);
    }
}
