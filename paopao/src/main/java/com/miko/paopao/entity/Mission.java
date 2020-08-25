package com.miko.paopao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * @author miko
 */
@Table
@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class Mission extends BaseData {

    private static final long serialVersionUID = -5093132276084672196L;
    /**
     * 标题
     */
    @Column
    private String title;

    /**
     * 内容
     */
    @Column
    private String content;

    /**
     * 积分
     */
    @Column
    private int integral;

    /**
     * 联系方式
     */
    @Column
    private String phone;


    /**
     * 创建人
     */
    @ManyToOne
    @JoinColumn(name = "createByUser")
    private User createByUser;

    /**
     * 完成人
     */
    @ManyToOne
    @JoinColumn(name = "finishByUser")
    private User finishByUser;

    /**
     * 任务状态 1-新发布 2-已接 -3已完成
     */
    @Column
    private int missionStatus=1;

    public Mission(String title, String content, int integral, String phone, User createByUser, User finishByUser, int missionStatus) {
        this.title = title;
        this.content = content;
        this.integral = integral;
        this.phone = phone;
        this.createByUser = createByUser;
        this.finishByUser = finishByUser;
        this.missionStatus = missionStatus;
    }

    public Mission() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getCreateByUser() {
        return createByUser;
    }

    public void setCreateByUser(User createByUser) {
        this.createByUser = createByUser;
    }

    public User getFinishByUser() {
        return finishByUser;
    }

    public void setFinishByUser(User finishByUser) {
        this.finishByUser = finishByUser;
    }

    public int getMissionStatus() {
        return missionStatus;
    }

    public void setMissionStatus(int missionStatus) {
        this.missionStatus = missionStatus;
    }
}
