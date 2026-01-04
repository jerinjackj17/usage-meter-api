package com.jj.helloapi.dto;

public class CalculateResponse {

    private long totalCalls;
    private long freeTierCalls;
    private long billableCalls;
    private double monthlyCost;
    private double freeTierSavings;

    public CalculateResponse(long totalCalls,
                             long freeTierCalls,
                             long billableCalls,
                             double monthlyCost,
                             double freeTierSavings) {
        this.totalCalls = totalCalls;
        this.freeTierCalls = freeTierCalls;
        this.billableCalls = billableCalls;
        this.monthlyCost = monthlyCost;
        this.freeTierSavings = freeTierSavings;
    }

    public long getTotalCalls() {
        return totalCalls;
    }

    public long getFreeTierCalls() {
        return freeTierCalls;
    }

    public long getBillableCalls() {
        return billableCalls;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public double getFreeTierSavings() {
        return freeTierSavings;
    }
}
