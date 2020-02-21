package com.example.demo.Controller;

import com.example.demo.Model.Series;
import com.example.demo.Servise.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SeriesController {

    @Autowired
    SeriesService service;


    public SeriesController() {
    }

    @GetMapping(value = "/AddQuery")
    public String select() {
        return this.service.print(this.service.AddQuery());
    }

    @GetMapping("/FindAll")
    public String findAll() {
        return this.service.print(this.service.FindAll());
    }

    @GetMapping("/FindById")
    public Optional<Series> findById(@RequestParam("id") Long id) {
        return this.service.findById(id);
    }


    @DeleteMapping("/DeleteByCharInName")
    public String deleteByName(@RequestParam("char") char abs) {
        return this.service.print(this.service.deleteByCharInName(abs));
    }

    @DeleteMapping("/DeleteById")
    public String deleteSeries(@RequestParam("id") Long id) {

        return this.service.print(this.service.deleteById(id));
    }
}