package com.zking.ssm.service;

import com.zking.ssm.model.Customer;

public interface ICustomerservice {

    Customer selectByPrimaryKey(Integer customerId);

}