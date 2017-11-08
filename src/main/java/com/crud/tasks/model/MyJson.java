package com.crud.tasks.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "MY_JSON")

public class MyJson {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private Info info;

}
