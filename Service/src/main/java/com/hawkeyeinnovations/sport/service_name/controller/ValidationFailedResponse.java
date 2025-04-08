package com.hawkeyeinnovations.sport.service_name.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import java.util.List;

@Value
public class ValidationFailedResponse {

    @Schema(title = "Error code", example = "VALIDATION_ERROR")
    private final String errorCode;

    @Schema(title = "Error message(s)")
    private final List<ValidationMessage> validationMessages;

    @Value
    public static class ValidationMessage {
        private final String parameter;
        private final String reason;
    }
}
