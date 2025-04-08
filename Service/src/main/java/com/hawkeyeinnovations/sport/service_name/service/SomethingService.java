package com.hawkeyeinnovations.sport.service_name.service;

import com.hawkeyeinnovations.sport.service_name.model.api.Request;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SomethingService {

    @Autowired
    public SomethingService(BuildProperties buildProperties) {
        log.info("service name={} version={}", buildProperties.getName(), buildProperties.getVersion());
    }

    public String doSomething(Request request) {
        return request.getName();
    }
}
