package com.fantasy.transformer.models.internal;

import java.util.List;

public class League {

    private String name;
    private String season;
    private String sport;
    private List<Team> teams;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "League{" +
            ", name='" + name + '\'' +
            ", season='" + season + '\'' +
            ", sport='" + sport + '\'' +
            ", teams=" + teams +
            '}';
    }
}
