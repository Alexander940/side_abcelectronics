package com.icesi.ABCElectronics.controller.postgres;

import com.icesi.ABCElectronics.entity.postgres.Customer;
import com.icesi.ABCElectronics.service.postgres.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping(value = "/{customerID}")
    public ResponseEntity getCustomerByID(@PathVariable(value = "customerID") Long customerID) {
        try {
            return ResponseEntity.ok(customerService.getCustomerByID(customerID));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody Customer customerToCreate) {
        return ResponseEntity.ok(customerService.createCustomer(customerToCreate));
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody Customer customerToUpdate) {
        try {
            return ResponseEntity.ok(customerService.updateCustomer(customerToUpdate));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{customerID}")
    public ResponseEntity deleteCustomer(@PathVariable(value = "customerID") Long customerID) {
        try {
            customerService.deleteCustomer(customerID);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
