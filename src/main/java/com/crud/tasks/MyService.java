package com.crud.tasks;

import com.crud.tasks.model.MyJson;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class MyService {

    private final static RestTemplate REST_TEMPLATE = new RestTemplate();

    private final static String URL_API = "https://randomuser.me/api";

    public MyJson getDataFromApi(){

        URI uri = UriComponentsBuilder.newInstance()
                .path("https://randomuser.me/api")
                .queryParam("valueA", "savsad")
                .queryParam("valueB", "dsfasdfasdf")
                .build()
                .toUri();


        return REST_TEMPLATE.getForObject(uri, MyJson.class);

    }


}
