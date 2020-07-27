package com.zking.ssm.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class Order implements Serializable {
    private Integer orderId;

    private String orderNo;

    private Integer cid;

    private  Customer cu;

    public Customer getCu() {
        return cu;
    }

    public void setCu(Customer cu) {
        this.cu = cu;
    }

    public Order(Integer orderId, String orderNo, Integer cid) {
        this.orderId = orderId;
        this.orderNo = orderNo;
        this.cid = cid;
    }

    public Order() {
        super();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}