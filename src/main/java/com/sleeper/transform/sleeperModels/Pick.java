package com.sleeper.transform.sleeperModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pick {
    
    private Integer round;
    private String season;
    private Integer rosterId;
    private Integer ownerId;
    private Integer previousOwnerId;
    
    public Integer getRound() {
        return round;
    }
    
    public void setRound(Integer round) {
        this.round = round;
    }
    
    public String getSeason() {
        return season;
    }
    
    public void setSeason(String season) {
        this.season = season;
    }
    
    public Integer getRosterId() {
        return rosterId;
    }
    
    public void setRosterId(Integer rosterId) {
        this.rosterId = rosterId;
    }
    
    public Integer getOwnerId() {
        return ownerId;
    }
    
    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
    
    public Integer getPreviousOwnerId() {
        return previousOwnerId;
    }
    
    public void setPreviousOwnerId(Integer previousOwnerId) {
        this.previousOwnerId = previousOwnerId;
    }
    
}
