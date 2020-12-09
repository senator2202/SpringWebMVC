package com.kharitonov.spring_mvc.controller;

import com.kharitonov.spring_mvc.entity.City;
import com.kharitonov.spring_mvc.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/cities")
public class CityController {

    private CityService cityService;

    @Autowired
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("cities", cityService.findAll());
        return "cities/list";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id, Model model) {
        cityService.delete(id);
        return "redirect:/cities";
    }

    @GetMapping("/{id}/update")
    public String updateForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("city", cityService.findById(id));
        return "cities/edit";
    }

    @PatchMapping(value = "/{id}/update")
    public String update(City city, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cities/edit";
        }
        cityService.save(city);
        return "redirect:/cities";
    }
}
