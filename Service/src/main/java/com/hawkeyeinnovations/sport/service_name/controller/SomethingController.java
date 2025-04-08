package com.hawkeyeinnovations.sport.service_name.controller;

import com.hawkeyeinnovations.sport.service_name.model.api.Request;
import com.hawkeyeinnovations.sport.service_name.model.api.Response;
import com.hawkeyeinnovations.sport.service_name.service.SomethingService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RequestMapping(value = "/api/v1/resource")
@RestController
public class SomethingController {

    private final SomethingService service;

    @Autowired
    public SomethingController(SomethingService service) {
        this.service = service;
    }

    @Operation(summary = "Do Something")
    @PostMapping("/something")
    public ResponseEntity<Response> postSomething(@Valid @RequestBody Request request) {
        Response response = Response.builder()
            .name(service.doSomething(request))
            .build();
        return ResponseEntity.ok(response);
    }
}
