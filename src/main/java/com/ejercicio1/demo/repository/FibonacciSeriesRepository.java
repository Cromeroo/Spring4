package com.ejercicio1.demo.repository;

import com.ejercicio1.demo.model.FibonacciSeries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FibonacciSeriesRepository extends JpaRepository<FibonacciSeries, Long> {
}
