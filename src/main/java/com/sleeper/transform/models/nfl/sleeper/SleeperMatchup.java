package com.sleeper.transform.models.nfl.sleeper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SleeperMatchup {
    
    /*{
        "starters": ["421", "4035", "3242", "2133", "2449", "4531", "2257", "788", "PHI"],
        "roster_id": 1,
        "players": ["1352", "1387", "2118", "2133", "2182", "223", "2319", "2449", "3208", "4035", "421", "4881", "4892", "788", "CLE"],
        "matchup_id": 2,
        "points": 20.0 // total points for team based on league settings
        "custom_points": null // if commissioner overrides points manually
    }*/
    
    private Double points;
    private List<String> players;
    private Integer rosterId;
    private Double customPoints;
    private Integer matchupId;
    private List<String> starters;
    private List<Double> startersPoints;
    private Map<String, Double> playersPoints;
    
    public Double getPoints() {
        return points;
    }
    
    public void setPoints(Double points) {
        this.points = points;
    }
    
    public List<String> getPlayers() {
        return players;
    }
    
    public void setPlayers(List<String> players) {
        this.players = players;
    }
    
    public Integer getRosterId() {
        return rosterId;
    }
    
    public void setRosterId(Integer rosterId) {
        this.rosterId = rosterId;
    }
    
    public Double getCustomPoints() {
        return customPoints;
    }
    
    public void setCustomPoints(Double customPoints) {
        this.customPoints = customPoints;
    }
    
    public Integer getMatchupId() {
        return matchupId;
    }
    
    public void setMatchupId(Integer matchupId) {
        this.matchupId = matchupId;
    }
    
    public List<String> getStarters() {
        return starters;
    }
    
    public void setStarters(List<String> starters) {
        this.starters = starters;
    }
    
    public List<Double> getStartersPoints() {
        return startersPoints;
    }
    
    public void setStartersPoints(List<Double> startersPoints) {
        this.startersPoints = startersPoints;
    }
    
    public Map<String, Double> getPlayersPoints() {
        return playersPoints;
    }
    
    public void setPlayersPoints(Map<String, Double> playersPoints) {
        this.playersPoints = playersPoints;
    }
}
