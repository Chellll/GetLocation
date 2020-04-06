package com.example.getlocation.data.models.api;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Photo_ {

    private String prefix;
    private String suffix;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}
