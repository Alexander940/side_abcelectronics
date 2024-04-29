package com.icesi.ABCElectronics.Repository.postgres;

import com.icesi.ABCElectronics.entity.postgres.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
