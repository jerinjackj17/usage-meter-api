package com.jj.usagemeterapi.repository;

import com.jj.usagemeterapi.domain.usage.UsageEvent;
import com.jj.usagemeterapi.domain.usage.UsageSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsageEventRepository extends JpaRepository<UsageEvent, Long> {

    @Query("""
        SELECT new com.jj.usagemeterapi.domain.usage.UsageSummary(
            e.apiKey,
            SUM(e.unitsUsed)
        )
        FROM UsageEvent e
        GROUP BY e.apiKey
    """)
    List<UsageSummary> summarizeUsageByApiKey();
}
