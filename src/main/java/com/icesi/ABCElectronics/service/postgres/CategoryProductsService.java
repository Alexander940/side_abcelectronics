package com.icesi.ABCElectronics.service.postgres;

import com.icesi.ABCElectronics.Repository.postgres.CategoryProductsRepository;
import com.icesi.ABCElectronics.entity.postgres.CategoryProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryProductsService {

    @Autowired
    private CategoryProductsRepository categoryProductsRepository;

    public List<CategoryProducts> getAllCategoryProducts() {
        return categoryProductsRepository.findAll();
    }

    public CategoryProducts getCategoryProductsByID(final Long categoryProductsID) throws Exception {
        Optional<CategoryProducts> existingCategoryProductsOptional = categoryProductsRepository.findById(categoryProductsID);
        this.validateExistingCategoryProducts(existingCategoryProductsOptional, categoryProductsID);
        return existingCategoryProductsOptional.get();
    }

    public CategoryProducts createCategoryProducts(final CategoryProducts categoryProductsToCreate) {
        return categoryProductsRepository.save(categoryProductsToCreate);
    }

    public CategoryProducts updateCategoryProducts(final CategoryProducts categoryProductsToUpdate) throws Exception {
        Long categoryProductsID = categoryProductsToUpdate.getCode();
        Optional<CategoryProducts> existingCategoryProductsOptional = categoryProductsRepository.findById(categoryProductsID);
        this.validateExistingCategoryProducts(existingCategoryProductsOptional, categoryProductsID);
        return categoryProductsRepository.save(categoryProductsToUpdate);
    }

    public void deleteCategoryProducts(final Long categoryProductsID) throws Exception {
        Optional<CategoryProducts> existingCategoryProductsOptional = categoryProductsRepository.findById(categoryProductsID);
        this.validateExistingCategoryProducts(existingCategoryProductsOptional, categoryProductsID);
        categoryProductsRepository.deleteById(categoryProductsID);
    }
    public void validateExistingCategoryProducts(final Optional<CategoryProducts> existingCategoryProductsOptional, final Long categoryProductsID) throws Exception {
        if (!existingCategoryProductsOptional.isPresent()) {
            throw new Exception(String.format("The categoryProducts with ID %s does not exist", categoryProductsID));
        }
    }
}
