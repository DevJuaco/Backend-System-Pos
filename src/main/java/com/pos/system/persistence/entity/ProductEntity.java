package com.pos.system.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "products")
@Getter
@Setter
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product", nullable = false)
    private Integer idProduct;

    @Column(nullable = false, length = 30, unique = true)
    private String name;

    @Column(nullable = false, columnDefinition = "Decimal(12,2)")
    private Double price;

    @Column(nullable = false)
    private Boolean available;

    @Column(length = 160)
    private String description;
}
