package com.fantasysports.dashboard.models.sleeper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SleeperRosterMetadata {

    private String allowPnInactiveStarters;
    private String allowPnPlayerInjuryStatus;
    private String allowPnScoring;
    private String record;
    private String restrictPnScoringStartersOnly;
    private String streak;

    public String getAllowPnInactiveStarters() {
        return allowPnInactiveStarters;
    }

    public void setAllowPnInactiveStarters(String allowPnInactiveStarters) {
        this.allowPnInactiveStarters = allowPnInactiveStarters;
    }

    public String getAllowPnPlayerInjuryStatus() {
        return allowPnPlayerInjuryStatus;
    }

    public void setAllowPnPlayerInjuryStatus(String allowPnPlayerInjuryStatus) {
        this.allowPnPlayerInjuryStatus = allowPnPlayerInjuryStatus;
    }

    public String getAllowPnScoring() {
        return allowPnScoring;
    }

    public void setAllowPnScoring(String allowPnScoring) {
        this.allowPnScoring = allowPnScoring;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getRestrictPnScoringStartersOnly() {
        return restrictPnScoringStartersOnly;
    }

    public void setRestrictPnScoringStartersOnly(String restrictPnScoringStartersOnly) {
        this.restrictPnScoringStartersOnly = restrictPnScoringStartersOnly;
    }

    public String getStreak() {
        return streak;
    }

    public void setStreak(String streak) {
        this.streak = streak;
    }
}
