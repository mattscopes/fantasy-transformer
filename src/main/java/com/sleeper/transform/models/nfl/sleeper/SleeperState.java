package com.sleeper.transform.models.nfl.sleeper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SleeperState {
    
    /*{
        "week": 2, // week
        "season_type": "regular", // pre, post, regular
        "season_start_date": "2020-09-10", // regular season start
        "season": "2020", // current season
        "previous_season": "2019",
        "leg": 2, // week of regular season
        "league_season": "2021", // active season for leagues
        "league_create_season": "2021", // flips in December
        "display_week": 3 // Which week to display in UI, can be different than week
    }*/
    
    private Integer week;
    private Integer leg;
    private String season;
    private String seasonType;
    private String leagueSeason;
    private String previousSeason;
    private String seasonStartDate;
    private Integer displayWeek;
    private String leagueCreateSeason;
    private Boolean seasonHasScores;
    
    
    public int getWeek() {
        return week;
    }
    
    public void setWeek(int week) {
        this.week = week;
    }
    
    public int getLeg() {
        return leg;
    }
    
    public void setLeg(int leg) {
        this.leg = leg;
    }
    
    public String getSeason() {
        return season;
    }
    
    public void setSeason(String season) {
        this.season = season;
    }
    
    public String getSeasonType() {
        return seasonType;
    }
    
    public void setSeasonType(String seasonType) {
        this.seasonType = seasonType;
    }
    
    public String getLeagueSeason() {
        return leagueSeason;
    }
    
    public void setLeagueSeason(String leagueSeason) {
        this.leagueSeason = leagueSeason;
    }
    
    public String getPreviousSeason() {
        return previousSeason;
    }
    
    public void setPreviousSeason(String previousSeason) {
        this.previousSeason = previousSeason;
    }
    
    public String getSeasonStartDate() {
        return seasonStartDate;
    }
    
    public void setSeasonStartDate(String seasonStartDate) {
        this.seasonStartDate = seasonStartDate;
    }
    
    public int getDisplayWeek() {
        return displayWeek;
    }
    
    public void setDisplayWeek(int displayWeek) {
        this.displayWeek = displayWeek;
    }
    
    public String getLeagueCreateSeason() {
        return leagueCreateSeason;
    }
    
    public void setLeagueCreateSeason(String leagueCreateSeason) {
        this.leagueCreateSeason = leagueCreateSeason;
    }
    
    public boolean isSeasonHasScores() {
        return seasonHasScores;
    }
    
    public void setSeasonHasScores(boolean seasonHasScores) {
        this.seasonHasScores = seasonHasScores;
    }
    
}
