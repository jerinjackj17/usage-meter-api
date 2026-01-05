package com.jj.usagemeterapi.domain.usage;

public class UsageSummary {

    private String apiKey;
    private long totalUnits;

    public UsageSummary(String apiKey, long totalUnits) {
        this.apiKey = apiKey;
        this.totalUnits = totalUnits;
    }

    public String getApiKey() {
        return apiKey;
    }

    public long getTotalUnits() {
        return totalUnits;
    }
}
