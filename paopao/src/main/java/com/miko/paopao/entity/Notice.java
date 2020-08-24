package com.miko.paopao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.miko.paopao.entity.dataenum.NoticeType;

import javax.persistence.*;

/**
 * @author miko
 */
@Table
@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class Notice extends BaseData {

    /**
     * 通知类型
     */
    @Enumerated(EnumType.STRING)
    @Column
    private NoticeType type;

    /**
     * 接收人
     */
    @ManyToOne
    @JoinColumn(name = "noticeToUser")
    private User noticeToUser;

    /**
     * 通知人
     */
    @ManyToOne
    @JoinColumn(name = "noticeFromUser")
    private User noticeFromUser;

    /**
     * 内容
     */
    @Column
    private String content;

    public NoticeType getType() {
        return type;
    }

    public void setType(NoticeType type) {
        this.type = type;
    }

    public User getNoticeToUser() {
        return noticeToUser;
    }

    public void setNoticeToUser(User noticeToUser) {
        this.noticeToUser = noticeToUser;
    }

    public User getNoticeFromUser() {
        return noticeFromUser;
    }

    public void setNoticeFromUser(User noticeFromUser) {
        this.noticeFromUser = noticeFromUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Notice(NoticeType type, User noticeToUser, User noticeFromUser, String content) {
        this.type = type;
        this.noticeToUser = noticeToUser;
        this.noticeFromUser = noticeFromUser;
        this.content = content;
    }

    public Notice() {
    }
}
