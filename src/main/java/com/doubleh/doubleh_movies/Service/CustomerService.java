package com.doubleh.doubleh_movies.Service;


import com.doubleh.doubleh_movies.bean.Customer;
import com.doubleh.doubleh_movies.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    public Customer getCustomerById(int id , String pwd){

        return customerMapper.getCustomerById(id,pwd);
    }

    public int insertCustomer(int store_id, String first_name, String last_name,String email,String address_id
            ,int active,String create_date,String last_update,String pwd){

        return customerMapper.insertCustomer(store_id,first_name,last_name,email,address_id,active,create_date,last_update,pwd);
    }
}
