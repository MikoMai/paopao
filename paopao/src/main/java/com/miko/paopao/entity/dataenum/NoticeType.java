package com.miko.paopao.entity.dataenum;

/**
 * @author miko
 */

public enum NoticeType {
    MISSION("MISSION");
    private String type;
    private NoticeType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
