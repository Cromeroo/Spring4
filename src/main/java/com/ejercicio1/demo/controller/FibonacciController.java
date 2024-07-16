package com.ejercicio1.demo.controller;

import com.ejercicio1.demo.model.FibonacciSeries;
import com.ejercicio1.demo.service.FibonacciService;
import com.ejercicio1.demo.repository.FibonacciSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/fibonacci")
public class FibonacciController {

    @Autowired
    private FibonacciService fibonacciService;

    @Autowired
    private FibonacciSeriesRepository repository;

    @PostMapping("/generate")
    public FibonacciSeries generateSeries(@RequestParam String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.parse(time, formatter);

        BigInteger seed1 = BigInteger.valueOf(localTime.getMinute());
        BigInteger seed2 = BigInteger.valueOf(localTime.getSecond());
        int count = localTime.getSecond();

        return fibonacciService.saveSeries(seed1, seed2, count, localTime.atDate(LocalDate.now()));
    }

    @GetMapping("/all")
    public List<FibonacciSeries> getAllSeries() {
        return repository.findAll();
    }
}
