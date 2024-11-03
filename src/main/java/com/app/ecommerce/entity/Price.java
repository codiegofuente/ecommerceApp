package com.app.ecommerce.entity;

import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

import static com.app.ecommerce.utils.EntityConstants.*;

@Entity
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Table(name = PRICES_FIELD)
public class Price {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = BRAND_ID_FIELD)
    private Brand brandId;

    @Column(name = START_DATE_FIELD)
    private ZonedDateTime startDate;

    @Column(name = END_DATE_FIELD)
    private ZonedDateTime endDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = PRICE_LIST_FIELD)
    private Long priceList;

    @Column(name = PRODUCT_ID_FIELD)
    private Long productId;

    @Column(name = PRIORITY_FIELD)
    private Long priority;

    @Column(name = PRICE_FIELD)
    private Float price;

    @Column(name = CURR_FIELD)
    private String curr;
}
