package com.amayadream.webchat.service;

import com.amayadream.webchat.pojo.Message;

import java.util.List;


public interface IMessageService {
    List<Message> selectMessageByUserid(String userid, int page, int pageSize);
    boolean insert(Message message);
    boolean delete(String id);
    boolean deleteThisUser(String userid);
    int selectCount(String userid);
    int selectCountByUserid(String userid, int pageSize);

    List<Message> selectMessageGroupByTo(String userid);
}
