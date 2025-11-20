package com.fantasy.transformer;

import com.fantasy.transformer.models.internal.League;
import com.fantasy.transformer.models.internal.Player;
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
        return transformerService.serveLeague("nfl", leagueId);
    }

    @GetMapping("/players")
    public List<Player> getPlayers(@PathVariable Boolean getInactivePlayers) throws IOException, InterruptedException {
        return transformerService.servePlayers("nfl", getInactivePlayers);
    }


    @GetMapping("/players")
    public List<Player> getPlayers() throws IOException, InterruptedException {
        return transformerService.servePlayers("nfl", false);
    }

}

