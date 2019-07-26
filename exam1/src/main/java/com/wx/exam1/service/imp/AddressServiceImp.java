package com.wx.exam1.service.imp;

import com.wx.exam1.dao.AddressMapper;
import com.wx.exam1.domain.Address;
import com.wx.exam1.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImp implements AddressService {
    @Resource
    private AddressMapper addressMapper;

    @Override
    public Address isAddr(String address) {
        List<Address> addr = addressMapper.isAddr(address);
        if (addr != null && addr.size() > 0) {
            return addr.get(0);
        }
        return null;
    }
}
