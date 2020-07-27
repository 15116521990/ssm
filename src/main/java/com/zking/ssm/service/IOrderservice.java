package com.zking.ssm.service;

import com.zking.ssm.model.Order;

import java.util.List;

public interface IOrderservice {

    List<Order> selectByPrimaryKey(Integer orderId);


}