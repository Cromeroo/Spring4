package com.ejercicio1.demo.service;

import com.ejercicio1.demo.model.FibonacciSeries;
import com.ejercicio1.demo.repository.FibonacciSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FibonacciService {
    @Autowired
    private FibonacciSeriesRepository repository;


    public List<Integer> generateFibonacciSeries(int seed1, int seed2, int count){
        List<Integer> series = new ArrayList<>();
        series.add(seed1);
        series.add(seed2);
        for (int i = 2; i < count + 2; i++) {
            series.add(series.get(i - 1) + series.get(i - 2));
        }
        return series;
    }

    public FibonacciSeries saveSeries(int seed1, int seed2, int count) {
        List<Integer> series = generateFibonacciSeries(seed1, seed2, count);
        FibonacciSeries fibonacciSeries = new FibonacciSeries();
        fibonacciSeries.setSeed1(seed1);
        fibonacciSeries.setSeed2(seed2);
        fibonacciSeries.setCount(count);
        fibonacciSeries.setSeries(series.toString());
        fibonacciSeries.setGeneratedAt(LocalDateTime.now());
        return repository.save(fibonacciSeries);
    }
}
