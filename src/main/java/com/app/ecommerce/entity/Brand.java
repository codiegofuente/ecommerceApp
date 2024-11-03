package com.app.ecommerce.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static com.app.ecommerce.utils.EntityConstants.*;

@Entity
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Table(name = BRANDS_FIELD)
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = BRAND_NAME_FIELD)
    protected String brandName;

    @ToString.Exclude
    @OneToMany(
            mappedBy = BRAND_ID,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Price> prices = new ArrayList<>();

    public Brand (Long id) {this.id = id;}
}
