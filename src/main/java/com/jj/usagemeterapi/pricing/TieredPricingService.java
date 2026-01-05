package com.jj.usagemeterapi.pricing;

import com.jj.usagemeterapi.domain.usage.UsageSummary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TieredPricingService {

    private final List<Tier> tiers;

    public TieredPricingService(List<Tier> tiers) {
        this.tiers = tiers;
    }

    public Map<String, Double> calculate(List<UsageSummary> usageSummaries) {
        Map<String, Double> costs = new HashMap<>();

        for (UsageSummary usage : usageSummaries) {
            long remainingUnits = usage.getTotalUnits();
            double totalCost = 0.0;

            for (Tier tier : tiers) {
                if (remainingUnits <= 0) break;

                long unitsInTier = Math.min(remainingUnits, tier.getLimit());
                totalCost += unitsInTier * tier.getPricePerUnit();
                remainingUnits -= unitsInTier;
            }

            costs.put(usage.getApiKey(), totalCost);
        }

        return costs;
    }
}
