package com.jj.usagemeterapi.usage;

import com.jj.usagemeterapi.domain.usage.UsageEvent;
import com.jj.usagemeterapi.domain.usage.UsageSummary;
import org.springframework.stereotype.Component;
import com.jj.usagemeterapi.repository.UsageEventRepository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UsageStore {

    private final UsageEventRepository repository;

    public UsageStore(UsageEventRepository repository) {
        this.repository = repository;
    }

    public void record(UsageEvent event) {
        repository.save(event);
    }

    public List<UsageEvent> getAll() {
        return repository.findAll();
    }

    public List<UsageSummary> summarizeByApiKey() {
        return repository.summarizeUsageByApiKey();
    }




}
