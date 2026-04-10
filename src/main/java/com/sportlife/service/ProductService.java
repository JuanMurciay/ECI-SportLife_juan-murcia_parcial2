package com.sportlife.service;

import com.sportlife.dto.ProductRequest;
import com.sportlife.dto.ProductResponse;
import com.sportlife.exception.ResourceNotFoundException;
import com.sportlife.model.Product;
import com.sportlife.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse create(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setCategory(request.getCategory());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setImageUrl(request.getImageUrl());
        product.setStatus(request.getStatus());

        Product saved = productRepository.save(product);

        return new ProductResponse(
                saved.getId(),
                saved.getName(),
                saved.getDescription(),
                saved.getCategory(),
                saved.getPrice(),
                saved.getStock(),
                saved.getImageUrl(),
                saved.getStatus()
        );
    }

    public List<ProductResponse> getAll() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getCategory(),
                        product.getPrice(),
                        product.getStock(),
                        product.getImageUrl(),
                        product.getStatus()
                ))
                .toList();
    }

    public ProductResponse getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getCategory(),
                product.getPrice(),
                product.getStock(),
                product.getImageUrl(),
                product.getStatus()
        );
    }

    public List<ProductResponse> getByCategory(String category) {
        return productRepository.findByCategoryIgnoreCase(category)
                .stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getCategory(),
                        product.getPrice(),
                        product.getStock(),
                        product.getImageUrl(),
                        product.getStatus()
                ))
                .toList();
    }

    public List<ProductResponse> getByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getCategory(),
                        product.getPrice(),
                        product.getStock(),
                        product.getImageUrl(),
                        product.getStatus()
                ))
                .toList();
    }
}