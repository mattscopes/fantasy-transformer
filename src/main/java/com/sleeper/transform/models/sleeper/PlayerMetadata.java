package com.sleeper.transform.models.sleeper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerMetadata {
    
    private String channelId;
    private String rookieYear;
    
    public String getChannelId() {
        return channelId;
    }
    
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
    
    public String getRookieYear() {
        return rookieYear;
    }
    
    public void setRookieYear(String rookieYear) {
        this.rookieYear = rookieYear;
    }
    
}
