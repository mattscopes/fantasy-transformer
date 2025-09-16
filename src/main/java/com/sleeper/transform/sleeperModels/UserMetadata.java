package com.sleeper.transform.sleeperModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserMetadata {
    
    private String allowPn;
    private String avatar;
    private String mentionPn;
    private String teamName;
    
    public String getAllowPn() {
        return allowPn;
    }
    
    public void setAllowPn(String allowPn) {
        this.allowPn = allowPn;
    }
    
    public String getAvatar() {
        return avatar;
    }
    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    public String getMentionPn() {
        return mentionPn;
    }
    
    public void setMentionPn(String mentionPn) {
        this.mentionPn = mentionPn;
    }
    
    public String getTeamName() {
        return teamName;
    }
    
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    
}
