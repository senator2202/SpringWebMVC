package com.kharitonov.spring_mvc.service;

import com.kharitonov.spring_mvc.entity.ProjectEntity;

import java.util.List;

public interface BaseService<T extends ProjectEntity, K> {

    T findById(K id);

    List<T> findAll();

    void save(T entity);

    void delete(K id);
}
