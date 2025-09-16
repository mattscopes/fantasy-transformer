package com.sleeper.transform.models.sleeper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RosterMetadata {
    
    private String record;
    private String streak;
    
    public String getRecord() {
        return record;
    }
    
    public void setRecord(String record) {
        this.record = record;
    }
    
    public String getStreak() {
        return streak;
    }
    
    public void setStreak(String streak) {
        this.streak = streak;
    }
}
