package com.fantasy.transformer;

import com.fantasy.transformer.models.internal.v1.League;
import com.fantasy.transformer.models.internal.v1.Player;
import com.fantasy.transformer.models.internal.v1.Roster;
import com.fantasy.transformer.models.internal.v1.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TransformerController {

    @Autowired
    private TransformerService transformerService;

    @GetMapping("/league/{leagueId}")
    public League getLeague(@PathVariable String leagueId) throws IOException, InterruptedException {
        return transformerService.getLeague(leagueId);
    }

    @GetMapping("/rosters/{leagueId}")
    public List<Roster> getRosters(@PathVariable String leagueId) throws IOException, InterruptedException {
        return transformerService.getRosters(leagueId);
    }

    @GetMapping("/users/{leagueId}")
    public List<User> getUsers(@PathVariable String leagueId) throws IOException, InterruptedException {
        return transformerService.getUsers(leagueId);
    }

    @GetMapping("/players")
    public List<Player> getPlayers() throws IOException, InterruptedException {
        return transformerService.getPlayers();
    }
}

