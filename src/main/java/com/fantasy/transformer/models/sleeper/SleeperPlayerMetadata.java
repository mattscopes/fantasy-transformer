package com.fantasy.transformer.models.sleeper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SleeperPlayerMetadata {
    
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
