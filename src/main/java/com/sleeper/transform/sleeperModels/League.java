package com.sleeper.transform.sleeperModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class League {
    
    /*{
        "total_rosters": 12,
        "status": "in_season",
        "sport": "nfl",
        "settings": { settings object },
        "season_type": "regular",
        "season": "2018",
        "scoring_settings": { scoring_settings object },
        "roster_positions": [ roster positions array ],
        "previous_league_id": "198946952535085056",
        "name": "Sleeperbot Dynasty",
        "league_id": "289646328504385536",
        "draft_id": "289646328508579840",
        "avatar": "efaefa889ae24046a53265a3c71b8b64"
    }*/
    
    private String name;
    private String status;
    private LeagueMetadata metadata;
    private LeagueSettings settings;
    private String avatar;
    private String companyId;
    private ScoringSettings scoringSettings;
    private String season;
    private String seasonType;
    private String sport;
    private Integer shard;
    private String lastMessageId;
    private String draftId;
    private String leagueId;
    private String lastAuthorAvatar;
    private String lastAuthorDisplayName;
    private String lastAuthorId;
    private Boolean lastAuthorIsBot;
    private String lastMessageAttachment;
    private String lastMessageTextMap;
    private Long lastMessageTime;
    private String lastPinnedMessageId;
    private String lastReadId;
    private String previousLeagueId;
    private List<String> rosterPositions;
    private String groupId;
    private Long bracketId;
    private String bracketOverridesId;
    private Long loserBracketId;
    private String loserBracketOverridesId;
    private Integer totalRosters;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public LeagueMetadata getMetadata() {
        return metadata;
    }
    
    public void setMetadata(LeagueMetadata metadata) {
        this.metadata = metadata;
    }
    
    public LeagueSettings getSettings() {
        return settings;
    }
    
    public void setSettings(LeagueSettings settings) {
        this.settings = settings;
    }
    
    public String getAvatar() {
        return avatar;
    }
    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    public String getCompanyId() {
        return companyId;
    }
    
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
    
    public ScoringSettings getScoringSettings() {
        return scoringSettings;
    }
    
    public void setScoringSettings(ScoringSettings scoringSettings) {
        this.scoringSettings = scoringSettings;
    }
    
    public String getSeason() {
        return season;
    }
    
    public void setSeason(String season) {
        this.season = season;
    }
    
    public String getSeasonType() {
        return seasonType;
    }
    
    public void setSeasonType(String seasonType) {
        this.seasonType = seasonType;
    }
    
    public String getSport() {
        return sport;
    }
    
    public void setSport(String sport) {
        this.sport = sport;
    }
    
    public Integer getShard() {
        return shard;
    }
    
    public void setShard(Integer shard) {
        this.shard = shard;
    }
    
    public String getLastMessageId() {
        return lastMessageId;
    }
    
    public void setLastMessageId(String lastMessageId) {
        this.lastMessageId = lastMessageId;
    }
    
    public String getDraftId() {
        return draftId;
    }
    
    public void setDraftId(String draftId) {
        this.draftId = draftId;
    }
    
    public String getLeagueId() {
        return leagueId;
    }
    
    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }
    
    public String getLastAuthorAvatar() {
        return lastAuthorAvatar;
    }
    
    public void setLastAuthorAvatar(String lastAuthorAvatar) {
        this.lastAuthorAvatar = lastAuthorAvatar;
    }
    
    public String getLastAuthorDisplayName() {
        return lastAuthorDisplayName;
    }
    
    public void setLastAuthorDisplayName(String lastAuthorDisplayName) {
        this.lastAuthorDisplayName = lastAuthorDisplayName;
    }
    
    public String getLastAuthorId() {
        return lastAuthorId;
    }
    
    public void setLastAuthorId(String lastAuthorId) {
        this.lastAuthorId = lastAuthorId;
    }
    
    public Boolean getLastAuthorIsBot() {
        return lastAuthorIsBot;
    }
    
    public void setLastAuthorIsBot(Boolean lastAuthorIsBot) {
        this.lastAuthorIsBot = lastAuthorIsBot;
    }
    
    public String getLastMessageAttachment() {
        return lastMessageAttachment;
    }
    
    public void setLastMessageAttachment(String lastMessageAttachment) {
        this.lastMessageAttachment = lastMessageAttachment;
    }
    
    public String getLastMessageTextMap() {
        return lastMessageTextMap;
    }
    
    public void setLastMessageTextMap(String lastMessageTextMap) {
        this.lastMessageTextMap = lastMessageTextMap;
    }
    
    public Long getLastMessageTime() {
        return lastMessageTime;
    }
    
    public void setLastMessageTime(Long lastMessageTime) {
        this.lastMessageTime = lastMessageTime;
    }
    
    public String getLastPinnedMessageId() {
        return lastPinnedMessageId;
    }
    
    public void setLastPinnedMessageId(String lastPinnedMessageId) {
        this.lastPinnedMessageId = lastPinnedMessageId;
    }
    
    public String getLastReadId() {
        return lastReadId;
    }
    
    public void setLastReadId(String lastReadId) {
        this.lastReadId = lastReadId;
    }
    
    public String getPreviousLeagueId() {
        return previousLeagueId;
    }
    
    public void setPreviousLeagueId(String previousLeagueId) {
        this.previousLeagueId = previousLeagueId;
    }
    
    public List<String> getRosterPositions() {
        return rosterPositions;
    }
    
    public void setRosterPositions(List<String> rosterPositions) {
        this.rosterPositions = rosterPositions;
    }
    
    public String getGroupId() {
        return groupId;
    }
    
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    
    public Long getBracketId() {
        return bracketId;
    }
    
    public void setBracketId(Long bracketId) {
        this.bracketId = bracketId;
    }
    
    public String getBracketOverridesId() {
        return bracketOverridesId;
    }
    
    public void setBracketOverridesId(String bracketOverridesId) {
        this.bracketOverridesId = bracketOverridesId;
    }
    
    public Long getLoserBracketId() {
        return loserBracketId;
    }
    
    public void setLoserBracketId(Long loserBracketId) {
        this.loserBracketId = loserBracketId;
    }
    
    public String getLoserBracketOverridesId() {
        return loserBracketOverridesId;
    }
    
    public void setLoserBracketOverridesId(String loserBracketOverridesId) {
        this.loserBracketOverridesId = loserBracketOverridesId;
    }
    
    public Integer getTotalRosters() {
        return totalRosters;
    }
    
    public void setTotalRosters(Integer totalRosters) {
        this.totalRosters = totalRosters;
    }
}
