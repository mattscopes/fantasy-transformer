package com.fantasysports.dashboard.models.sleeper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SleeperTransaction {
    
    /*{
        "type":"trade",
        "transaction_id":"434852362033561600",
        "status_updated":1558039402803,
        "status":"complete",
        "settings":null,     // trades do not use this field
        "roster_ids": [2, 1], // roster_ids involved in this transaction
        "metadata":null,
        "leg":1,         // in football, this is the week
        "drops":null,
        "draft_picks": [  // picks that were traded
        {
            "season":"2019",// the season this draft pick belongs to
            "round":5,      // which round this draft pick is
            "roster_id":1,  // original owner's roster_id
            "previous_owner_id":1,  // previous owner's roster id (in this trade)
            "owner_id":2,   // the new owner of this pick after the trade
        },
        {
            "season":"2019",
            "round":3,
            "roster_id":2,
            "previous_owner_id":2,
            "owner_id":1,
        }
    ],
        "creator":"160000000000000000",  // user id who initiated the transaction
        "created":1558039391576,
        "consenter_ids": [2, 1], // roster_ids of the people who agreed to this transaction
        "adds":null
        "waiver_budget": [   // roster_id 2 sends 55 FAAB dollars to roster_id 3
        {
            "sender":2,
            "receiver":3,
            "amount":55
        }
    ],
    }*/
    
    private String status;
    private String type;
    private SleeperTransactionMetadata metadata;
    private Instant created;
    private SleeperTransactionSettings settings;
    private Integer leg;
    private List<SleeperPick> draftPicks;
    private String creator;
    private String transactionId;
    private Map<String, Integer> adds;
    private Map<String, Integer> drops;
    private List<Integer> consenterIds;
    private List<Integer> rosterIds;
    private Instant statusUpdated;
    private List<SleeperWaiverBudget> waiverBudget;
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public SleeperTransactionMetadata getMetadata() {
        return metadata;
    }
    
    public void setMetadata(SleeperTransactionMetadata metadata) {
        this.metadata = metadata;
    }
    
    public Instant getCreated() {
        return created;
    }
    
    public void setCreated(Instant created) {
        this.created = created;
    }
    
    public SleeperTransactionSettings getSettings() {
        return settings;
    }
    
    public void setSettings(SleeperTransactionSettings settings) {
        this.settings = settings;
    }
    
    public Integer getLeg() {
        return leg;
    }
    
    public void setLeg(Integer leg) {
        this.leg = leg;
    }
    
    public List<SleeperPick> getDraftPicks() {
        return draftPicks;
    }
    
    public void setDraftPicks(List<SleeperPick> draftPicks) {
        this.draftPicks = draftPicks;
    }
    
    public String getCreator() {
        return creator;
    }
    
    public void setCreator(String creator) {
        this.creator = creator;
    }
    
    public String getTransactionId() {
        return transactionId;
    }
    
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    
    public Map<String, Integer> getAdds() {
        return adds;
    }
    
    public void setAdds(Map<String, Integer> adds) {
        this.adds = adds;
    }
    
    public Map<String, Integer> getDrops() {
        return drops;
    }
    
    public void setDrops(Map<String, Integer> drops) {
        this.drops = drops;
    }
    
    public List<Integer> getConsenterIds() {
        return consenterIds;
    }
    
    public void setConsenterIds(List<Integer> consenterIds) {
        this.consenterIds = consenterIds;
    }
    
    public List<Integer> getRosterIds() {
        return rosterIds;
    }
    
    public void setRosterIds(List<Integer> rosterIds) {
        this.rosterIds = rosterIds;
    }
    
    public Instant getStatusUpdated() {
        return statusUpdated;
    }
    
    public void setStatusUpdated(Instant statusUpdated) {
        this.statusUpdated = statusUpdated;
    }
    
    public List<SleeperWaiverBudget> getWaiverBudget() {
        return waiverBudget;
    }
    
    public void setWaiverBudget(List<SleeperWaiverBudget> waiverBudget) {
        this.waiverBudget = waiverBudget;
    }
}
