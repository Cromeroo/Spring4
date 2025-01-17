package com.ejercicio1.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
public class FibonacciSeries {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigInteger seed1;
    private BigInteger seed2;
    private int count;

    @Column(length = 10000)
    private String series;

    private LocalDateTime generatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getSeed1() {
        return seed1;
    }

    public void setSeed1(BigInteger seed1) {
        this.seed1 = seed1;
    }

    public BigInteger getSeed2() {
        return seed2;
    }

    public void setSeed2(BigInteger seed2) {
        this.seed2 = seed2;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }
}
