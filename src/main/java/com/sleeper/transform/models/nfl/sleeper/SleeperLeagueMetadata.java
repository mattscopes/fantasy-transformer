package com.sleeper.transform.models.nfl.sleeper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SleeperLeagueMetadata {
    
    private String autoContinue;
    private String continued;
    private String copyFromLeagueId;
    private String keeperDeadline;
    private String latestLeagueWinnerRosterId;
    private String trophyLoser;
    private String trophyLoserBackground;
    private String trophyLoserBannerText;
    
    public String getAutoContinue() {
        return autoContinue;
    }
    
    public void setAutoContinue(String autoContinue) {
        this.autoContinue = autoContinue;
    }
    
    public String getContinued() {
        return continued;
    }
    
    public void setContinued(String continued) {
        this.continued = continued;
    }
    
    public String getCopyFromLeagueId() {
        return copyFromLeagueId;
    }
    
    public void setCopyFromLeagueId(String copyFromLeagueId) {
        this.copyFromLeagueId = copyFromLeagueId;
    }
    
    public String getKeeperDeadline() {
        return keeperDeadline;
    }
    
    public void setKeeperDeadline(String keeperDeadline) {
        this.keeperDeadline = keeperDeadline;
    }
    
    public String getLatestLeagueWinnerRosterId() {
        return latestLeagueWinnerRosterId;
    }
    
    public void setLatestLeagueWinnerRosterId(String latestLeagueWinnerRosterId) {
        this.latestLeagueWinnerRosterId = latestLeagueWinnerRosterId;
    }
    
    public String getTrophyLoser() {
        return trophyLoser;
    }
    
    public void setTrophyLoser(String trophyLoser) {
        this.trophyLoser = trophyLoser;
    }
    
    public String getTrophyLoserBackground() {
        return trophyLoserBackground;
    }
    
    public void setTrophyLoserBackground(String trophyLoserBackground) {
        this.trophyLoserBackground = trophyLoserBackground;
    }
    
    public String getTrophyLoserBannerText() {
        return trophyLoserBannerText;
    }
    
    public void setTrophyLoserBannerText(String trophyLoserBannerText) {
        this.trophyLoserBannerText = trophyLoserBannerText;
    }
}
