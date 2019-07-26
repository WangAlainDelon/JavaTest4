package com.wx.exam1.dao;

import com.wx.exam1.domain.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerMapper {
    List<Customer> login(@Param("customer") Customer customer);

    void insertCustomer(Customer customer);

    Integer update(Customer customer);

    List<Customer> selectById(@Param("customer_id") Short integer);

    void deleteById(Short customer_id);
}
