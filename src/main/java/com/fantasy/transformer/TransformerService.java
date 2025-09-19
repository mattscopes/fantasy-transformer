package com.fantasy.transformer;

import com.fantasy.transformer.models.internal.League;
import com.fantasy.transformer.models.internal.Player;
import com.fantasy.transformer.models.internal.Roster;
import com.fantasy.transformer.models.internal.User;
import com.fantasy.transformer.models.sleeper.SleeperLeague;
import com.fantasy.transformer.models.sleeper.SleeperPlayer;
import com.fantasy.transformer.models.sleeper.SleeperRoster;
import com.fantasy.transformer.models.sleeper.SleeperUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class TransformerService {

    @Autowired
    private SleeperClient sleeperClient;

    @Cacheable("league")
    public League getLeague(String leagueId) throws IOException, InterruptedException {
        SleeperLeague sleeperLeague = Optional.ofNullable(sleeperClient.getLeague(leagueId))
            .orElse(new SleeperLeague());
        League league = new League();
        Optional.of(sleeperLeague.getLeagueId())
            .ifPresent(league::setId);
        Optional.of(sleeperLeague.getName())
            .ifPresent(league::setName);
        Optional.ofNullable(sleeperLeague.getSeason())
            .ifPresent(league::setSeason);
        return league;
    }

    @Cacheable("rosters")
    public List<Roster> getRosters(String leagueId) throws IOException, InterruptedException {
        List<SleeperRoster> sleeperRosters = Optional.ofNullable(sleeperClient.getRosters(leagueId))
            .orElse(new ArrayList<>());
        // Fetch all players once and map by ID
        Map<String, Player> playerMap = new HashMap<>();
        for (Player p : getPlayers()) {
            playerMap.put(p.getId(), p);
        }
        List<Roster> rosters = new ArrayList<>();
        for (SleeperRoster sr : sleeperRosters) {
            Roster roster = new Roster();
            Optional.ofNullable(sr.getRosterId())
                .map(Object::toString)
                .ifPresent(roster::setId);
            Optional.ofNullable(sr.getLeagueId())
                .ifPresent(roster::setLeagueId);
            Optional.ofNullable(sr.getOwnerId())
                .ifPresent(roster::setUserId);
            Optional.ofNullable(sr.getPlayers())
                .ifPresent(playerIds -> {
                    List<Player> players = new ArrayList<>();
                    for (String playerId : playerIds) {
                        Optional.ofNullable(playerMap.get(playerId))
                            .ifPresent(players::add);
                    }
                    roster.setPlayers(players);
                });
            Optional.ofNullable(sr.getSettings())
                .ifPresent(settings -> {
                    Optional.ofNullable(settings.getWins())
                        .ifPresent(roster::setWins);
                    Optional.ofNullable(settings.getLosses())
                        .ifPresent(roster::setLosses);
                });
            rosters.add(roster);
        }
        return rosters;
    }

    @Cacheable("users")
    public List<User> getUsers(String leagueId) throws IOException, InterruptedException {
        List<SleeperUser> sleeperUsers = Optional.ofNullable(sleeperClient.getUsers(leagueId))
            .orElse(new ArrayList<>());
        List<User> users = new ArrayList<>();
        for (SleeperUser su : sleeperUsers) {
            User user = new User();
            Optional.ofNullable(su.getUserId())
                .ifPresent(user::setId);
            Optional.ofNullable(su.getDisplayName())
                .ifPresent(user::setName);
            Optional.ofNullable(su.getMetadata())
                .map(v -> v.getTeamName())
                .ifPresent(user::setTeamName);
            users.add(user);
        }
        return users;
    }

    @Cacheable("players")
    public List<Player> getPlayers() throws IOException, InterruptedException {
        Map<String, SleeperPlayer> sleeperPlayers = Optional.ofNullable(sleeperClient.getPlayers("nfl"))
            .orElse(Map.of());
        List<Player> players = new ArrayList<>();
        for (SleeperPlayer sp : sleeperPlayers.values()) {
            Player player = new Player();
            Optional.ofNullable(sp.getPlayerId())
                .ifPresent(player::setId);
            Optional.ofNullable(sp.getFirstName())
                .ifPresent(player::setFirstName);
            Optional.ofNullable(sp.getLastName())
                .ifPresent(player::setLastName);
            Optional.ofNullable(sp.getFantasyPositions())
                .ifPresent(player::setPositions);
            Optional.ofNullable(sp.getTeam())
                .ifPresent(player::setTeam);
            Optional.ofNullable(sp.getNumber()).
                ifPresent(player::setNumber);
            players.add(player);
        }
        return players;
    }

}
