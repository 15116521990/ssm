package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.CustomerMapper;
import com.zking.ssm.model.Customer;
import com.zking.ssm.service.ICustomerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerserviceImpl implements ICustomerservice {
    @Autowired
    private CustomerMapper c;
    @Override
    public Customer selectByPrimaryKey(Integer customerId) {
        return c.selectByPrimaryKey(customerId);
    }
}
