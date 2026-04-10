package com.sportlife.controller;

import com.sportlife.dto.ProductRequest;
import com.sportlife.dto.ProductResponse;
import com.sportlife.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse create(@Valid @RequestBody ProductRequest request) {
        return productService.create(request);
    }

    @GetMapping
    public List<ProductResponse> getAll(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String name
    ) {
        if (category != null) {
            return productService.getByCategory(category);
        }

        if (name != null) {
            return productService.getByName(name);
        }

        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable Long id) {
        return productService.getById(id);
    }
}