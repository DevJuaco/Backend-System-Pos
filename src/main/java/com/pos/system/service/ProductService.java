package com.pos.system.service;

import com.pos.system.persistence.entity.ProductEntity;
import com.pos.system.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductEntity> getAll () {
        return this.productRepository.findAllByOrderByIdProductAsc();
    }

    public ProductEntity save (ProductEntity product) {
        return this.productRepository.save(product);
    }

    public void delete(int idProduct) {
        this.productRepository.deleteById(idProduct);
    }

    public boolean exists(int idProduct) {
        return this.productRepository.existsById((idProduct));
    }

}
