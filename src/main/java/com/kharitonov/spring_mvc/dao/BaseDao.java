package com.kharitonov.spring_mvc.dao;

import com.kharitonov.spring_mvc.entity.ProjectEntity;

import java.util.List;

public interface BaseDao<T extends ProjectEntity, K> {

    T findById(K id);

    List<T> findAll();

    void insert(T entity);

    void update(T entity);

    void delete(K id);
}
