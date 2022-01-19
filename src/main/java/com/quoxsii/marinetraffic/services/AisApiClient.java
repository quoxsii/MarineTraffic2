package com.quoxsii.marinetraffic.services;

import com.google.gson.Gson;
import com.quoxsii.marinetraffic.models.AisDto;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.apache.http.client.HttpClient;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@Service
public class AisApiClient {
    HttpClient httpClient = HttpClientBuilder.create().build();
    ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
    private RestTemplate restTemplate = new RestTemplate(requestFactory);

    public List<AisDto> getAisDtoList(String url) {
        //String url = "ip";

        try {
            String response = restTemplate.getForObject(new URI(url), String.class);
            AisDto[] aisArray = new Gson().fromJson(response, AisDto[].class);
            return Arrays.asList(aisArray);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
