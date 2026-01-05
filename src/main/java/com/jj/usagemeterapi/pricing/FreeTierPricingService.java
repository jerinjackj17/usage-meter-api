package com.jj.usagemeterapi.pricing;

import com.jj.usagemeterapi.domain.usage.UsageSummary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreeTierPricingService {

    private final long freeUnits;
    private final double pricePerUnit;

    public FreeTierPricingService(long freeUnits, double pricePerUnit) {
        this.freeUnits = freeUnits;
        this.pricePerUnit = pricePerUnit;
    }

    public Map<String, FreeTierPricingResult> calculate(List<UsageSummary> usageSummaries) {
        Map<String, FreeTierPricingResult> result = new HashMap<>();

        for (UsageSummary usage : usageSummaries) {
            long billableUnits = Math.max(0, usage.getTotalUnits() - freeUnits);
            double cost = billableUnits * pricePerUnit;

            result.put(
                    usage.getApiKey(),
                    new FreeTierPricingResult(
                            usage.getTotalUnits(),
                            freeUnits,
                            billableUnits,
                            cost
                    )
            );
        }

        return result;
    }
}
