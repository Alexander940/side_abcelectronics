package com.icesi.ABCElectronics.controller.postgres;

import com.icesi.ABCElectronics.entity.postgres.Product;
import com.icesi.ABCElectronics.service.postgres.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping(value = "/{productID}")
    public ResponseEntity getProductByID(@PathVariable(value = "productID") Long productID) {
        try {
            return ResponseEntity.ok(productService.getProductByID(productID));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product productToCreate) {
        return ResponseEntity.ok(productService.createProduct(productToCreate));
    }

    @PutMapping
    public ResponseEntity updateProduct(@RequestBody Product productToUpdate) {
        try {
            return ResponseEntity.ok(productService.updateProduct(productToUpdate));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{productID}")
    public ResponseEntity deleteProduct(@PathVariable(value = "productID") Long productID) {
        try {
            productService.deleteProduct(productID);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
