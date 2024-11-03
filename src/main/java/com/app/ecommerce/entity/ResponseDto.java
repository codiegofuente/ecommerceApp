package com.app.ecommerce.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;

@Setter
@Getter
@NoArgsConstructor
@JsonSerialize
@ToString
public class ResponseDto {
    private Long productId;
    private Long brandId;
    private Long priceList;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private Float price;
    private String curr;
}
