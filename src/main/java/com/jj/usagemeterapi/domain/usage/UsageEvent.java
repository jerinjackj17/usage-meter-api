package com.jj.usagemeterapi.domain.usage;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "usage_events")
public class UsageEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String apiKey;
    private String endpoint;
    private long unitsUsed;
    private Instant timestamp;

    protected UsageEvent() {}

    public UsageEvent(String apiKey, String endpoint, long unitsUsed) {
        this.apiKey = apiKey;
        this.endpoint = endpoint;
        this.unitsUsed = unitsUsed;
        this.timestamp = Instant.now();
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public long getUnitsUsed() {
        return unitsUsed;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
