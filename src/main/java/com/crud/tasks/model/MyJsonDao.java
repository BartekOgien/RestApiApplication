package com.crud.tasks.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyJsonDao extends PagingAndSortingRepository<MyJson, Long>{

    List<MyJson> findAll();

}
