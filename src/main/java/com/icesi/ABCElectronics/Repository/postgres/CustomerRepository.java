package com.icesi.ABCElectronics.Repository.postgres;

import com.icesi.ABCElectronics.entity.postgres.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
