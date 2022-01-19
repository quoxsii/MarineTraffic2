package com.quoxsii.marinetraffic;

import com.quoxsii.marinetraffic.entities.AisEntity;
import com.quoxsii.marinetraffic.services.AisApiClient;
import com.quoxsii.marinetraffic.services.AisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@Scope("prototype")
public class AisParserRunnable implements Runnable {
    @Autowired
    private AisApiClient aisApiClient;
    @Autowired
    private AisService aisService;

    @Override
    public void run() {
        System.out.printf("Parser started in thread %s\n", Thread.currentThread().getName());

        List<AisEntity> aisEntityList = aisApiClient.getAisDtoList("ip").stream().map(AisEntity::toEntity).collect(toList());

        for (AisEntity en: aisEntityList) {
            aisService.save("ip");
        }

        System.out.printf("Parser executed in thread %s\n", Thread.currentThread().getName());
    }
}
