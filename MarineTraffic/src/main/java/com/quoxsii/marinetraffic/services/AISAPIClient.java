package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.models.AISDto;
import com.quoxsii.marinetraffic.models.AISListDto;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.apache.http.client.HttpClient;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AISAPIClient {
    HttpClient httpClient = HttpClientBuilder.create().build();
    ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
    private RestTemplate restTemplate = new RestTemplate(requestFactory);

    public List<AISDto> getAISList() {
        String url = "ip adress";

        try {
            String response = restTemplate.getForObject(new URI(url), String.class);
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(response);

            AISListDto aisListDto = new AISListDto();
            ArrayList<AISDto> aisDtos = new ArrayList<AISDto>();

            for (Object o : jsonArray) {
                AISDto aisDto = new AISDto();
                JSONObject ais = (JSONObject) o;

                aisDto.setChannelId((Long) ais.get("channelId"));
                aisDto.setChannel((String) ais.get("channel"));
                aisDtos.add(aisDto);
            }

            return aisDtos;
        } catch (URISyntaxException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
