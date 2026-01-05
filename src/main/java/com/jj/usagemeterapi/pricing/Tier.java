package com.jj.usagemeterapi.pricing;

public class Tier {

    private final long limit;
    private final double pricePerUnit;

    public Tier(long limit, double pricePerUnit) {
        this.limit = limit;
        this.pricePerUnit = pricePerUnit;
    }

    public long getLimit() {
        return limit;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }
}
