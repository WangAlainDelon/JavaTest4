package com.wx.exam1.service;

import com.wx.exam1.domain.Customer;
import com.wx.exam1.domain.Page;

public interface CustomerService {
    Boolean login(Customer customer);

    Page<Customer> queryByPage(Integer pageNo, Integer pageSize);

    void insertCustomer(Customer customer);

    Customer update(Customer customer);

    void deleteById(Short customer_id);
}
