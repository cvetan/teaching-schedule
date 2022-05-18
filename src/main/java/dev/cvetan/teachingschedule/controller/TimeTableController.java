package dev.cvetan.teachingschedule.controller;

import dev.cvetan.teachingschedule.config.Constants;
import dev.cvetan.teachingschedule.service.TimetableService;
import dev.cvetan.teachingschedule.solver.Timetable;
import lombok.RequiredArgsConstructor;
import org.optaplanner.core.api.solver.SolverManager;
import org.optaplanner.core.api.solver.SolverStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TimeTableController {

    private final SolverManager<Timetable, Long> solverManager;

//    private final ScoreManager<Timetable, HardSoftScore> scoreManager;

    private final TimetableService timetableService;

//    @GetMapping("/api/timetable")
//    public Timetable getTimeTable() {
//        var solverStatus = getSolverStatus();
//        var solution = timetableService.getTimeTable(Constants.TIMETABLE_ID);
//
//        scoreManager.updateScore(solution);
//        solution.setSolverStatus(solverStatus);
//
//        return solution;
//    }

    public SolverStatus getSolverStatus() {
        return solverManager.getSolverStatus(Constants.TIMETABLE_ID);
    }

    @PostMapping("/api/timetable")
    public void solve() {
        solverManager.solveAndListen(
                Constants.TIMETABLE_ID,
                timetableService::getTimeTable,
                timetableService::save
        );
    }
}
