package com.icesi.ABCElectronics.controller.postgres;

import com.icesi.ABCElectronics.entity.postgres.CategoryProducts;
import com.icesi.ABCElectronics.service.postgres.CategoryProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoryProducts")
public class CategoryProductsController {

    @Autowired
    private CategoryProductsService categoryProductsService;

    @GetMapping
    public ResponseEntity<List<CategoryProducts>> getAllCategoryProducts() {
        return ResponseEntity.ok(categoryProductsService.getAllCategoryProducts());
    }

    @GetMapping(value = "/{categoryProductsID}")
    public ResponseEntity getCategoryProductsByID(@PathVariable (value = "code") Long categoryProductsID) {
        try {
            return ResponseEntity.ok(categoryProductsService.getCategoryProductsByID(categoryProductsID));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createCategoryProducts(@RequestBody CategoryProducts categoryProductsToCreate) {
        return ResponseEntity.ok(categoryProductsService.createCategoryProducts(categoryProductsToCreate));
    }

    @PutMapping
    public ResponseEntity updateCategoryProducts(@RequestBody CategoryProducts categoryProductsToUpdate) {
        try {
            return ResponseEntity.ok(categoryProductsService.updateCategoryProducts(categoryProductsToUpdate));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{categoryProductsID}")
    public ResponseEntity deleteCategoryProducts(@PathVariable (value = "code") Long categoryProductsID) {
        try {
            categoryProductsService.deleteCategoryProducts(categoryProductsID);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
