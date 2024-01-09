package com.gft.interview.unit.infrastructure.persistance;

import com.gft.interview.domain.model.Price;
import com.gft.interview.infrastructure.persistence.PriceRepositoryAdapter;
import com.gft.interview.infrastructure.persistence.entity.PriceEntity;
import com.gft.interview.infrastructure.persistence.repository.PriceRepositoryJpa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PriceRepositoryAdapterTest {

    @Mock
    private PriceRepositoryJpa priceRepositoryJpa;

    @InjectMocks
    private PriceRepositoryAdapter priceRepositoryAdapter;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findPricesOrderByPriority_whenReturnsAnEmptyList_thenNoPriceFound() {
        when(priceRepositoryJpa.findPricesByApplicationDateAndProductAndBrand(any(), any(), any()))
                .thenReturn(Collections.emptyList());

        List<Price> prices = priceRepositoryAdapter.findPricesOrderByPriority(
                LocalDateTime.now(), 1L, 1L);

        assertEquals(0, prices.size());

        verify(priceRepositoryJpa, times(1)).findPricesByApplicationDateAndProductAndBrand(any(), any(), any());
    }

    @Test
    public void findPricesOrderByPriority_whenReturnsPriceList_thenPricesFound() {
        List<PriceEntity> priceEntityList = List.of(new PriceEntity());

        when(priceRepositoryJpa.findPricesByApplicationDateAndProductAndBrand(any(), any(), any()))
                .thenReturn(priceEntityList);

        List<Price> prices = priceRepositoryAdapter.findPricesOrderByPriority(
                LocalDateTime.now(), 1L, 1L);

        assertEquals(priceEntityList.size(), prices.size());

        verify(priceRepositoryJpa, times(1)).findPricesByApplicationDateAndProductAndBrand(any(), any(), any());
    }
}
