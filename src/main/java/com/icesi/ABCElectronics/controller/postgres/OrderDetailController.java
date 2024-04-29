package com.icesi.ABCElectronics.controller.postgres;

import com.icesi.ABCElectronics.entity.postgres.OrderDetail;
import com.icesi.ABCElectronics.service.postgres.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/orderdetails")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping
    public ResponseEntity getAllOrderDetails() {
        return ResponseEntity.ok(orderDetailService.getAllOrderDetails());
    }

    @GetMapping(value = "/{orderDetailID}")
    public ResponseEntity getOrderDetailByID(@PathVariable(value = "ordernumber") Long orderDetailID) {
        try {
            return ResponseEntity.ok(orderDetailService.getOrderDetailByID(orderDetailID));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createOrderDetail(@RequestBody OrderDetail orderDetailToCreate) {
        return ResponseEntity.ok(orderDetailService.createOrderDetail(orderDetailToCreate));
    }

    @PutMapping
    public ResponseEntity updateOrderDetail(@RequestBody OrderDetail orderDetailToUpdate) {
        try {
            return ResponseEntity.ok(orderDetailService.updateOrderDetail(orderDetailToUpdate));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{orderDetailID}")
    public ResponseEntity deleteOrderDetail(@PathVariable(value = "orderDetailID") Long orderDetailID) {
        try {
            orderDetailService.deleteOrderDetail(orderDetailID);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
