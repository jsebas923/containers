package com.meli.container.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@Validated
@NoArgsConstructor
@JsonIgnoreProperties(value = { "containers" })
public class Container {

    @NotBlank
    @JsonProperty("name")
    private String name;

    @NotNull
    @PositiveOrZero(message = "transport cost must be greater zero or positive")
    private double transportCost;


    @NotNull
    @Positive(message = "container price must be greater 0")
    private double containerPrice;
}
