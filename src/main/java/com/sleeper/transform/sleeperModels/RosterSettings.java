package com.sleeper.transform.sleeperModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RosterSettings {
    
    private Integer fpts;
    private Integer fptsAgainst;
    private Integer fptsAgainstDecimal;
    private Integer fptsDecimal;
    private Integer losses;
    private Integer ppts;
    private Integer pptsDecimal;
    private Integer ties;
    private Integer totalMoves;
    private Integer waiverBudgetUsed;
    private Integer waiverPosition;
    private Integer wins;
    
    public Integer getFpts() {
        return fpts;
    }
    
    public void setFpts(Integer fpts) {
        this.fpts = fpts;
    }
    
    public Integer getFptsAgainst() {
        return fptsAgainst;
    }
    
    public void setFptsAgainst(Integer fptsAgainst) {
        this.fptsAgainst = fptsAgainst;
    }
    
    public Integer getFptsAgainstDecimal() {
        return fptsAgainstDecimal;
    }
    
    public void setFptsAgainstDecimal(Integer fptsAgainstDecimal) {
        this.fptsAgainstDecimal = fptsAgainstDecimal;
    }
    
    public Integer getFptsDecimal() {
        return fptsDecimal;
    }
    
    public void setFptsDecimal(Integer fptsDecimal) {
        this.fptsDecimal = fptsDecimal;
    }
    
    public Integer getLosses() {
        return losses;
    }
    
    public void setLosses(Integer losses) {
        this.losses = losses;
    }
    
    public Integer getPpts() {
        return ppts;
    }
    
    public void setPpts(Integer ppts) {
        this.ppts = ppts;
    }
    
    public Integer getPptsDecimal() {
        return pptsDecimal;
    }
    
    public void setPptsDecimal(Integer pptsDecimal) {
        this.pptsDecimal = pptsDecimal;
    }
    
    public Integer getTies() {
        return ties;
    }
    
    public void setTies(Integer ties) {
        this.ties = ties;
    }
    
    public Integer getTotalMoves() {
        return totalMoves;
    }
    
    public void setTotalMoves(Integer totalMoves) {
        this.totalMoves = totalMoves;
    }
    
    public Integer getWaiverBudgetUsed() {
        return waiverBudgetUsed;
    }
    
    public void setWaiverBudgetUsed(Integer waiverBudgetUsed) {
        this.waiverBudgetUsed = waiverBudgetUsed;
    }
    
    public Integer getWaiverPosition() {
        return waiverPosition;
    }
    
    public void setWaiverPosition(Integer waiverPosition) {
        this.waiverPosition = waiverPosition;
    }
    
    public Integer getWins() {
        return wins;
    }
    
    public void setWins(Integer wins) {
        this.wins = wins;
    }
}
