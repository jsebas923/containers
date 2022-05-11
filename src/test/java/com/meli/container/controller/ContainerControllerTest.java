package com.meli.container.controller;

import com.meli.container.controller.response.ResponseContainer;
import com.meli.container.controller.response.ResponseStats;
import com.meli.container.data.dto.Container;
import com.meli.container.data.dto.RequestData;
import com.meli.container.service.ContainerService;
import com.meli.container.service.StatsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ContainerControllerTest {

    @InjectMocks
    ContainerController containerController;

    @Mock
    ContainerService containerService;

    @Mock
    StatsService statsService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void selectContainersReturnOk() {
        ResponseContainer responseContainer = ResponseContainer.builder()
                .ContainersDispatched("C1").build();

        RequestData request = new RequestData();
        request.setContainers(buildContainers());
        request.setBudget(1000D);

        when(containerService.selectContainers(any(Double.class), any())).thenReturn(responseContainer);
        ResponseEntity<ResponseContainer> response = containerController.selectContainers(request);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), responseContainer);

    }

    @Test
    void statsReturnOK() {
        ResponseStats stats = ResponseStats.builder()
                .containersDispatched(100L)
                .containersNotDispatched(20L)
                .budgetUsed(120L).build();

        when(statsService.getStats()).thenReturn(stats);
        ResponseEntity<ResponseStats> response = containerController.stats();
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), stats);

    }

    private Container[] buildContainers() {
        Container[] containers = new Container[1];
        Container container = new Container();
        container.setName("prueba1");
        container.setContainerPrice(100);
        container.setTransportCost(50.0);

        containers[0] = container;

        return containers;
    }
}
