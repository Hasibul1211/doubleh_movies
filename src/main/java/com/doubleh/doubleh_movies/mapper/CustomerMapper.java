package com.doubleh.doubleh_movies.mapper;


import com.doubleh.doubleh_movies.bean.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CustomerMapper {
    @Select("select * from customer where customer_id=#{id} and pwd=#{pwd}")
    Customer getCustomerById(int id, String pwd);

    @Insert("insert into customer (store_id,first_name,last_name,email,address_id,active,create_date,last_update,pwd) values(#{store_id},#{first_name},#{last_name},#{email},#{address_id},#{active},#{create_date},#{last_update},#{pwd});")
    int insertCustomer(int store_id, String first_name, String last_name,String email,String address_id
                   ,int active,String create_date,String last_update,String pwd);
}
