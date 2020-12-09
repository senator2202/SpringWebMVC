package com.kharitonov.spring_mvc.dao.impl;

import com.kharitonov.spring_mvc.dao.CityDao;
import com.kharitonov.spring_mvc.entity.City;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("jpaCityService")
@Repository
@Transactional
public class JpaCityDao implements CityDao {
    private Log log = LogFactory.getLog(JpaCityDao.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public City findById(Integer id) {
        /*TypedQuery<City> query = entityManager
                .createQuery("select c from City c where c.id=:id", City.class).setParameter("id", id);
           return query.getSingleResult();*/

        return entityManager.find(City.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<City> findAll() {
        return entityManager.createQuery("select c from City c", City.class).getResultList();
    }

    @Override
    @Transactional
    public void insert(City entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(City entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(Integer id) {
        City city = entityManager.find(City.class, id);
        if (city != null) {
            entityManager.remove(city);
        }
    }
}
