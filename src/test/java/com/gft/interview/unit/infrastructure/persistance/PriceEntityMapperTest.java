package com.gft.interview.unit.infrastructure.persistance;

import com.gft.interview.domain.model.Price;
import com.gft.interview.infrastructure.persistence.PriceEntityMapper;
import com.gft.interview.infrastructure.persistence.entity.PriceEntity;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceEntityMapperTest {

    @Test
    public void mapToPrice_thenReturnsCorrectPrice() {
        PriceEntity priceEntity = buildPriceEntity(1L);

        Price price = PriceEntityMapper.mapToPrice(priceEntity);

        assertEquals(priceEntity.getProductId(), price.getProductId());
    }

    @Test
    public void mapToPriceList_thenReturnsCorrectPriceList() {
        PriceEntity priceEntity1 = buildPriceEntity(1L);
        PriceEntity priceEntity2 = buildPriceEntity(2L);

        List<PriceEntity> priceEntityList = Arrays.asList(priceEntity1, priceEntity2);

        List<Price> priceList = PriceEntityMapper.mapToPriceList(priceEntityList);

        assertEquals(2, priceList.size());
        assertEquals(priceEntity1.getProductId(), priceList.get(0).getProductId());
        assertEquals(priceEntity2.getProductId(), priceList.get(1).getProductId());
    }

    private PriceEntity buildPriceEntity(Long productId) {
        PriceEntity priceEntity = new PriceEntity();
        priceEntity.setProductId(productId);
        priceEntity.setBrandId(2L);
        priceEntity.setPriceList(3);
        priceEntity.setStartDate(LocalDateTime.now());
        priceEntity.setEndDate(LocalDateTime.now().plusDays(1));
        priceEntity.setPrice(BigDecimal.valueOf(35.50));
        priceEntity.setCurrency("EUR");
        return priceEntity;
    }
}
