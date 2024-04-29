package com.icesi.ABCElectronics.controller.postgres;

import com.icesi.ABCElectronics.entity.postgres.Order;
import org.springframework.beans.factory.annotation.Autowired;
import com.icesi.ABCElectronics.service.postgres.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping(value = "/{orderID}")
    public ResponseEntity getOrderByID(@PathVariable(value = "ordernumber") Long orderID) {
        try {
            return ResponseEntity.ok(orderService.getOrderByID(orderID));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createOrder(@RequestBody Order orderToCreate) {
        return ResponseEntity.ok(orderService.createOrder(orderToCreate));
    }

    @PutMapping
    public ResponseEntity updateOrder(@RequestBody Order orderToUpdate) {
        try {
            return ResponseEntity.ok(orderService.updateOrder(orderToUpdate));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{orderID}")
    public ResponseEntity deleteOrder(@PathVariable(value = "ordernumber") Long orderID) {
        try {
            orderService.deleteOrder(orderID);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
