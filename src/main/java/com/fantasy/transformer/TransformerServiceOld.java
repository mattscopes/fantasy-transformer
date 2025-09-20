package com.fantasy.transformer;

import com.fantasy.transformer.models.internal.v1.League;
import com.fantasy.transformer.models.internal.v1.Player;
import com.fantasy.transformer.models.internal.v1.Roster;
import com.fantasy.transformer.models.internal.v1.User;
import com.fantasy.transformer.models.sleeper.SleeperLeague;
import com.fantasy.transformer.models.sleeper.SleeperPlayer;
import com.fantasy.transformer.models.sleeper.SleeperRoster;
import com.fantasy.transformer.models.sleeper.SleeperUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TransformerServiceOld {

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
            .orElse(Collections.emptyList());
        // Fetch all players once and map by ID
        Map<String, Player> playerMap = Optional.ofNullable(getPlayers())
            .orElse(Collections.emptyList())
            .stream()
            .filter(Objects::nonNull)
            .collect(Collectors.toMap(Player::getId, p -> p));

        League league = getLeague(leagueId);
        Map<String, User> userMap = Optional.ofNullable(getUsers(leagueId))
            .orElse(Collections.emptyList())
            .stream()
            .filter(Objects::nonNull)
            .collect(Collectors.toMap(User::getId, u -> u));

        List<Roster> rosters = Optional.ofNullable(sleeperRosters)
            .orElse(Collections.emptyList())
            .stream()
            .filter(Objects::nonNull)
            .map(sr -> {
                Roster roster = new Roster();
                Optional.ofNullable(sr.getRosterId())
                    .map(Object::toString)
                    .ifPresent(roster::setId);
                Optional.ofNullable(league)
                        .ifPresent(roster::setLeague);
                Optional.ofNullable(sr.getOwnerId())
                    .map(userMap::get)
                    .ifPresent(roster::setUser);
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
                return roster;
            })
            .collect(Collectors.toList());

        return rosters;


//        List<SleeperRoster> sleeperRosters = Optional.ofNullable(sleeperClient.getRosters(leagueId))
//            .orElse(new ArrayList<>());
//        // Fetch all players once and map by ID
//        Map<String, Player> playerMap = new HashMap<>();
//        for (Player p : getPlayers()) {
//            playerMap.put(p.getId(), p);
//        }
//        // Fetch league and users
//        League league = getLeague(leagueId);
//        List<User> users = getUsers(leagueId);
//        Map<String, User> userMap = new HashMap<>();
//        for (User u : users) {
//            userMap.put(u.getId(), u);
//        }
//        List<Roster> rosters = new ArrayList<>();
//        for (SleeperRoster sr : sleeperRosters) {
//            Roster roster = new Roster();
//            Optional.ofNullable(sr.getRosterId())
//                .map(Object::toString)
//                .ifPresent(roster::setId);
//            Optional.ofNullable(league)
//                    .ifPresent(roster::setLeague);
//            Optional.ofNullable(sr.getOwnerId())
//                .map(userMap::get)
//                .ifPresent(roster::setUser);
//            Optional.ofNullable(sr.getPlayers())
//                .ifPresent(playerIds -> {
//                    List<Player> players = new ArrayList<>();
//                    for (String playerId : playerIds) {
//                        Optional.ofNullable(playerMap.get(playerId))
//                            .ifPresent(players::add);
//                    }
//                    roster.setPlayers(players);
//                });
//            Optional.ofNullable(sr.getSettings())
//                .ifPresent(settings -> {
//                    Optional.ofNullable(settings.getWins())
//                        .ifPresent(roster::setWins);
//                    Optional.ofNullable(settings.getLosses())
//                        .ifPresent(roster::setLosses);
//                });
//            rosters.add(roster);
//        }
//        return rosters;
    }

    @Cacheable("users")
    public List<User> getUsers(String leagueId) throws IOException, InterruptedException {
        List<SleeperUser> sleeperUsers = Optional.ofNullable(sleeperClient.getUsers(leagueId))
            .orElse(Collections.emptyList());

        List<User> users = Optional.ofNullable(sleeperUsers)
            .orElse(Collections.emptyList())
            .stream()
            .filter(Objects::nonNull)
            .map(su -> {
                User user = new User();
                Optional.ofNullable(su.getUserId())
                    .ifPresent(user::setId);
                Optional.ofNullable(su.getDisplayName())
                    .ifPresent(user::setName);
                Optional.ofNullable(su.getMetadata())
                    .map(meta -> meta.getTeamName())
                    .ifPresent(user::setTeamName);
                return user;
            })
            .collect(Collectors.toList());

        return users.isEmpty() ? null : users;
    }


    @Cacheable("players")
    public List<Player> getPlayers() throws IOException, InterruptedException {
        Map<String, SleeperPlayer> sleeperPlayers = Optional.ofNullable(sleeperClient.getPlayers("nfl"))
            .orElse(Map.of());

        List<Players> players = Optional.ofNullable(sleeperPlayers)
            .map(Map::values)
            .orElse(Collections.emptyList())
            .stream()
            .filter(Objects::nonNull)
            .map(sp -> {
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
                Optional.ofNullable(sp.getNumber())
                    .ifPresent(player::setNumber);
                return player;
            })
            .collect(Collectors.toList());

        return players.isEmpty() ? null : users;
    }

}
