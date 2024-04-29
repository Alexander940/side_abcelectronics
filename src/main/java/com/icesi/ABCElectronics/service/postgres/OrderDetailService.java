package com.icesi.ABCElectronics.service.postgres;

import com.icesi.ABCElectronics.Repository.postgres.OrderDetailRepository;
import com.icesi.ABCElectronics.entity.postgres.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    public OrderDetail getOrderDetailByID(final Long orderDetailID) throws Exception {
        Optional<OrderDetail> existingOrderDetailOptional = orderDetailRepository.findById(orderDetailID);
        this.validateExistingOrderDetail(existingOrderDetailOptional, orderDetailID);
        return existingOrderDetailOptional.get();
    }

    public OrderDetail createOrderDetail(final OrderDetail orderDetailToCreate) {
        return orderDetailRepository.save(orderDetailToCreate);
    }

    public OrderDetail updateOrderDetail(final OrderDetail orderDetailToUpdate) throws Exception {
        Long orderDetailID = orderDetailToUpdate.getOrderNumber();
        Optional<OrderDetail> existingOrderDetailOptional = orderDetailRepository.findById(orderDetailID);
        this.validateExistingOrderDetail(existingOrderDetailOptional, orderDetailID);
        return orderDetailRepository.save(orderDetailToUpdate);
    }

    public void deleteOrderDetail(final Long orderDetailID) throws Exception {
        Optional<OrderDetail> existingOrderDetailOptional = orderDetailRepository.findById(orderDetailID);
        this.validateExistingOrderDetail(existingOrderDetailOptional, orderDetailID);
        orderDetailRepository.deleteById(orderDetailID);
    }

    public void validateExistingOrderDetail(final Optional<OrderDetail> existingOrderDetailOptional, final Long orderDetailID) throws Exception {
        if (!existingOrderDetailOptional.isPresent()) {
            throw new Exception(String.format("The orderDetail with ID %s does not exist", orderDetailID));
        }
    }
}
