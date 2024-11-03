package com.app.ecommerce.mappers;

import com.app.ecommerce.entity.Brand;
import com.app.ecommerce.entity.Price;
import com.app.ecommerce.entity.ResponseDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface PriceResponseMapper {

    @Mappings({
            @Mapping(source = "brandId", target = "brandId", qualifiedByName = "brandToLong")
    })
    ResponseDto priceToResponse(Price price);

    @Named("brandToLong")
    default Long brandToLong(Brand brand) {
        return brand != null ? brand.getId() : null;
    }
}
