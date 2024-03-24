package com.pos.system.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @Column(name = "category_id", nullable = false)
    private Integer idCategory;

    @Column(name = "group_id", nullable = false)
    private Integer idGroup;

    @Column(nullable = false, length = 30, unique = true)
    private String name;

    @Column(nullable = false, columnDefinition = "Decimal(12,2)")
    private Double price;

    @Column(nullable = false)
    private Boolean available;

    @Column(length = 160)
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", insertable = false, updatable = false)
    @JsonIgnore
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "group_id", insertable = false, updatable = false)
    @JsonIgnore
    private GroupEntity group;

    @OneToMany(mappedBy = "product")
    private List<TaxEntity> taxes;
}
