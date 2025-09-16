package com.sleeper.transform.models.sleeper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class From {
    
    private Integer w; // winner match id
    private Integer l; // loser match id
    
    public Integer getW() {
        return w;
    }
    
    public void setW(Integer w) {
        this.w = w;
    }
    
    public Integer getL() {
        return l;
    }
    
    public void setL(Integer l) {
        this.l = l;
    }
}
