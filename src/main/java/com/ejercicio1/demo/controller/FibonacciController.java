package com.ejercicio1.demo.controller;

import com.ejercicio1.demo.model.FibonacciSeries;
import com.ejercicio1.demo.service.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/fibonacci")
public class FibonacciController {
    @Autowired
    private FibonacciService service;

    @PostMapping("/generate")
    public FibonacciSeries generateSeries(@RequestParam String time ){
        DateTimeFormatter  formatter= DateTimeFormatter.ofPattern("HH:mm:SS");
        LocalDateTime localDateTime= LocalDateTime.parse(time, formatter);

        int seed1 = localDateTime.getMinute();
        int seed2 = localDateTime.getSecond();
        int count = localDateTime.getSecond();

        return service.saveSeries(seed1, seed2, count);
    }
}
