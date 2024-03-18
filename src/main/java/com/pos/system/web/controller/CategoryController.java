package com.pos.system.web.controller;

import com.pos.system.persistence.entity.CategoryEntity;
import com.pos.system.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryEntity>> getAll () {
        try {
            return ResponseEntity.ok(this.categoryService.getAll());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<CategoryEntity> create (@RequestBody CategoryEntity category) {
        try {
            if(category.getIdCategory() == null || !this.categoryService.exists(category.getIdCategory())) {
                return ResponseEntity.ok(this.categoryService.save(category));
            }

            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity<CategoryEntity> update (@RequestBody CategoryEntity category) {
        try {
            if(category.getIdCategory() != null && this.categoryService.exists(category.getIdCategory())) {
                return ResponseEntity.ok(this.categoryService.save(category));
            }

            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<Void> delete (@PathVariable int idCategory) {
        try {
            if(this.categoryService.exists(idCategory)) {
                this.categoryService.delete(idCategory);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
