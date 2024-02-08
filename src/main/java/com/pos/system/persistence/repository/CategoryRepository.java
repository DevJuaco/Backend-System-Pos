package com.pos.system.persistence.repository;

import com.pos.system.persistence.entity.CategoryEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface CategoryRepository extends ListCrudRepository<CategoryEntity, Integer> {
    List<CategoryEntity> findAllByOrderByIdCategoryAsc();
}
