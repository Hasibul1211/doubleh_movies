package com.doubleh.doubleh_movies.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Customer {
    private int customer_id;
    private String first_name;
    private String last_name;
    private String pwd;
    private String email;
    private int store_id;
    private int address_id;
    private int active;
    private String create_date =null;
    private String last_update = null;

}
