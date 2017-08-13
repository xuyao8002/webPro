package com.springPro.entity;

public class UsTriggerFrequency {
    private String id;

    private String customerId;

    private Integer seconds;

    private Integer maxSend;

    private Integer times;

    private Byte status;

    private Byte type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }

    public Integer getMaxSend() {
        return maxSend;
    }

    public void setMaxSend(Integer maxSend) {
        this.maxSend = maxSend;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
}