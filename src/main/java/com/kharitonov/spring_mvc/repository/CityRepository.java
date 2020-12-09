package com.kharitonov.spring_mvc.repository;

import com.kharitonov.spring_mvc.entity.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Integer> {
}
