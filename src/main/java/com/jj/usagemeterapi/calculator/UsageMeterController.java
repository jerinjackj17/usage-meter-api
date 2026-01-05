package com.jj.usagemeterapi.calculator;

import com.jj.usagemeterapi.calculator.dto.CalculateRequest;
import com.jj.usagemeterapi.calculator.dto.CalculateResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UsageMeterController {

    @PostMapping("/calculate")
    public CalculateResponse calculate(@RequestBody CalculateRequest request) {

        long total = request.getMonthlyCalls();
        long freeTier = Math.min(request.getFreeTierCalls(), total);
        long billable = Math.max(0, total - freeTier);

        double monthlyCost = billable * request.getCostPerCall();
        double savings = freeTier * request.getCostPerCall();

        return new CalculateResponse(
                total,
                freeTier,
                billable,
                round(monthlyCost),
                round(savings)
        );
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
