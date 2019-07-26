package com.wx.exam1.service.imp;

import com.github.pagehelper.PageHelper;
import com.wx.exam1.dao.AddressMapper;
import com.wx.exam1.dao.CustomerMapper;
import com.wx.exam1.domain.Address;
import com.wx.exam1.domain.Customer;
import com.wx.exam1.domain.Page;
import com.wx.exam1.service.CustomerService;
import com.wx.exam1.utils.BeanUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private AddressMapper addressMapper;

    @Override
    public Boolean login(Customer customer) {
        List<Customer> list = customerMapper.login(customer);
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Page<Customer> queryByPage(Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
        Customer customer = new Customer();
        return BeanUtil.toPagedResult(customerMapper.login(customer));
    }

    @Override
    public void insertCustomer(Customer customer) {
        customerMapper.insertCustomer(customer);
    }

    @Override
    public Customer update(Customer customer) {
        //如果用户的地址信息不为空需要修改地址信息
        if (customer.getAddress() != null) {
            List<Address> addr = addressMapper.isAddr(customer.getAddress());
            if (addr != null && addr.size() > 0) {
                customer.setAddress_id(addr.get(0).getAddress_id());
            }
        }
        Integer integer = customerMapper.update(customer);
        List<Customer> list = customerMapper.selectById(customer.getCustomer_id());
        if (list != null && list.size() > 0) {
            Customer recustomer = list.get(0);
            recustomer.setAddress(customer.getAddress());
            return recustomer;
        }
        return null;
    }

    @Override
    public void deleteById(Short customer_id) {
        customerMapper.deleteById(customer_id);
    }


}
