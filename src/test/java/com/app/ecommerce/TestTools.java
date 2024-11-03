package com.app.ecommerce;

import com.app.ecommerce.entity.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.ZonedDateTime;

public class TestTools {

    public static ResponseEntity<ResponseDto> exResult(Long brandId, ZonedDateTime startDate, ZonedDateTime endDate, Long priceList,
                                          Long productId, Float price, String curr) {

        ResponseDto responseDto = new ResponseDto();
        responseDto.setProductId(productId);
        responseDto.setBrandId(brandId);
        responseDto.setPriceList(priceList);
        responseDto.setStartDate(startDate);
        responseDto.setEndDate(endDate);
        responseDto.setPrice(price);
        responseDto.setCurr(curr);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
