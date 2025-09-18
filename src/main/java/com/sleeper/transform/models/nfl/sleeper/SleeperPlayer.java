package com.sleeper.transform.models.nfl.sleeper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.Instant;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SleeperPlayer {
    
    /*{
        "hashtag": "#TomBrady-NFL-NE-12",
        "depth_chart_position": 1,
        "status": "Active",
        "sport": "nfl",
        "fantasy_positions": ["QB"],
        "number": 12,
        "search_last_name": "brady",
        "injury_start_date": null,
        "weight": "220",
        "position": "QB",
        "practice_participation": null,
        "sportradar_id": "",
        "team": "NE",
        "last_name": "Brady",
        "college": "Michigan",
        "fantasy_data_id":17836,
        "injury_status":null,
        "player_id":"3086",
        "height": "6'4\"",
        "search_full_name": "tombrady",
        "age": 40,
        "stats_id": "",
        "birth_country": "United States",
        "espn_id": "",
        "search_rank": 24,
        "first_name": "Tom",
        "depth_chart_order": 1,
        "years_exp": 14,
        "rotowire_id": null,
        "rotoworld_id": 8356,
        "search_first_name": "tom",
        "yahoo_id": null
    }*/
    
    private Integer searchRank;
    private String oddsjamId;
    private String gsisId;
    private String birthState;
    private Integer depthChartOrder;
    private Instant teamChangedAt;
    private Integer yahooId;
    private Integer number;
    private Integer age;
    private Boolean active;
    private String practiceDescription;
    private String injuryStatus;
    private Integer yearsExp;
    private String firstName;
    private String birthDate;
    private Integer espnId;
    private String injuryBodyPart;
    private List<String> competitions;
    private String injuryStartDate;
    private String practiceParticipation;
    private Integer fantasyDataId;
    private String optaId;
    private String status;
    private Instant newsUpdated;
    private String searchFirstName;
    private String sport;
    private String injuryNotes;
    private String searchLastName;
    private String weight;
    private String hashtag;
    private String fullName;
    private String birthCity;
    private Integer rotowireId;
    private String team;
    private String depthChartPosition;
    private SleeperPlayerMetadata metadata;
    private Integer swishId;
    private String birthCountry;
    private String teamAbbr;
    private String college;
    private String sportradarId;
    private String lastName;
    private String kalshiId;
    private Integer statsId;
    private String position;
    private String highSchool;
    private String height;
    private List<String> fantasyPositions;
    private Integer rotoworldId;
    private String playerId;
    private String searchFullName;
    private String pandascoreId;
    
    public Integer getSearchRank() {
        return searchRank;
    }
    
    public void setSearchRank(Integer searchRank) {
        this.searchRank = searchRank;
    }
    
    public String getOddsjamId() {
        return oddsjamId;
    }
    
    public void setOddsjamId(String oddsjamId) {
        this.oddsjamId = oddsjamId;
    }
    
    public String getGsisId() {
        return gsisId;
    }
    
    public void setGsisId(String gsisId) {
        this.gsisId = gsisId;
    }
    
    public String getBirthState() {
        return birthState;
    }
    
    public void setBirthState(String birthState) {
        this.birthState = birthState;
    }
    
    public Integer getDepthChartOrder() {
        return depthChartOrder;
    }
    
    public void setDepthChartOrder(Integer depthChartOrder) {
        this.depthChartOrder = depthChartOrder;
    }
    
    public Instant getTeamChangedAt() {
        return teamChangedAt;
    }
    
    public void setTeamChangedAt(Instant teamChangedAt) {
        this.teamChangedAt = teamChangedAt;
    }
    
    public Integer getYahooId() {
        return yahooId;
    }
    
    public void setYahooId(Integer yahooId) {
        this.yahooId = yahooId;
    }
    
    public Integer getNumber() {
        return number;
    }
    
    public void setNumber(Integer number) {
        this.number = number;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public Boolean getActive() {
        return active;
    }
    
    public void setActive(Boolean active) {
        this.active = active;
    }
    
    public String getPracticeDescription() {
        return practiceDescription;
    }
    
    public void setPracticeDescription(String practiceDescription) {
        this.practiceDescription = practiceDescription;
    }
    
    public String getInjuryStatus() {
        return injuryStatus;
    }
    
    public void setInjuryStatus(String injuryStatus) {
        this.injuryStatus = injuryStatus;
    }
    
    public Integer getYearsExp() {
        return yearsExp;
    }
    
    public void setYearsExp(Integer yearsExp) {
        this.yearsExp = yearsExp;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getBirthDate() {
        return birthDate;
    }
    
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    
    public Integer getEspnId() {
        return espnId;
    }
    
    public void setEspnId(Integer espnId) {
        this.espnId = espnId;
    }
    
    public String getInjuryBodyPart() {
        return injuryBodyPart;
    }
    
    public void setInjuryBodyPart(String injuryBodyPart) {
        this.injuryBodyPart = injuryBodyPart;
    }
    
    public List<String> getCompetitions() {
        return competitions;
    }
    
    public void setCompetitions(List<String> competitions) {
        this.competitions = competitions;
    }
    
    public String getInjuryStartDate() {
        return injuryStartDate;
    }
    
    public void setInjuryStartDate(String injuryStartDate) {
        this.injuryStartDate = injuryStartDate;
    }
    
    public String getPracticeParticipation() {
        return practiceParticipation;
    }
    
    public void setPracticeParticipation(String practiceParticipation) {
        this.practiceParticipation = practiceParticipation;
    }
    
    public Integer getFantasyDataId() {
        return fantasyDataId;
    }
    
    public void setFantasyDataId(Integer fantasyDataId) {
        this.fantasyDataId = fantasyDataId;
    }
    
    public String getOptaId() {
        return optaId;
    }
    
    public void setOptaId(String optaId) {
        this.optaId = optaId;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Instant getNewsUpdated() {
        return newsUpdated;
    }
    
    public void setNewsUpdated(Instant newsUpdated) {
        this.newsUpdated = newsUpdated;
    }
    
    public String getSearchFirstName() {
        return searchFirstName;
    }
    
    public void setSearchFirstName(String searchFirstName) {
        this.searchFirstName = searchFirstName;
    }
    
    public String getSport() {
        return sport;
    }
    
    public void setSport(String sport) {
        this.sport = sport;
    }
    
    public String getInjuryNotes() {
        return injuryNotes;
    }
    
    public void setInjuryNotes(String injuryNotes) {
        this.injuryNotes = injuryNotes;
    }
    
    public String getSearchLastName() {
        return searchLastName;
    }
    
    public void setSearchLastName(String searchLastName) {
        this.searchLastName = searchLastName;
    }
    
    public String getWeight() {
        return weight;
    }
    
    public void setWeight(String weight) {
        this.weight = weight;
    }
    
    public String getHashtag() {
        return hashtag;
    }
    
    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public String getBirthCity() {
        return birthCity;
    }
    
    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }
    
    public Integer getRotowireId() {
        return rotowireId;
    }
    
    public void setRotowireId(Integer rotowireId) {
        this.rotowireId = rotowireId;
    }
    
    public String getTeam() {
        return team;
    }
    
    public void setTeam(String team) {
        this.team = team;
    }
    
    public String getDepthChartPosition() {
        return depthChartPosition;
    }
    
    public void setDepthChartPosition(String depthChartPosition) {
        this.depthChartPosition = depthChartPosition;
    }
    
    public SleeperPlayerMetadata getMetadata() {
        return metadata;
    }
    
    public void setMetadata(SleeperPlayerMetadata metadata) {
        this.metadata = metadata;
    }
    
    public Integer getSwishId() {
        return swishId;
    }
    
    public void setSwishId(Integer swishId) {
        this.swishId = swishId;
    }
    
    public String getBirthCountry() {
        return birthCountry;
    }
    
    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }
    
    public String getTeamAbbr() {
        return teamAbbr;
    }
    
    public void setTeamAbbr(String teamAbbr) {
        this.teamAbbr = teamAbbr;
    }
    
    public String getCollege() {
        return college;
    }
    
    public void setCollege(String college) {
        this.college = college;
    }
    
    public String getSportradarId() {
        return sportradarId;
    }
    
    public void setSportradarId(String sportradarId) {
        this.sportradarId = sportradarId;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getKalshiId() {
        return kalshiId;
    }
    
    public void setKalshiId(String kalshiId) {
        this.kalshiId = kalshiId;
    }
    
    public Integer getStatsId() {
        return statsId;
    }
    
    public void setStatsId(Integer statsId) {
        this.statsId = statsId;
    }
    
    public String getPosition() {
        return position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    
    public String getHighSchool() {
        return highSchool;
    }
    
    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
    }
    
    public String getHeight() {
        return height;
    }
    
    public void setHeight(String height) {
        this.height = height;
    }
    
    public List<String> getFantasyPositions() {
        return fantasyPositions;
    }
    
    public void setFantasyPositions(List<String> fantasyPositions) {
        this.fantasyPositions = fantasyPositions;
    }
    
    public Integer getRotoworldId() {
        return rotoworldId;
    }
    
    public void setRotoworldId(Integer rotoworldId) {
        this.rotoworldId = rotoworldId;
    }
    
    public String getPlayerId() {
        return playerId;
    }
    
    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }
    
    public String getSearchFullName() {
        return searchFullName;
    }
    
    public void setSearchFullName(String searchFullName) {
        this.searchFullName = searchFullName;
    }
    
    public String getPandascoreId() {
        return pandascoreId;
    }
    
    public void setPandascoreId(String pandascoreId) {
        this.pandascoreId = pandascoreId;
    }
}
