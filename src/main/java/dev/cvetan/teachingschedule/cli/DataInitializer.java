package dev.cvetan.teachingschedule.cli;

import dev.cvetan.teachingschedule.entity.StudentGroup;
import dev.cvetan.teachingschedule.entity.StudyProgramme;
import dev.cvetan.teachingschedule.entity.Subject;
import dev.cvetan.teachingschedule.model.enums.StudyLevel;
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

@Component
@Slf4j
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CsvUtil csvUtil;
    private final StudentGroupRepository studentGroupRepository;
    private final StudyProgrammeRepository studyProgrammeRepository;
    private final SubjectRepository subjectRepository;

    private static final String STUDENT_GROUPS_PATH = "src/main/resources/csv/student_groups.csv";
    private static final String STUDY_PROGRAMMES_PATH = "src/main/resources/csv/study_programmes.csv";
    private static final String SUBJECTS_PATH = "src/main/resources/csv/subjects.csv";


    @Override
    @Transactional
    public void run(String... args) {
        log.info("Data initializer running...");

        importStudentGroups();
        importStudyProgrammes();
        importSubjects();
    }

    private void importStudentGroups() {
        var content = csvUtil.readCsvFile(STUDENT_GROUPS_PATH);
        var studentGroups = new ArrayList<StudentGroup>();

        content.forEach(row -> {
            var studentGroup = new StudentGroup();
            studentGroup.setName(row[0]);

            studentGroups.add(studentGroup);
        });

        studentGroupRepository.saveAll(studentGroups);

        log.info("Imported student groups.");
    }

    private void importStudyProgrammes() {
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
    }

    private void importSubjects() {
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
    }
}
