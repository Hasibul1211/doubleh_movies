package com.doubleh.doubleh_movies.bean;

import lombok.Data;

@Data
public class Admin {
    private String admin_name;
    private String admin_pwd;

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_pwd() {
        return admin_pwd;
    }

    public void setAdmin_pwd(String admin_pwd) {
        this.admin_pwd = admin_pwd;
    }
}
