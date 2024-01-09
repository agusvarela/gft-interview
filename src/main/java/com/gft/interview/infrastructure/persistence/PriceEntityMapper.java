package com.gft.interview.infrastructure.persistence;


import com.gft.interview.domain.model.Price;
import com.gft.interview.infrastructure.persistence.entity.PriceEntity;
import org.modelmapper.ModelMapper;

import java.util.List;

public class PriceEntityMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Price mapToPrice(PriceEntity priceEntity) {
        return modelMapper.map(priceEntity, Price.class);
    }

    public static List<Price> mapToPriceList(List<PriceEntity> priceEntityList) {
        return priceEntityList.stream().map(PriceEntityMapper::mapToPrice).toList();
    }
}
