package com.kharitonov.spring_mvc.dao;

import com.kharitonov.spring_mvc.entity.City;
import com.kharitonov.spring_mvc.entity.Country;

import java.util.List;

public interface CountryDao extends BaseDao<Country, String> {
    List<City> findCities(String code);
}
