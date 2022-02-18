package com.quoxsii.marinetraffic.configs;

import com.quoxsii.marinetraffic.services.PostApiClientService;
import com.quoxsii.marinetraffic.services.VesselService;
import com.quoxsii.marinetraffic.tasks.ParserTask;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ParserTaskFactory {
    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ParserTask createParserTask(VesselService vesselService, PostApiClientService postApiClientService) {
        return new ParserTask(vesselService, postApiClientService);
    }
}
