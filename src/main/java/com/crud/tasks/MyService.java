package com.crud.tasks;

import com.crud.tasks.model.MyJson;
import com.crud.tasks.model.MyJsonDao;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class MyService {

    private final static RestTemplate REST_TEMPLATE = new RestTemplate();

    private final static String URL_API = "https://randomuser.me/api";


    @Autowired
    private MyJsonDao myJsonDao;

    @Scheduled(fixedDelay = 5000)
    public void sample(){
        MyJson myJson = getDataFromApi();

        myJsonDao.save(myJson);

        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(myJson));
    }

    public MyJson getDataFromApi(){


        return REST_TEMPLATE.getForObject("https://randomuser.me/api", MyJson.class);

    }


}
