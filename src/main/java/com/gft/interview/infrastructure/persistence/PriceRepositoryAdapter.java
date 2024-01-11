package com.gft.interview.infrastructure.persistence;


import com.gft.interview.domain.model.Price;
import com.gft.interview.domain.port.out.PriceRepositoryPort;
import com.gft.interview.infrastructure.persistence.entity.PriceEntity;
import com.gft.interview.infrastructure.persistence.repository.PriceRepositoryJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Component
public class PriceRepositoryAdapter implements PriceRepositoryPort {

    private final PriceRepositoryJpa priceRepositoryJpa;

    public PriceRepositoryAdapter(PriceRepositoryJpa priceRepositoryJpa) {
        this.priceRepositoryJpa = priceRepositoryJpa;
    }

    @Override
    public Optional<Price> findPricesOrderByPriority(
            LocalDateTime applicationDate, Long productId, Long brandId) {

        Optional<PriceEntity> priceEntity = priceRepositoryJpa
                .findPriceByApplicationDateAndProductAndBrand(applicationDate, productId, brandId);

        log.info("[findPricesOrderByPriority] - Found {} prices for applicationDate: {}, productId: {}, brandId: {}",
                priceEntity, applicationDate, productId, brandId);

        return PriceEntityMapper.mapToPrice(priceEntity);
    }
}
