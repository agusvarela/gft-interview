package com.gft.interview.unit.application.service;


import com.gft.interview.application.service.PriceService;
import com.gft.interview.domain.model.Price;
import com.gft.interview.domain.port.out.PriceRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PriceServiceTest {

    @Mock
    private PriceRepositoryPort priceRepositoryPort;

    @InjectMocks
    private PriceService priceService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getPriorityPrice_whenReturnsPrice_thenSuccess() {
        List<Price> priceList = List.of(new Price());
        when(priceRepositoryPort.findPricesOrderByPriority(any(LocalDateTime.class),
                any(Long.class), any(Long.class)))
                .thenReturn(priceList);

        Optional<Price> result = priceService.getPriorityPrice(LocalDateTime.now(),
                1L, 1L);

        assertEquals(Optional.of(priceList.get(0)), result);

        verify(priceRepositoryPort, times(1))
                .findPricesOrderByPriority(
                        any(LocalDateTime.class), any(Long.class), any(Long.class));
    }

    @Test
    public void getPriorityPrice_whenNoPriceFound_thenEmptyResult() {
        when(priceRepositoryPort.findPricesOrderByPriority(any(LocalDateTime.class),
                any(Long.class), any(Long.class)))
                .thenReturn(new ArrayList<>());

        Optional<Price> result = priceService.getPriorityPrice(LocalDateTime.now(),
                1L, 1L);

        assertEquals(Optional.empty(), result);

        verify(priceRepositoryPort, times(1))
                .findPricesOrderByPriority(
                        any(LocalDateTime.class), any(Long.class), any(Long.class));
    }
}
