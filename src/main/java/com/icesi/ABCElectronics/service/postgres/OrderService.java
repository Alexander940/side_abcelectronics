package com.icesi.ABCElectronics.service.postgres;

import com.icesi.ABCElectronics.Repository.postgres.OrderRepository;
import com.icesi.ABCElectronics.entity.postgres.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderByID(final Long orderID) throws Exception {
        Optional<Order> existingOrderOptional = orderRepository.findById(orderID);
        this.validateExistingOrder(existingOrderOptional, orderID);
        return existingOrderOptional.get();
    }

    public Order createOrder(final Order orderToCreate) {
        return orderRepository.save(orderToCreate);
    }

    public Order updateOrder(final Order orderToUpdate) throws Exception {
        Long orderID = orderToUpdate.getOrderNumber();
        Optional<Order> existingOrderOptional = orderRepository.findById(orderID);
        this.validateExistingOrder(existingOrderOptional, orderID);
        return orderRepository.save(orderToUpdate);
    }

    public void deleteOrder(final Long orderID) throws Exception {
        Optional<Order> existingOrderOptional = orderRepository.findById(orderID);
        this.validateExistingOrder(existingOrderOptional, orderID);
        orderRepository.deleteById(orderID);
    }

    public void validateExistingOrder(final Optional<Order> existingOrderOptional, final Long orderID) throws Exception {
        if (!existingOrderOptional.isPresent()) {
            throw new Exception(String.format("The order with ID %s does not exist", orderID));
        }
    }
}
