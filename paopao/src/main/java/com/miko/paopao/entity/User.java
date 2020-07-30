package com.miko.paopao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * @author admin
 */
@Table
@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class User extends BaseData {


    @Column
    private String name;

    @Column
    private int sex;

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

    public User(String name, int sex) {
        this.name = name;
        this.sex = sex;
    }

    public User() {
    }
}
