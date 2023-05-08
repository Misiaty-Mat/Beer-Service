package com.spring6framework.spring6restmvc.mappers;

import com.spring6framework.spring6restmvc.entities.Beer;
import com.spring6framework.spring6restmvc.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDTO dto);

    BeerDTO beerToBeerDto(Beer beer);
}
