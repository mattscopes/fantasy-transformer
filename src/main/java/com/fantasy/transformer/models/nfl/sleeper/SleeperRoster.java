package com.fantasy.transformer.models.nfl.sleeper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SleeperRoster {
    
    /*{
        "starters": ["2307", "2257", "4034", "147", "642", "4039", "515", "4149", "DET"],
        "settings":{
        "wins":5,
            "waiver_position":7,
            "waiver_budget_used":0,
            "total_moves":0,
            "ties":0,
            "losses":9,
            "fpts_decimal":78,
            "fpts_against_decimal":32,
            "fpts_against":1670,
            "fpts":1617
    },
        "roster_id":1,
        "reserve": [],
        "players": [
        "1046", "138", "147", "2257", "2307", "2319", "4034", "4039", "4040", "4149", "421", "515", "642", "745", "DET"],
        "owner_id":"188815879448829952",
        "league_id":"206827432160788480"
    }*/
    
    private List<String> coOwners;
    private List<String> keepers;
    private String leagueId;
    private SleeperRosterMetadata metadata;
    private String ownerId;
    private Object playerMap;
    private List<String> players;
    private List<String> reserve;
    private Integer rosterId;
    private SleeperRosterSettings settings;
    private List<String> starters;
    private List<String> taxi;
    
    public List<String> getCoOwners() {
        return coOwners;
    }
    
    public void setCoOwners(List<String> coOwners) {
        this.coOwners = coOwners;
    }
    
    public List<String> getKeepers() {
        return keepers;
    }
    
    public void setKeepers(List<String> keepers) {
        this.keepers = keepers;
    }
    
    public String getLeagueId() {
        return leagueId;
    }
    
    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }
    
    public SleeperRosterMetadata getMetadata() {
        return metadata;
    }
    
    public void setMetadata(SleeperRosterMetadata metadata) {
        this.metadata = metadata;
    }
    
    public String getOwnerId() {
        return ownerId;
    }
    
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    
    public Object getPlayerMap() {
        return playerMap;
    }
    
    public void setPlayerMap(Object playerMap) {
        this.playerMap = playerMap;
    }
    
    public List<String> getPlayers() {
        return players;
    }
    
    public void setPlayers(List<String> players) {
        this.players = players;
    }
    
    public List<String> getReserve() {
        return reserve;
    }
    
    public void setReserve(List<String> reserve) {
        this.reserve = reserve;
    }
    
    public Integer getRosterId() {
        return rosterId;
    }
    
    public void setRosterId(Integer rosterId) {
        this.rosterId = rosterId;
    }
    
    public SleeperRosterSettings getSettings() {
        return settings;
    }
    
    public void setSettings(SleeperRosterSettings settings) {
        this.settings = settings;
    }
    
    public List<String> getStarters() {
        return starters;
    }
    
    public void setStarters(List<String> starters) {
        this.starters = starters;
    }
    
    public List<String> getTaxi() {
        return taxi;
    }
    
    public void setTaxi(List<String> taxi) {
        this.taxi = taxi;
    }
}
