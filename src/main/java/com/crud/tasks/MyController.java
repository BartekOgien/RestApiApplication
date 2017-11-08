package com.crud.tasks;

import com.crud.tasks.model.MyJson;
import com.crud.tasks.model.MyJsonDao;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class MyController {

    private MyJsonDao myJsonDao;

    @GetMapping(value = "abc")
    public List<MyJson> getMyJsonsObj() {
        return myJsonDao.findAll();
    }

}
