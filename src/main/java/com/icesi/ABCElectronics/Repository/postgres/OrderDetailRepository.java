package com.icesi.ABCElectronics.Repository.postgres;

import com.icesi.ABCElectronics.entity.postgres.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{
}
