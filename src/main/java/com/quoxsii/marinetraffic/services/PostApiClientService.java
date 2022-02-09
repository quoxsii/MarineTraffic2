package com.quoxsii.marinetraffic.services;

import com.google.gson.Gson;
import com.quoxsii.marinetraffic.dtos.VesselDto;
import com.quoxsii.marinetraffic.models.Post;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

/**
 * Сервис API клиента поста.
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
     * @param post модель пост.
     * @return возвращает список объектов передачи данных судна.
     */
    public List<VesselDto> parseToList(Post post) {
        try {
            String response = restTemplate.getForObject(new URI(post.getUrl()), String.class);
            VesselDto[] vesselDtoArray = new Gson().fromJson(response, VesselDto[].class);
            return Arrays.asList(vesselDtoArray);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
