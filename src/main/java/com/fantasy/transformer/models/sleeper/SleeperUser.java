package com.fantasy.transformer.models.sleeper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SleeperUser {
    
    /*{
        "user_id":"<user_id>",
        "username":"<username>",
        "display_name":"<display_name>",
        "avatar":"1233456789",
        "metadata":{
          "team_name":"Dezpacito"
        },
        "is_owner":true   // is commissioner (there can be multiple commissioners)
      }*/
    
    private String avatar;
    private String displayName;
    private Boolean isBot;
    private Boolean isOwner;
    private String leagueId;
    private SleeperUserMetadata metadata;
    private Object settings;
    private String userId;
    
    public String getAvatar() {
        return avatar;
    }
    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    
    public Boolean getBot() {
        return isBot;
    }
    
    public void setBot(Boolean bot) {
        isBot = bot;
    }
    
    public Boolean getOwner() {
        return isOwner;
    }
    
    public void setOwner(Boolean owner) {
        isOwner = owner;
    }
    
    public String getLeagueId() {
        return leagueId;
    }
    
    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }
    
    public SleeperUserMetadata getMetadata() {
        return metadata;
    }
    
    public void setMetadata(SleeperUserMetadata metadata) {
        this.metadata = metadata;
    }
    
    public Object getSettings() {
        return settings;
    }
    
    public void setSettings(Object settings) {
        this.settings = settings;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
