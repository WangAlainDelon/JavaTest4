package com.wx.exam1.controller;

import com.wx.exam1.domain.Address;
import com.wx.exam1.domain.Customer;
import com.wx.exam1.service.AddressService;
import com.wx.exam1.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

    private static Short id = 0;
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AddressService addressService;

    /**
     * 登录接口，POST 请求，通过curl 传入name 和password。只有 name 与 customer 表的 first_name
     * 相同，且 password 与last_name 相同时。登录成功。
     * 校验用户名
     *
     * @param customer
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@Valid @RequestBody Customer customer) {
        Boolean login = customerService.login(customer);
        return ResponseEntity.ok("Login status ：" + login);
    }


    /**
     * 新增用户对象，包含first_name, last_name, email, address。
     * 校验地址
     *
     * @param customer
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> addUser(@Validated({Customer.Bdult.class}) @RequestBody Customer customer) {
        Address addr = addressService.isAddr(customer.getAddress());
        if (addr != null) {
            customer.setAddress_id(addr.getAddress_id());
            customerService.insertCustomer(customer);
            this.id = customer.getCustomer_id();
            logger.info("New CustomerID" + customer.getCustomer_id());
            return ResponseEntity.ok("New CustomerID：" + customer.getCustomer_id());
        }
        return ResponseEntity.status(500).body(null);
    }

    /**
     * 更新用户,包含first_name, last_name, email, address。
     *
     * @param customer_id
     * @param customer
     * @return
     */
    @RequestMapping(value = "{customer_id}", method = RequestMethod.PUT)
    public ResponseEntity<String> uodateCustomer(@PathVariable("customer_id") Short customer_id, @RequestBody Customer customer) {
        if (customer_id == null) {
            customer.setCustomer_id(id);
        }
        customer.setCustomer_id(customer_id);
        Customer customerRe = customerService.update(customer);
        this.id = customerRe.getCustomer_id();
        return ResponseEntity.ok("The update was successful, and the result of the updated object was：" + customerRe.toString());
    }

    /**
     * 删除新增的用户，DELETE 请求。其中用户的id为上一道题返回的id。根据id删除用户
     *
     * @param customer_id
     * @return
     */
    @RequestMapping(value = "{customer_id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCustomerById(@PathVariable("customer_id") Short customer_id) {
        if (customer_id == null || customer_id <= 0) {
            return ResponseEntity.status(500).body(null);
        }
        customerService.deleteById(customer_id);
        return ResponseEntity.ok("Successful deletion!!!");
    }

}
