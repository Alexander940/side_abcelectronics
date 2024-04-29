package com.icesi.ABCElectronics.service.postgres;

import com.icesi.ABCElectronics.Repository.postgres.CustomerRepository;
import com.icesi.ABCElectronics.entity.postgres.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerByID(final Long customerID) throws Exception {
        Optional<Customer> existingCustomerOptional = customerRepository.findById(customerID);
        this.validateExistingCustomer(existingCustomerOptional, customerID);
        return existingCustomerOptional.get();
    }

    public Customer createCustomer(final Customer customerToCreate) {
        return customerRepository.save(customerToCreate);
    }

    public Customer updateCustomer(final Customer customerToUpdate) throws Exception {
        Long customerID = customerToUpdate.getCustomerID();
        Optional<Customer> existingCustomerOptional = customerRepository.findById(customerID);
        this.validateExistingCustomer(existingCustomerOptional, customerID);
        return customerRepository.save(customerToUpdate);
    }

    public void deleteCustomer(final Long customerID) throws Exception {
        Optional<Customer> existingCustomerOptional = customerRepository.findById(customerID);
        this.validateExistingCustomer(existingCustomerOptional, customerID);
        customerRepository.deleteById(customerID);
    }

    public void validateExistingCustomer(final Optional<Customer> existingCustomerOptional, final Long customerID) throws Exception {
        if (!existingCustomerOptional.isPresent()) {
            throw new Exception(String.format("The customer with ID %s does not exist", customerID));
        }
    }
}
