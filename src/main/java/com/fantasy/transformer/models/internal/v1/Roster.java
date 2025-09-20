package com.fantasy.transformer.models.internal.v1;

import java.util.List;

public class Roster {

    private String id;
    private League league;
    private User user;
    private String name;
    private Integer wins;
    private Integer losses;
    private List<Player> players;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Roster{" +
            "id='" + id + '\'' +
            ", league=" + league +
            ", user=" + user +
            ", name='" + name + '\'' +
            ", wins=" + wins +
            ", losses=" + losses +
            ", players=" + players +
            '}';
    }

}
