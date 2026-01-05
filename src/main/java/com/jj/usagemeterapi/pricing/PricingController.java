package com.jj.usagemeterapi.pricing;

import com.jj.usagemeterapi.domain.usage.UsageSummary;
import com.jj.usagemeterapi.service.UsageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pricing")
@CrossOrigin(origins = "*")
public class PricingController {

    private final UsageService usageService;

    public PricingController(UsageService usageService) {
        this.usageService = usageService;
    }

    @GetMapping("/flat")
    public Map<String, Double> calculateFlatPricing(
            @RequestParam double pricePerUnit
    ) {
        FlatPricingService pricingService =
                new FlatPricingService(pricePerUnit);

        List<UsageSummary> usageSummaries =
                usageService.summarizeByApiKey();

        return pricingService.calculateCosts(usageSummaries);
    }

    @GetMapping("/free-tier")
    public Map<String, FreeTierPricingResult> calculateFreeTierPricing(
            @RequestParam long freeUnits,
            @RequestParam double pricePerUnit
    ) {
        FreeTierPricingService service =
                new FreeTierPricingService(freeUnits, pricePerUnit);

        List<UsageSummary> usageSummaries =
                usageService.summarizeByApiKey();

        return service.calculate(usageSummaries);
    }

    @GetMapping("/tiered")
    public Map<String, Double> calculateTieredPricing() {

        List<Tier> tiers = List.of(
                new Tier(100, 0.0),
                new Tier(500, 0.01),
                new Tier(Long.MAX_VALUE, 0.02)
        );

        TieredPricingService service =
                new TieredPricingService(tiers);

        List<UsageSummary> usageSummaries =
                usageService.summarizeByApiKey();

        return service.calculate(usageSummaries);
    }
}
