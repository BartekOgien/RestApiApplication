package com.crud.tasks.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Info {

    private String seed;

    private Integer results;

    private Integer page;

    private String version;

}
