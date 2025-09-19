package com.fantasy.transformer.models.sleeper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SleeperTrendingPlayer {
    
    /*{
        "player_id": "1111", // the player_id
        "count": 45         // number or adds
    }*/
    
    private String playerId;
    private Integer count;
    
    public String getPlayerId() {
        return playerId;
    }
    
    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }
    
    public Integer getCount() {
        return count;
    }
    
    public void setCount(Integer count) {
        this.count = count;
    }
}
