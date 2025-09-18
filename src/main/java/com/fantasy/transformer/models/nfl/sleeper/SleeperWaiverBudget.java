package com.fantasy.transformer.models.nfl.sleeper;

public class SleeperWaiverBudget {
    
    private Integer sender;
    private Integer receiver;
    private Integer amount;
    
    public Integer getSender() {
        return sender;
    }
    
    public void setSender(Integer sender) {
        this.sender = sender;
    }
    
    public Integer getReceiver() {
        return receiver;
    }
    
    public void setReceiver(Integer receiver) {
        this.receiver = receiver;
    }
    
    public Integer getAmount() {
        return amount;
    }
    
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
