package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.OrderMapper;
import com.zking.ssm.model.Order;
import com.zking.ssm.service.IOrderservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderserviceImpl implements IOrderservice {

    @Autowired
    private OrderMapper o;
    @Override
    public List<Order> selectByPrimaryKey(Integer orderId) {
        return o.selectByPrimaryKey(orderId);
    }
}
