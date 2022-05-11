package com.meli.container.service;

import com.meli.container.controller.response.ResponseContainer;
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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


public class ContainerServiceTest {

    @InjectMocks
    ContainerService containerService;

    @Mock
    ContainerStatsRepository containerStatsRepository;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void selectContainersIsPresentRegistry() {
        ContainerStats stats = Data.buildContainerStats();
        when(containerStatsRepository.findById(any(Long.class))).thenReturn(Optional.of(stats));
        ResponseContainer selectContainers =
                containerService.selectContainers(60D, Data.builContainers());

        assertNotNull(selectContainers);
        assertEquals(selectContainers.getContainersDispatched(), "C2 C1 ");

    }

    @Test
    void selectContainersNotPresentRegistry() {
        ContainerStats stats = Data.buildContainerStats();
        when(containerStatsRepository.findById(any(Long.class))).thenReturn(Optional.empty());
        ResponseContainer selectContainers =
                containerService.selectContainers(60D, Data.builContainers());

        assertNotNull(selectContainers);
        assertEquals(selectContainers.getContainersDispatched(), "C2 C1 ");
    }


}
