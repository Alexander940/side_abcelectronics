package com.icesi.ABCElectronics.entity.postgres;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "ordernumber")
    private Long orderNumber;
    @Column(name = "customerid")
    private Long customerID;
    @Column(name = "orderdate")
    private String orderDate;
    @Column(name = "shippeddate")
    private String shippedDate;
    @Column(name = "paymentdate")
    private String paymentDate;

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long ordernumber) {
        this.orderNumber = ordernumber;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerid) {
        this.customerID = customerid;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderdate) {
        this.orderDate = orderdate;
    }

    public String getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(String shippeddate) {
        this.shippedDate = shippeddate;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
}
