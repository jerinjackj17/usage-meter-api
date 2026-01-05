package com.jj.usagemeterapi.pricing;

import com.jj.usagemeterapi.domain.usage.UsageSummary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlatPricingService {

    private final double pricePerUnit;

    public FlatPricingService(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Map<String, Double> calculateCosts(List<UsageSummary> usageSummaries) {
        Map<String, Double> costs = new HashMap<>();

        for (UsageSummary usage : usageSummaries) {
            double cost = usage.getTotalUnits() * pricePerUnit;
            costs.put(usage.getApiKey(), cost);
        }

        return costs;
    }
}
