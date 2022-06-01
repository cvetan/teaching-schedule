package dev.cvetan.teachingschedule.solver;

import dev.cvetan.teachingschedule.entity.Lesson;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;

import static org.optaplanner.core.api.score.stream.ConstraintCollectors.count;

@SuppressWarnings("unused")
public class TimeTableConstraintProvider implements ConstraintProvider {

    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[]{
                studentGroupConflict(constraintFactory),
                roomCapacity(constraintFactory),
                studentGroupLessonLimit(constraintFactory),
                subjectConflict(constraintFactory),
                lessonTypeConflict(constraintFactory)
        };
    }

    private Constraint studentGroupConflict(ConstraintFactory constraintFactory) {
        // A student group can attend at most one lesson at the same time.
        return constraintFactory
                .forEachUniquePair(Lesson.class,
                        Joiners.equal(Lesson::getTimeslot),
                        Joiners.equal(Lesson::getStudentGroup)
                )
                .penalize("Student group conflict", HardSoftScore.ONE_HARD);
    }

    private Constraint roomCapacity(ConstraintFactory constraintFactory) {
        var roomCapacity = 4;

        return constraintFactory
                .forEach(Lesson.class)
                .groupBy(Lesson::getTimeslot, Lesson::getClassroom, Lesson::getStudentGroup, count())
                .filter(((timeslot, classroom, lessons, count) -> count > roomCapacity))
                .penalize("Room capacity exceeded", HardSoftScore.ONE_HARD);
    }

    private Constraint studentGroupLessonLimit(ConstraintFactory constraintFactory) {
        return constraintFactory
                .forEach(Lesson.class)
                .groupBy(Lesson::getStudentGroup, lesson -> lesson.getTimeslot().getDayOfWeek(), count())
                .filter(((studentGroup, dayOfWeek, count) -> count > 3))
                .penalize("Student group lesson limit", HardSoftScore.ONE_HARD);
    }

    private Constraint subjectConflict(ConstraintFactory constraintFactory) {
        return constraintFactory
                .forEach(Lesson.class)
                .join(Lesson.class,
                        Joiners.equal(Lesson::getTimeslot),
                        Joiners.equal(Lesson::getClassroom))
                .filter((lesson1, lesson2) -> !lesson1.getSubject().equals(lesson2.getSubject()))
                .penalize("Subject conflict", HardSoftScore.ONE_HARD);
    }

    private Constraint lessonTypeConflict(ConstraintFactory constraintFactory) {
        return constraintFactory
                .forEach(Lesson.class)
                .join(Lesson.class,
                        Joiners.equal(Lesson::getTimeslot),
                        Joiners.equal(Lesson::getClassroom))
                .filter((lesson1, lesson2) -> !lesson1.getLessonType().equals(lesson2.getLessonType()))
                .penalize("Lesson type conflict", HardSoftScore.ONE_HARD);
    }
}
