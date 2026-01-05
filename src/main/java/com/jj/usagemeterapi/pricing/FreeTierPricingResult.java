package com.jj.usagemeterapi.pricing;

public class FreeTierPricingResult {

    private long totalUnits;
    private long freeUnits;
    private long billableUnits;
    private double cost;

    public FreeTierPricingResult(
            long totalUnits,
            long freeUnits,
            long billableUnits,
            double cost
    ) {
        this.totalUnits = totalUnits;
        this.freeUnits = freeUnits;
        this.billableUnits = billableUnits;
        this.cost = cost;
    }

    public long getTotalUnits() {
        return totalUnits;
    }

    public long getFreeUnits() {
        return freeUnits;
    }

    public long getBillableUnits() {
        return billableUnits;
    }

    public double getCost() {
        return cost;
    }
}
