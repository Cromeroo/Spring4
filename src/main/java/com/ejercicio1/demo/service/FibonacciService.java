package com.ejercicio1.demo.service;

import com.ejercicio1.demo.model.FibonacciSeries;
import com.ejercicio1.demo.repository.FibonacciSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FibonacciService {

    @Autowired
    private FibonacciSeriesRepository repository;

    public FibonacciSeries saveSeries(BigInteger seed1, BigInteger seed2, int count, LocalDateTime generatedAt) {
        List<BigInteger> series = generateFibonacciSeries(seed1, seed2, count);
        FibonacciSeries fibonacciSeries = new FibonacciSeries();
        fibonacciSeries.setSeed1(seed1);
        fibonacciSeries.setSeed2(seed2);
        fibonacciSeries.setCount(count);
        fibonacciSeries.setSeries(series.toString());
        fibonacciSeries.setGeneratedAt(generatedAt);
        return repository.save(fibonacciSeries);
    }

    private List<BigInteger> generateFibonacciSeries(BigInteger seed1, BigInteger seed2, int count) {
        List<BigInteger> series = new ArrayList<>();
        series.add(seed1);
        series.add(seed2);

        for (int i = 2; i < count; i++) {
            BigInteger next = series.get(i - 1).add(series.get(i - 2));
            series.add(next);
        }

        return series;
    }
}
