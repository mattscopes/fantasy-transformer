package com.fantasy.transformer;

import com.fantasy.transformer.models.internal.League;
import com.fantasy.transformer.models.internal.Team;
import com.fantasy.transformer.models.internal.Player;
import com.fantasy.transformer.models.sleeper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class TransformerService {

    @Autowired
    private SleeperClient sleeperClient;

    public League parseLeague(String sport, String leagueId) throws IOException, InterruptedException {

        SleeperLeague sleeperLeague = Optional.ofNullable(sleeperClient.getLeague(leagueId))
            .orElse(new SleeperLeague());
        List<SleeperUser> sleeperUsers = Optional.ofNullable(sleeperClient.getUsers(leagueId))
            .orElse(Collections.emptyList());
        List<SleeperRoster> sleeperRosters = Optional.ofNullable(sleeperClient.getRosters(leagueId))
            .orElse(Collections.emptyList());
        Map<String,SleeperPlayer> sleeperPlayers = Optional.ofNullable(sleeperClient.getPlayers(sport))
            .orElse(Collections.emptyMap());

        League league = new League();

        Optional.of(sleeperLeague.getName())
            .ifPresent(league::setName);
        Optional.ofNullable(sleeperLeague.getSeason())
            .ifPresent(league::setSeason);
        Optional.ofNullable(sleeperLeague.getSport())
            .map(v -> v.toUpperCase())
            .ifPresent(league::setSport);

        List<Team> teams = parseTeams(sleeperUsers, sleeperRosters, sleeperPlayers);

        league.setTeams(teams);

        return league;
    }

    private List<Team> parseTeams(List<SleeperUser> sleeperUsers, List<SleeperRoster> sleeperRosters, Map<String,SleeperPlayer> sleeperPlayers) {

        Map<String, SleeperUser> userMap = Optional.ofNullable(sleeperUsers)
            .orElse(Collections.emptyList())
            .stream()
            .filter(Objects::nonNull)
            .collect(Collectors.toMap(SleeperUser::getUserId, su -> su));

        List<Team> teams = sleeperRosters.stream()
            .filter(Objects::nonNull)
            .map(sleeperRoster -> {

                Team team = new Team();

                Optional.ofNullable(parseTeamName(userMap, sleeperRoster))
                    .ifPresent(team::setName);
                Optional.ofNullable(sleeperRoster.getSettings())
                    .map(SleeperRosterSettings::getWins)
                    .ifPresent(team::setWins);
                Optional.ofNullable(sleeperRoster.getSettings())
                    .map(SleeperRosterSettings::getLosses)
                    .ifPresent(team::setLosses);
                Optional.ofNullable(sleeperRoster.getSettings())
                    .map(SleeperRosterSettings::getTies)
                    .ifPresent(team::setTies);
                Optional.ofNullable(sleeperRoster.getStarters())
                    .map(v -> parsePlayers(sleeperPlayers, v))
                    .ifPresent(team::setStarters);

                return team;

            })
            .collect(Collectors.toList());

        return teams;
    }

    private String parseTeamName(Map<String,SleeperUser> userMap, SleeperRoster sleeperRoster) {

        AtomicReference<String> teamName = new AtomicReference<>();

        Optional.ofNullable(sleeperRoster.getOwnerId())
            .map(userMap::get)
            .ifPresent(su -> {
                Optional.ofNullable(su.getMetadata())
                    .map(SleeperUserMetadata::getTeamName)
                    .ifPresent(teamName::set);
                if (teamName.get() == null || teamName.get().isEmpty()) {
                    Optional.ofNullable(su.getDisplayName())
                        .ifPresent(teamName::set);
                }
            });

        if (teamName.get() == null || teamName.get().isEmpty()) {
            Optional.ofNullable(sleeperRoster.getRosterId())
                .ifPresent(id -> teamName.set("Team " + id));
        }
        if (teamName.get() == null || teamName.get().isEmpty()) {
            teamName.set("Unknown Team");
        }

        return teamName.get();
    }

    private List<Player> parsePlayers(Map<String,SleeperPlayer> sleeperPlayers, List<String> SleeperPlayerIds) {

        List<Player> players = Optional.ofNullable(SleeperPlayerIds)
            .orElse(Collections.emptyList())
            .stream()
            .map(sleeperPlayers::get)
            .filter(Objects::nonNull)
            .map(sp -> {

                Player player = new Player();
                Optional.ofNullable(sp.getFirstName())
                    .ifPresent(player::setFirstName);
                Optional.ofNullable(sp.getLastName())
                    .ifPresent(player::setLastName);
                Optional.ofNullable(sp.getFantasyPositions())
                    .ifPresent(player::setPositions);
                Optional.ofNullable(sp.getTeam())
                    .ifPresent(player::setTeam);
                Optional.ofNullable(sp.getNumber())
                    .ifPresent(player::setNumber);
                return player;

            })
            .collect(Collectors.toList());

        return players.isEmpty() ? null : players;
    }

}
