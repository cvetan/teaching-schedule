package dev.cvetan.teachingschedule.controller;

import dev.cvetan.teachingschedule.service.TimeTableRepository;
import dev.cvetan.teachingschedule.solver.TimeTable;
import lombok.RequiredArgsConstructor;
import org.optaplanner.core.api.score.ScoreManager;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.SolverManager;
import org.optaplanner.core.api.solver.SolverStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TimeTableController {

    private final TimeTableRepository timeTableRepository;
    private final SolverManager<TimeTable, Long> solverManager;

    private final ScoreManager<TimeTable, HardSoftScore> scoreManager;

    @GetMapping("/api/timetable")
    public TimeTable getTimeTable() {
        var solverStatus = getSolverStatus();
        var solution = timeTableRepository.findById(TimeTableRepository.SINGLETON_TIME_TABLE_ID);

        scoreManager.updateScore(solution);
        solution.setSolverStatus(solverStatus);

        return solution;
    }

    public SolverStatus getSolverStatus() {
        return solverManager.getSolverStatus(TimeTableRepository.SINGLETON_TIME_TABLE_ID);
    }

    @PostMapping("/api/timetable")
    public void solve() {
        solverManager.solveAndListen(
                TimeTableRepository.SINGLETON_TIME_TABLE_ID,
                timeTableRepository::findById,
                timeTableRepository::save
        );
    }
}
