package com.sleeper.transform.models.sleeper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionSettings {
    
    private Integer seq;
    private Integer waiverBid;
    
    public Integer getSeq() {
        return seq;
    }
    
    public void setSeq(Integer seq) {
        this.seq = seq;
    }
    
}
