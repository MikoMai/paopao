package com.miko.paopao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * @author miko
 */
@Table
@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class User extends BaseData {


    private static final long serialVersionUID = -5695117947813602732L;
    @Column
    private String name;

    @Column
    private int sex;

    @Column
    private int integral;

    @Column
    private String birthday;

    @Column
    private String phone;

    @Column
    private String password;

    @Column
    private boolean admin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }


    public User(String name, int sex, int integral, String birthday, String phone, String password, boolean admin) {
        this.name = name;
        this.sex = sex;
        this.integral = integral;
        this.birthday = birthday;
        this.phone = phone;
        this.password = password;
        this.admin = admin;
    }

    public User() {
    }
}
