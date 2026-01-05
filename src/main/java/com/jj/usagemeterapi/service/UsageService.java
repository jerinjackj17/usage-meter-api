package com.jj.usagemeterapi.service;

import com.jj.usagemeterapi.domain.usage.UsageEvent;
import com.jj.usagemeterapi.domain.usage.UsageSummary;
import com.jj.usagemeterapi.usage.UsageStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UsageService {

    private final UsageStore usageStore;

    public UsageService(UsageStore usageStore) {
        this.usageStore = usageStore;
    }

    public void recordUsage(UsageEvent event) {
        usageStore.record(event);
    }

    public List<UsageEvent> getAllUsage() {
        return usageStore.getAll();
    }

    public List<UsageSummary> summarizeByApiKey() {
        return usageStore.summarizeByApiKey();
    }

}
