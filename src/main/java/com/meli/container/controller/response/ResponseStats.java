package com.meli.container.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseStats {

    @JsonProperty("containers_dispatched")
    private Long containersDispatched;
    @JsonProperty("containers_not_dispatched")
    private Long containersNotDispatched;
    @JsonProperty("budget_used")
    private Long budgetUsed;

}
