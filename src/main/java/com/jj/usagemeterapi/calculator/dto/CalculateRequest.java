package com.jj.usagemeterapi.calculator.dto;

public class CalculateRequest {

    private long monthlyCalls;
    private long freeTierCalls;
    private double costPerCall;

    public long getMonthlyCalls() {
        return monthlyCalls;
    }

    public void setMonthlyCalls(long monthlyCalls) {
        this.monthlyCalls = monthlyCalls;
    }

    public long getFreeTierCalls() {
        return freeTierCalls;
    }

    public void setFreeTierCalls(long freeTierCalls) {
        this.freeTierCalls = freeTierCalls;
    }

    public double getCostPerCall() {
        return costPerCall;
    }

    public void setCostPerCall(double costPerCall) {
        this.costPerCall = costPerCall;
    }
}
