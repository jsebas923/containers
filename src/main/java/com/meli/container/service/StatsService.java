package com.meli.container.service;

import com.meli.container.controller.response.ResponseStats;
import com.meli.container.data.persistence.entity.ContainerStats;
import com.meli.container.data.persistence.repository.ContainerStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatsService {

    @Autowired
    private ContainerStatsRepository containerStatsRepository;

    public ResponseStats getStats() {

        Optional<ContainerStats> optionalContainerStats = containerStatsRepository.findById(1L);

        Long containerDispatched = 0L;
        Long containerNotDispatched = 0L;
        Long budget = 0L;

        if (optionalContainerStats.isPresent()) {
            containerDispatched = optionalContainerStats.get().getContainerDispatched().longValue();
            containerNotDispatched = optionalContainerStats.get().getContainerNotDispatched().longValue();
            budget = optionalContainerStats.get().getBudgetUsed().longValue();
        }
        return ResponseStats.builder()
                .budgetUsed(budget)
                .containersDispatched(containerDispatched)
                .containersNotDispatched(containerNotDispatched)
                .build();
    }
}
