package com.amayadream.webchat.pojo;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;

@Repository("message")
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    private int mid;        // 消息id
    private String userid;  // 消息发送者
    private Date time;      // 发送时间
    private String to;      // 消息接收者

    public Message() {
    }

    public Message(String userid, Date time, String to) {
        this.userid = userid;
        this.time = time;
        this.to = to;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
