package com.meli.container.service;

import com.meli.container.controller.response.ResponseStats;
import com.meli.container.data.Data;
import com.meli.container.data.persistence.entity.ContainerStats;
import com.meli.container.data.persistence.repository.ContainerStatsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class StatsServiceTest {

    @InjectMocks
    StatsService statsService;

    @Mock
    ContainerStatsRepository containerStatsRepository;


    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getStatsIsPresent(){
        ContainerStats stats = Data.buildContainerStats();
        when(containerStatsRepository.findById(any(Long.class))).thenReturn(Optional.of(stats));
        ResponseStats responseStats = statsService.getStats();

        assertEquals(responseStats.getBudgetUsed(), 200L);
    }

    @Test
    void getStatsNotPresent(){
        when(containerStatsRepository.findById(any(Long.class))).thenReturn(Optional.empty());
        ResponseStats responseStats = statsService.getStats();

        assertEquals(responseStats.getBudgetUsed(), 0L);
    }
}
