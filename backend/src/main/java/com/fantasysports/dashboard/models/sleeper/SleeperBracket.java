package com.fantasysports.dashboard.models.sleeper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SleeperBracket {
    
    /*[
        {r: 1, m: 1,   t1: 3,    t2: 6,     w: null, l: null},
        {r: 1, m: 2,   t1: 4,    t2: 5,     w: null, l: null},
        
        {r: 2, m: 3,   t1: 1,    t2: null,  t2_from: {w: 1},  w: null, l: null},
        {r: 2, m: 4,   t1: 2,    t2: null,  t2_from: {w: 2},  w: null, l: null},
        {r: 2, m: 5,   t1: null, t2: null,  t1_from: {l: 1},  t2_from: {l: 2},  w: null, l: null, p: 5},
        
        {r: 3, m: 6,   t1: null, t2: null,  t1_from: {w: 3},  t2_from: {w: 4},  w: null, l: null, p: 1},
        {r: 3, m: 7,   t1: null, t2: null,  t1_from: {l: 3},  t2_from: {l: 4},  w: null, l: null, p: 3}
    ]*/
    
    private Integer p; // placement (optional)
    private Integer r; // round
    private Integer m; // match id
    private Integer t1; // team 1 roster_id
    private Integer t2; // team 2 roster_id
    private SleeperFrom t1From; // source for team 1
    private SleeperFrom t2From; // source for team 2
    private Integer w; // winner roster_id
    private Integer l; // loser roster_id
    
    public Integer getP() {
        return p;
    }
    
    public void setP(Integer p) {
        this.p = p;
    }
    
    public Integer getR() {
        return r;
    }
    
    public void setR(Integer r) {
        this.r = r;
    }
    
    public Integer getM() {
        return m;
    }
    
    public void setM(Integer m) {
        this.m = m;
    }
    
    public Integer getT1() {
        return t1;
    }
    
    public void setT1(Integer t1) {
        this.t1 = t1;
    }
    
    public Integer getT2() {
        return t2;
    }
    
    public void setT2(Integer t2) {
        this.t2 = t2;
    }
    
    public SleeperFrom getT1From() {
        return t1From;
    }
    
    public void setT1From(SleeperFrom t1From) {
        this.t1From = t1From;
    }
    
    public SleeperFrom getT2From() {
        return t2From;
    }
    
    public void setT2From(SleeperFrom t2From) {
        this.t2From = t2From;
    }
    
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
