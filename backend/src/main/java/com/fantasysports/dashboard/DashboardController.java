package com.fantasysports.dashboard;

import com.fantasysports.dashboard.models.internal.League;
import com.fantasysports.dashboard.models.internal.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/league/{leagueId}")
    public League getLeague(@PathVariable String leagueId) throws IOException, InterruptedException {
        return dashboardService.serveLeague("nfl", leagueId);
    }

    @GetMapping("/players")
    public List<Player> getPlayers(@PathVariable Boolean getInactivePlayers) throws IOException, InterruptedException {
        return dashboardService.servePlayers("nfl", getInactivePlayers);
    }


    @GetMapping("/players")
    public List<Player> getPlayers() throws IOException, InterruptedException {
        return dashboardService.servePlayers("nfl", false);
    }

}

