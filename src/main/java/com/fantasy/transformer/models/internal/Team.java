package com.fantasy.transformer.models.internal;
import java.util.List;

public class Team {

    private String name;
    private Integer wins;
    private Integer losses;
    private Integer ties;
    private List<Player> starters;
    private List<Player> reserves;
    private List<Player> taxis;
    private List<Player> bench;

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

    public Integer getTies() {
        return ties;
    }

    public void setTies(Integer ties) {
        this.ties = ties;
    }

    public List<Player> getStarters() {
        return starters;
    }

    public void setStarters(List<Player> starters) {
        this.starters = starters;
    }

    public List<Player> getReserves() {
        return reserves;
    }

    public void setReserves(List<Player> reserves) {
        this.reserves = reserves;
    }

    public List<Player> getTaxis() {
        return taxis;
    }

    public void setTaxis(List<Player> taxis) {
        this.taxis = taxis;
    }

    public List<Player> getBench() {
        return bench;
    }

    public void setBench(List<Player> bench) {
        this.bench = bench;
    }

    @Override
    public String toString() {
        return "Team{" +
            "name='" + name + '\'' +
            ", wins=" + wins +
            ", losses=" + losses +
            ", ties=" + ties +
            ", starters=" + starters +
            ", reserves=" + reserves +
            ", taxis=" + taxis +
            ", bench=" + bench +
            '}';
    }
}
