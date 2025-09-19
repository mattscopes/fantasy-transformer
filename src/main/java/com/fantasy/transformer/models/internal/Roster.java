package com.fantasy.transformer.models.internal;

import java.util.List;

public class Roster {

    private String id;
    private String leagueId;
    private String userId;
    private String name;
    private Integer season;
    private Integer wins;
    private Integer losses;
    private List<Player> players;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Roster{" +
            "id='" + id + '\'' +
            ", leagueId='" + leagueId + '\'' +
            ", userId='" + userId + '\'' +
            ", name='" + name + '\'' +
            ", season=" + season +
            ", wins=" + wins +
            ", losses=" + losses +
            ", players=" + players +
            '}';
    }
}
