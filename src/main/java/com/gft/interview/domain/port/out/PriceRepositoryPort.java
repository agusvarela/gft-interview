package com.gft.interview.domain.port.out;


import com.gft.interview.domain.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepositoryPort {

    List<Price> findPricesOrderByPriority(LocalDateTime applicationDate, Long productId, Long brandId);

}