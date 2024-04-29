package com.icesi.ABCElectronics.Repository.postgres;

import com.icesi.ABCElectronics.entity.postgres.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
