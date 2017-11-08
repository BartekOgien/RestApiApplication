package com.crud.tasks;

import com.crud.tasks.model.MyJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyServiceTest {

    private final static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Autowired
    private MyService myService;

    @Test
    public void getDataFromApi() throws Exception {

        MyJson ans =  myService.getDataFromApi();

        System.out.println(gson.toJson(ans));
    }

}