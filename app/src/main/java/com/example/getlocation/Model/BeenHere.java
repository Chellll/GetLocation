package com.example.getlocation.Model;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class BeenHere {

    private Integer count;
    private Integer unconfirmedCount;
    private Boolean marked;
    private Integer lastCheckinExpiredAt;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getUnconfirmedCount() {
        return unconfirmedCount;
    }

    public void setUnconfirmedCount(Integer unconfirmedCount) {
        this.unconfirmedCount = unconfirmedCount;
    }

    public Boolean getMarked() {
        return marked;
    }

    public void setMarked(Boolean marked) {
        this.marked = marked;
    }

    public Integer getLastCheckinExpiredAt() {
        return lastCheckinExpiredAt;
    }

    public void setLastCheckinExpiredAt(Integer lastCheckinExpiredAt) {
        this.lastCheckinExpiredAt = lastCheckinExpiredAt;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}
