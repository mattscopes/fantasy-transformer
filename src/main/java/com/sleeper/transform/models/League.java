package com.sleeper.transform.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class League {
    
    /*{
        "total_rosters": 12,
        "status": "in_season",
        "sport": "nfl",
        "settings": { settings object },
        "season_type": "regular",
        "season": "2018",
        "scoring_settings": { scoring_settings object },
        "roster_positions": [ roster positions array ],
        "previous_league_id": "198946952535085056",
        "name": "Sleeperbot Dynasty",
        "league_id": "289646328504385536",
        "draft_id": "289646328508579840",
        "avatar": "efaefa889ae24046a53265a3c71b8b64"
    }*/
    
    private Integer totalRosters;
    private String status;
    private String sport;
    private JsonNode settings;
    private String seasonType;
    private String season;
    private JsonNode scoringSettings;
    private List<String> rosterPositions;
    private String previousLeagueId;
    private String name;
    private String leagueId;
    private String draftId;
    private String avatar;
    
    public Integer getTotalRosters() {
        return totalRosters;
    }
    
    public void setTotalRosters(Integer totalRosters) {
        this.totalRosters = totalRosters;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getSport() {
        return sport;
    }
    
    public void setSport(String sport) {
        this.sport = sport;
    }
    
    public JsonNode getSettings() {
        return settings;
    }
    
    public void setSettings(JsonNode settings) {
        this.settings = settings;
    }
    
    public String getSeasonType() {
        return seasonType;
    }
    
    public void setSeasonType(String seasonType) {
        this.seasonType = seasonType;
    }
    
    public String getSeason() {
        return season;
    }
    
    public void setSeason(String season) {
        this.season = season;
    }
    
    public JsonNode getScoringSettings() {
        return scoringSettings;
    }
    
    public void setScoringSettings(JsonNode scoringSettings) {
        this.scoringSettings = scoringSettings;
    }
    
    public List<String> getRosterPositions() {
        return rosterPositions;
    }
    
    public void setRosterPositions(List<String> rosterPositions) {
        this.rosterPositions = rosterPositions;
    }
    
    public String getPreviousLeagueId() {
        return previousLeagueId;
    }
    
    public void setPreviousLeagueId(String previousLeagueId) {
        this.previousLeagueId = previousLeagueId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getLeagueId() {
        return leagueId;
    }
    
    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }
    
    public String getDraftId() {
        return draftId;
    }
    
    public void setDraftId(String draftId) {
        this.draftId = draftId;
    }
    
    public String getAvatar() {
        return avatar;
    }
    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
