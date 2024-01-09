package com.gft.interview.domain.port.in;


import com.gft.interview.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface GetPriorityPricePort {

    Optional<Price> getPriorityPrice(LocalDateTime applicationDate, Long productId, Long brandId);
}
