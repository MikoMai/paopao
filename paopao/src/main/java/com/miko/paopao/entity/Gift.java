package com.miko.paopao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author miko
 */
@Table
@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class Gift extends BaseData {
    private static final long serialVersionUID = -1703605986878096274L;

    /**
     * 礼物名
     */
    @Column
    private String name;
    /**
     * 所需积分
     */
    @Column
    private int integral;
    /**
     * 数量
     */
    @Column
    private int num;

    public Gift(String name, int integral, int num) {
        this.name = name;
        this.integral = integral;
        this.num = num;
    }

    public Gift() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
