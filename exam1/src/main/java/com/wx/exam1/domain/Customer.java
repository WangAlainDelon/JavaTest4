package com.wx.exam1.domain;


import com.wx.exam1.annotation.AdressExist;

import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Customer implements Serializable {

    private static final long serialVersionUID = -19896235409447L;
    private Short customer_id;
    private Short store_id;
    @NotBlank(message = "登陆用户的first_name不能为空")
    private String first_name;
    @NotBlank(message = "登陆用户的last_name不能为空")
    private String last_name;
    private String email;
    private Short address_id;
    private Short active;
    private Date create_date;
    private Timestamp last_update;
    @Transient
    @AdressExist(message = "地址必须有效", groups = {Bdult.class})
    private String address;

    public interface Bdult {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Short getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Short customer_id) {
        this.customer_id = customer_id;
    }

    public Short getStore_id() {
        return store_id;
    }

    public void setStore_id(Short store_id) {
        this.store_id = store_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Short getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Short address_id) {
        this.address_id = address_id;
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Timestamp getLast_update() {
        return last_update;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", store_id=" + store_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", address_id=" + address_id +
                ", active=" + active +
                ", create_date=" + create_date +
                ", last_update=" + last_update +
                ", address='" + address + '\'' +
                '}';
    }
}
