package com.wx.exam1.annotation;

import com.wx.exam1.domain.Address;
import com.wx.exam1.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 真正的地址校验类
 */
@Component
public class IsAdressValidator implements ConstraintValidator<AdressExist, String> {
    @Autowired
    private AddressService addressService;

    @Override
    public void initialize(AdressExist constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s == "") {
            return false;
        }
        Address addr = addressService.isAddr(s);
        if (addr == null) {
            return false;
        }
        return true;
    }
}
