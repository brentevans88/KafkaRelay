package com.hawkeyeinnovations.sport.service_name.controller;

import com.hawkeyeinnovations.sport.service_name.model.api.Request;
import com.hawkeyeinnovations.sport.service_name.service.SomethingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static com.hawkeyeinnovations.sport.model.ConfiguredObjectMapper.JSON_MAPPER;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ExtendWith(SpringExtension.class)
public class SomethingControllerIT {

    @MockBean
    private SomethingService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldThrowOnNullParameter() throws Exception {
        mockMvc.perform(post("/api/v1/resource/something")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JSON_MAPPER.writeValueAsString(Request.builder().id(1).build())))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errorCode", is("VALIDATION_ERROR")))
            .andExpect(jsonPath("$.validationMessages[0].parameter", is("name")));
    }

    @Test
    void shouldThrowOnInvalidParameter() throws Exception {
        mockMvc.perform(post("/api/v1/resource/something")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JSON_MAPPER.writeValueAsString(Request.builder().id(10).name("fubar").build())))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errorCode", is("VALIDATION_ERROR")))
            .andExpect(jsonPath("$.validationMessages[0].parameter", is("id")));
    }

    @Test
    void shouldGenerateOutputForGame() throws Exception {

        Request request = Request.builder()
            .id(1)
            .name("fubar")
            .build();

        when(service.doSomething(request)).thenReturn(request.getName());

        mockMvc.perform(post("/api/v1/resource/something")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JSON_MAPPER.writeValueAsString(request)))
            .andExpect(status().isOk());
    }
}
