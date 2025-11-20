package com.fantasysports.dashboard;

import com.fantasysports.dashboard.models.internal.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/league/{leagueId}")
    public League getLeague(@PathVariable String leagueId) throws IOException, InterruptedException {
        return dashboardService.serveLeague("nfl", leagueId);
    }

}

