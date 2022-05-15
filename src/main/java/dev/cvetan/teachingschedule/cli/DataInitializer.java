package dev.cvetan.teachingschedule.cli;

import dev.cvetan.teachingschedule.entity.ProgrammeSubjectAssignment;
import dev.cvetan.teachingschedule.entity.StudentGroup;
import dev.cvetan.teachingschedule.entity.StudyProgramme;
import dev.cvetan.teachingschedule.entity.Subject;
import dev.cvetan.teachingschedule.model.enums.Semester;
import dev.cvetan.teachingschedule.model.enums.StudyLevel;
import dev.cvetan.teachingschedule.model.enums.SubjectType;
import dev.cvetan.teachingschedule.repository.ProgrammeSubjectAssignmentRepository;
import dev.cvetan.teachingschedule.repository.StudentGroupRepository;
import dev.cvetan.teachingschedule.repository.StudyProgrammeRepository;
import dev.cvetan.teachingschedule.repository.SubjectRepository;
import dev.cvetan.teachingschedule.util.CsvUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CsvUtil csvUtil;
    private final StudentGroupRepository studentGroupRepository;
    private final StudyProgrammeRepository studyProgrammeRepository;
    private final SubjectRepository subjectRepository;
    private final ProgrammeSubjectAssignmentRepository programmeSubjectAssignmentRepository;

    private static final String STUDENT_GROUPS_PATH = "src/main/resources/csv/student_groups.csv";
    private static final String STUDY_PROGRAMMES_PATH = "src/main/resources/csv/study_programmes.csv";
    private static final String SUBJECTS_PATH = "src/main/resources/csv/subjects.csv";
    private static final String PROGRAMME_SUBJECTS_ASSIGNMENTS_PATH = "src/main/resources/csv/programme_subject_assignments.csv";


    @Override
    @Transactional
    public void run(String... args) {
        log.info("Data initializer running...");

        var studentGroups = importStudentGroups();
        var studyProgrammes = importStudyProgrammes();
        var subjects = importSubjects();
        importStudyProgrammes(
                studyProgrammes,
                studentGroups,
                subjects
        );

    }

    private Map<String, StudentGroup> importStudentGroups() {
        var content = csvUtil.readCsvFile(STUDENT_GROUPS_PATH);
        var studentGroups = new ArrayList<StudentGroup>();

        content.forEach(row -> {
            var studentGroup = new StudentGroup();
            studentGroup.setName(row[0]);

            studentGroups.add(studentGroup);
        });

        studentGroupRepository.saveAll(studentGroups);

        log.info("Imported student groups.");

        return studentGroups.stream()
                .collect(
                        Collectors.toMap(
                                StudentGroup::getName,
                                Function.identity()
                        )
                );
    }

    private Map<String, StudyProgramme> importStudyProgrammes() {
        var content = csvUtil.readCsvFile(STUDY_PROGRAMMES_PATH);
        var studyProgrammes = new ArrayList<StudyProgramme>();

        content.forEach(row -> {
            var studyProgramme = new StudyProgramme();

            studyProgramme.setName(row[0]);
            studyProgramme.setEpsbPoints(Integer.valueOf(row[1]));
            studyProgramme.setNumberOfYears(Integer.valueOf(row[2]));
            studyProgramme.setStudyLevel(StudyLevel.valueOf(row[3]));

            studyProgrammes.add(studyProgramme);
        });

        studyProgrammeRepository.saveAll(studyProgrammes);

        log.info("Imported study programmes.");

        return studyProgrammes.stream()
                .collect(
                        Collectors.toMap(
                                StudyProgramme::getName,
                                Function.identity()
                        )
                );
    }

    private Map<String, Subject> importSubjects() {
        var content = csvUtil.readCsvFile(SUBJECTS_PATH);
        var subjects = new ArrayList<Subject>();

        content.forEach(row -> {
            var subject = new Subject();

            subject.setName(row[0]);
            subject.setEpsbPoints(Integer.valueOf(row[1]));

            subjects.add(subject);
        });

        subjectRepository.saveAll(subjects);

        log.info("Imported subjects.");

        return subjects.stream()
                .collect(
                        Collectors.toMap(
                                Subject::getName,
                                Function.identity()
                        )
                );
    }

    private void importStudyProgrammes(
            Map<String, StudyProgramme> studyProgrammesMap,
            Map<String, StudentGroup> studentGroupsMap,
            Map<String, Subject> subjectsMap
    ) {
        var content = csvUtil.readCsvFile(PROGRAMME_SUBJECTS_ASSIGNMENTS_PATH);
        var assignments = new ArrayList<ProgrammeSubjectAssignment>();

        content.forEach(row -> {
            var assignment = new ProgrammeSubjectAssignment();
            assignment.setStudyProgramme(studyProgrammesMap.get(row[0]));
            assignment.setSubject(subjectsMap.get(row[1]));
            assignment.setSemester(Semester.valueOf(row[2]));
            assignment.setSubjectType(SubjectType.valueOf(row[3]));

            var studentGroups = Arrays.stream(row[4].split(","))
                    .filter(studentGroupsMap::containsKey)
                    .map(studentGroupsMap::get)
                    .collect(Collectors.toSet());

            assignment.setStudentGroups(studentGroups);

            assignments.add(assignment);
        });

        programmeSubjectAssignmentRepository.saveAll(assignments);

        log.info("Imported programme subject assignments.");
    }
}
