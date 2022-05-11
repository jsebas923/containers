package com.meli.container.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseContainer {

    @JsonProperty("containers_dispatched")
    private String ContainersDispatched;
}
