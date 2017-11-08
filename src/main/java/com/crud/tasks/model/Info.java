package com.crud.tasks.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "INFO")

public class Info {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "MY_JSON_ID", referencedColumnName = "ID")
    private MyJson myJson;

    private String seed;

    private Integer results;

    private Integer page;

    private String version;

}
