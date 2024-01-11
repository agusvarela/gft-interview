package com.gft.interview.application.service;

import com.gft.interview.domain.model.Price;
import com.gft.interview.domain.port.in.GetPriorityPricePort;
import com.gft.interview.domain.port.out.PriceRepositoryPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
public class PriceService implements GetPriorityPricePort {

    private final PriceRepositoryPort priceRepositoryPort;

    public PriceService(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
    }

    @Override
    public Optional<Price> getPriorityPrice(LocalDateTime applicationDate, Long productId, Long brandId) {
        log.info("[getPriorityPrice] - Processing request for applicationDate: {}, productId: {}, brandId: {}",
                applicationDate, productId, brandId);

        Optional<Price> priceFound = priceRepositoryPort
                .findPricesOrderByPriority(applicationDate, productId, brandId);

        log.info("[getPriorityPrice] - Found {} for applicationDate: {}, productId: {}, brandId: {}",
                priceFound, applicationDate, productId, brandId);

        return priceFound;
    }
}