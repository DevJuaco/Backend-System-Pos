package com.pos.system.web.controller;

import com.pos.system.persistence.entity.ProductEntity;
import com.pos.system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAll () {
        return ResponseEntity.ok(this.productService.getAll());
    }

    @PostMapping
    public ResponseEntity<ProductEntity> create(@RequestBody ProductEntity product) {
        if(product.getIdProduct() == null || !this.productService.exists(product.getIdProduct())) {
            return ResponseEntity.ok(this.productService.save(product));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<ProductEntity> update(@RequestBody ProductEntity product) {
        if(product.getIdProduct() != null && this.productService.exists(product.getIdProduct())) {
            return ResponseEntity.ok(this.productService.save(product));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{idProduct}")
    public ResponseEntity<Void> delete(@PathVariable int idProduct) {
        if(this.productService.exists(idProduct)) {
            this.productService.delete(idProduct);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
