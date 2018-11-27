package com.amayadream.webchat.dao;

import com.amayadream.webchat.pojo.Message;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "messageDao")
public interface IMessageDao {

    List<Message> selectMessageByUserid(@Param("userid") String userid, @Param("offset") int offset, @Param("limit") int limit);

    boolean insert(Message message);

    boolean delete(String mid);

    boolean deleteThisUser(String userid);

}
