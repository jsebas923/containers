package com.meli.container.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HealthCheckTest {

    @InjectMocks
    HealthCheck healthCheck;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void healthCheckReturnOk() {
        assertEquals(healthCheck.healthCheck().getStatusCode(), HttpStatus.OK);
    }
}
