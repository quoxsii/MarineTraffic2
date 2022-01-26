package com.quoxsii.marinetraffic.services;

import com.google.gson.Gson;
import com.quoxsii.marinetraffic.dtos.VesselDto;
import com.quoxsii.marinetraffic.entities.PostEntity;
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

/**
 * Класс сервис API клиента поста.
 */
@Service
public class PostApiClientService {
    private final RestTemplate restTemplate;

    /**
     * Конструктор - создание нового объекта.
     */
    public PostApiClientService() {
        HttpClient httpClient = HttpClientBuilder.create().build();
        ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        restTemplate = new RestTemplate(requestFactory);
    }

    /**
     * Функция парсинга поста в список объектов передачи данных судна.
     * @param postEntity сущность пост.
     * @return возвращает список объектов передачи данных судна.
     */
    public List<VesselDto> parseToList(PostEntity postEntity) {
        try {
            String response = restTemplate.getForObject(new URI(postEntity.getUrl()), String.class);
            return List.of(new Gson().fromJson(response, VesselDto.class));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
