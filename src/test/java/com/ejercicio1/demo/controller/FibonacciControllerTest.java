package com.ejercicio1.demo.controller;

import com.ejercicio1.demo.model.FibonacciSeries;
import com.ejercicio1.demo.service.FibonacciService;
import com.ejercicio1.demo.repository.FibonacciSeriesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@WebMvcTest(FibonacciController.class)
public class FibonacciControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FibonacciService fibonacciService;

    @MockBean
    private FibonacciSeriesRepository repository; // Añadido

    private FibonacciSeries fibonacciSeries;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        fibonacciSeries = new FibonacciSeries();
        fibonacciSeries.setId(1L);
        fibonacciSeries.setSeed1(BigInteger.valueOf(30));
        fibonacciSeries.setSeed2(BigInteger.valueOf(45));
        fibonacciSeries.setCount(45);
        fibonacciSeries.setSeries("[30, 45, 75, 120, 195, 315, 510, 825, 1335, 2160, 3495, 5655, 9150, 14805, 23955, 38760, 62715, 101475, 164190, 265665, 429855, 695520, 1125375, 1820895, 2946270, 4767165, 7713435, 12480600, 20194035, 32674635, 52868670, 85543305, 138411975, 223955280, 362367255, 586322535, 948689790, 1535012325, 2483702115, 4018714440, 6502416555, 10521131095, 17023547650, 27544678745, 44568226495, 72112905240, 116681131735]");
        fibonacciSeries.setGeneratedAt(LocalTime.of(12, 30, 45).atDate(LocalDate.now()));
    }

    @Test
    void generateSeries_success() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.parse("12:30:45", formatter);

        when(fibonacciService.saveSeries(BigInteger.valueOf(30), BigInteger.valueOf(45), 45, localTime.atDate(LocalDate.now())))
                .thenReturn(fibonacciSeries);

        mockMvc.perform(post("/api/fibonacci/generate")
                        .param("time", "12:30:45"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.seed1", is(30)))
                .andExpect(jsonPath("$.seed2", is(45)))
                .andExpect(jsonPath("$.count", is(45)))
                .andExpect(jsonPath("$.series", is(fibonacciSeries.getSeries())));
    }
}
