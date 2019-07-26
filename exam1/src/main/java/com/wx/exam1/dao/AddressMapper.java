package com.wx.exam1.dao;

import com.wx.exam1.domain.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AddressMapper {
    List<Address> isAddr(@Param("address") String address);
}
