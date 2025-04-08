package com.hawkeyeinnovations.sport.service_name.model.api;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Value
@Builder
@JsonDeserialize(builder = Request.RequestBuilder.class)
public class Request {

    @NotNull
    @Min(1)
    @Max(5)
    private final Integer id;

    @NotNull
    private final String name;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class RequestBuilder {}
}
