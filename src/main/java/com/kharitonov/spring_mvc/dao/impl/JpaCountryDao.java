package com.kharitonov.spring_mvc.dao.impl;

import com.kharitonov.spring_mvc.dao.CountryDao;
import com.kharitonov.spring_mvc.entity.City;
import com.kharitonov.spring_mvc.entity.Country;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service("jpaCountryService")
@Repository
@Transactional
public class JpaCountryDao implements CountryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<City> findCities(String code) {
        return entityManager
                .createQuery("select c FROM City c WHERE c.country.code=:code", City.class)
                .setParameter("code", code)
                .getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Country findById(String id) {
        return entityManager.find(Country.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Country> findAll() {
        return entityManager.createQuery("select c from Country c", Country.class).getResultList();
    }

    @Override
    public void insert(Country entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(Country entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(String id) {
        Country country = entityManager.find(Country.class, id);
        if (country != null) {
            entityManager.remove(country);
            entityManager.remove(country);
        }
    }
}
