package com.meli.container.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;


@Getter
@Setter
@NoArgsConstructor
@Validated
public class RequestData {

    @JsonProperty("budget")
    @PositiveOrZero(message = "budget be equal greater than 0")
    @NotNull
    private Double budget;

    @Size(min = 1, message = "Container must be greater than 0")
    @Valid
    private Container[] containers;
}
