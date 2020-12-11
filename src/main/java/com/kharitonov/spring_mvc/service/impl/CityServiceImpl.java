package com.kharitonov.spring_mvc.service.impl;


import com.google.common.collect.Lists;
import com.kharitonov.spring_mvc.entity.City;
import com.kharitonov.spring_mvc.repository.CityRepository;
import com.kharitonov.spring_mvc.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Service("cityService")
@Transactional
public class CityServiceImpl implements CityService {
    private CityRepository cityRepository;

    @Autowired
    public void setCityRepository(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public City findById(Integer id) {
        return cityRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<City> findAll() {
        return Lists.newArrayList(cityRepository.findAll());
    }

    @Override
    public City save(City entity) {
        return cityRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        cityRepository.delete(id);
    }
}
