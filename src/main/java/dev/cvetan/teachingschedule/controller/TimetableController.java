package dev.cvetan.teachingschedule.controller;

import dev.cvetan.teachingschedule.config.Constants;
import dev.cvetan.teachingschedule.controller.definition.TimetableApi;
import dev.cvetan.teachingschedule.service.TimetableService;
import dev.cvetan.teachingschedule.solver.Timetable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.optaplanner.core.api.solver.SolverManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TimetableController implements TimetableApi {

    private final SolverManager<Timetable, Long> solverManager;

    private final TimetableService timetableService;

    @PostMapping("/api/timetable")
    public void solve() {
        solverManager.solveAndListen(
                Constants.TIMETABLE_ID,
                timetableService::getTimeTable,
                timetableService::save
        );
    }
}
