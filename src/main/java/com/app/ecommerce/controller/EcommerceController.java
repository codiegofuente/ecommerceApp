package com.app.ecommerce.controller;

import com.app.ecommerce.entity.Price;
import com.app.ecommerce.entity.ResponseDto;
import com.app.ecommerce.enums.ErrorCustom;
import com.app.ecommerce.exceptions.ErrorException;
import com.app.ecommerce.mappers.PriceResponseMapper;
import com.app.ecommerce.service.EcommerceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestController
@RequestMapping("/ecommerce")
@Tag(name = "Ecommerce controller", description = "Look for product information.")
@Slf4j
public class EcommerceController {

    private final EcommerceService ecommerceS;
    private final PriceResponseMapper priceResponseMapper;

    @Autowired
    public EcommerceController(EcommerceService ecommerceS, PriceResponseMapper priceResponseMapper){
        this.ecommerceS = ecommerceS;
        this.priceResponseMapper = priceResponseMapper;
    }


    @GetMapping("/product/info")
    @Operation(summary = "Return product information.")
    @ResponseBody
    public ResponseEntity<ResponseDto> getProductInfo(
            @RequestParam(name = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime date,
            @RequestParam(name = "productId", required = false) Long productId,
            @RequestParam(name = "brandId", required = false) Long brandId
    ){
        date = ZonedDateTime.of(date.toLocalDateTime(), ZoneId.systemDefault());
        parseInputs(date, productId, brandId);
        log.info("Get product info by application date: " + date.toString() + ", product id: " + productId.toString() +
                ", string id: " + brandId.toString());

        Price price = ecommerceS.getProductInfo(date, productId, brandId);
        ResponseDto responseDto = priceResponseMapper.priceToResponse(price);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    private void parseInputs(ZonedDateTime date, Long productId, Long brandId) {
        if (date == null) {
            throw new ErrorException(HttpStatus.BAD_REQUEST, ErrorCustom.DATE_ERROR.getCode());
        }

        if (productId == null || productId < 0){
            throw new ErrorException(HttpStatus.BAD_REQUEST, ErrorCustom.PRODUCT_ID_ERROR.getCode());
        }

        if (brandId == null || brandId < 0){
            throw new ErrorException(HttpStatus.BAD_REQUEST, ErrorCustom.BRAND_ID_ERROR.getCode());
        }
    }
}