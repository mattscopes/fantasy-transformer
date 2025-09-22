package com.fantasy.transformer;

import com.fantasy.transformer.models.internal.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class TransformerController {

    @Autowired
    private TransformerService transformerService;

    @GetMapping("/league/{leagueId}")
    public League getLeague(@PathVariable String leagueId) throws IOException, InterruptedException {
        return transformerService.serveLeague("nfl", leagueId);
    }

}

