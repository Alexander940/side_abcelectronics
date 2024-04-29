package com.icesi.ABCElectronics.Repository.postgres;

import com.icesi.ABCElectronics.entity.postgres.CategoryProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryProductsRepository extends JpaRepository<CategoryProducts, Long> {
}
