package com.example.getlocation.data.models.api;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Stats {

    private Integer checkinsCount;
    private Integer usersCount;
    private Integer tipCount;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getCheckinsCount() {
        return checkinsCount;
    }

    public void setCheckinsCount(Integer checkinsCount) {
        this.checkinsCount = checkinsCount;
    }

    public Integer getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(Integer usersCount) {
        this.usersCount = usersCount;
    }

    public Integer getTipCount() {
        return tipCount;
    }

    public void setTipCount(Integer tipCount) {
        this.tipCount = tipCount;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}
