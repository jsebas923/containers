package com.meli.container.controller;

import com.meli.container.controller.response.ResponseContainer;
import com.meli.container.controller.response.ResponseStats;
import com.meli.container.data.dto.RequestData;
import com.meli.container.service.ContainerService;
import com.meli.container.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class ContainerController {

    @Autowired
    private ContainerService containerService;

    @Autowired
    private StatsService statsService;

    @PostMapping(value = "/containers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseContainer> selectContainers(@Valid @RequestBody RequestData requestData) {
        return new ResponseEntity<>(containerService.selectContainers
                (requestData.getBudget(), requestData.getContainers()), HttpStatus.OK);
    }

    @GetMapping("/stats")
    public ResponseEntity<ResponseStats> stats() {
        return new ResponseEntity<>(statsService.getStats(), HttpStatus.OK);
    }
}
