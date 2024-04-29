package com.icesi.ABCElectronics.service.postgres;

import com.icesi.ABCElectronics.Repository.postgres.ProductRepository;
import com.icesi.ABCElectronics.entity.postgres.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductByID(final Long productID) throws Exception {
        Optional<Product> existingProductOptional = productRepository.findById(productID);
        this.validateExistingProduct(existingProductOptional, productID);
        return existingProductOptional.get();
    }

    public Product createProduct(final Product productToCreate) {
        return productRepository.save(productToCreate);
    }

    public Product updateProduct(final Product productToUpdate) throws Exception {
        Long productID = productToUpdate.getProductID();
        Optional<Product> existingProductOptional = productRepository.findById(productID);
        this.validateExistingProduct(existingProductOptional, productID);
        return productRepository.save(productToUpdate);
    }

    public void deleteProduct(final Long productID) throws Exception {
        Optional<Product> existingProductOptional = productRepository.findById(productID);
        this.validateExistingProduct(existingProductOptional, productID);
        productRepository.deleteById(productID);
    }

    public void validateExistingProduct(final Optional<Product> existingProductOptional, final Long productID) throws Exception {
        if (!existingProductOptional.isPresent()) {
            throw new Exception(String.format("The product with ID %s does not exist", productID));
        }
    }
}
