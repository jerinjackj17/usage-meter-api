package com.jj.usagemeterapi.usage;

public class UsageEventRequest {

    private String apiKey;
    private String endpoint;
    private long unitsUsed;

    public String getApiKey() {
        return apiKey;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public long getUnitsUsed() {
        return unitsUsed;
    }
}
