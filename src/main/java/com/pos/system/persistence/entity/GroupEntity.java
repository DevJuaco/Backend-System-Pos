package com.pos.system.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
public class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id", nullable = false)
    private Integer idGroup;

    @Column(nullable = false, length = 35)
    private String name;

    @Column(nullable = false)
    private Boolean available;

    @OneToMany(mappedBy = "group")
    private List<ProductEntity> products;

}
