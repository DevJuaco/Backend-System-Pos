package com.pos.system.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Integer idCategory;

    @Column(nullable = false, length = 35, unique = true)
    private String name;

    @Column(nullable = false)
    private Boolean available;

    @OneToMany(mappedBy = "category")
    private List<ProductEntity> products;
}
