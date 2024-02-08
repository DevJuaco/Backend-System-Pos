package com.pos.system.service;

import com.pos.system.persistence.entity.CategoryEntity;
import com.pos.system.persistence.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryEntity> getAll() {
        return this.categoryRepository.findAllByOrderByIdCategoryAsc();
    }

    public CategoryEntity save (CategoryEntity category) {
        return this.categoryRepository.save(category);
    }

    public void delete (int idCategory) {
        this.categoryRepository.deleteById(idCategory);
    }

    public boolean exists (int idCategory) {
        return this.categoryRepository.existsById(idCategory);
    }
}
