package com.pos.system.persistence.repository;

import com.pos.system.persistence.entity.ProductEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ProductRepository extends ListCrudRepository<ProductEntity, Integer> {
    List<ProductEntity> findAllByOrderByIdProductAsc();
}
