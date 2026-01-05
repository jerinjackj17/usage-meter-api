package com.jj.usagemeterapi.api;

import com.jj.usagemeterapi.domain.usage.UsageSummary;
import com.jj.usagemeterapi.service.UsageService;
import com.jj.usagemeterapi.domain.usage.UsageEvent;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/usage")
@CrossOrigin(origins = "*")
public class UsageController {

    private final UsageService usageService;

    public UsageController(UsageService usageService) {
        this.usageService = usageService;
    }

    @PostMapping
    public void recordUsage(@RequestBody UsageEvent event) {
        usageService.recordUsage(event);
    }

    @GetMapping
    public List<UsageEvent> getAllUsage() {
        return usageService.getAllUsage();
    }

    @GetMapping("/summary")
    public List<UsageSummary> summarizeUsage() {
        return usageService.summarizeByApiKey();
    }

}
