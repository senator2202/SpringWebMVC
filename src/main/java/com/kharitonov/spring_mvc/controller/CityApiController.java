package com.kharitonov.spring_mvc.controller;

import com.kharitonov.spring_mvc.entity.City;
import com.kharitonov.spring_mvc.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/city")
public class CityApiController {

    private CityService cityService;

    @Autowired
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    @ResponseBody
    public List<City> list() {
        return cityService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public City findById(@PathVariable int id) {
        return cityService.findById(id);
    }

    @PostMapping("/")
    @ResponseBody
    public City create(@RequestBody City city) {
        return cityService.save(city);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public City update(@RequestBody City city, @PathVariable int id) {
        city.setId(id);
        return cityService.save(city);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable int id) {
        cityService.delete(id);
    }
}
