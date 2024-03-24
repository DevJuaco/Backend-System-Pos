package com.pos.system.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "taxes")
@Getter
@Setter
@NoArgsConstructor
public class TaxEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tax_id", nullable = false)
    private Integer idTax;

    @Column(nullable = false, length = 35)
    private String name;

    @Column(name = "id_product")
    private Integer idProduct;

    @Column(nullable = false)
    private Integer value;

    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id_product", insertable = false, updatable = false)
    @JsonIgnore
    private ProductEntity product;
}
