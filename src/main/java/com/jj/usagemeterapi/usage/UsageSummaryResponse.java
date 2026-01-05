package com.jj.usagemeterapi.usage;

import java.util.Map;

public class UsageSummaryResponse {

    private Map<String, Long> usageByApiKey;

    public UsageSummaryResponse(Map<String, Long> usageByApiKey) {
        this.usageByApiKey = usageByApiKey;
    }

    public Map<String, Long> getUsageByApiKey() {
        return usageByApiKey;
    }
}
