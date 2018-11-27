package com.amayadream.webchat.serviceImpl;

import com.amayadream.webchat.dao.IMessageDao;
import com.amayadream.webchat.pojo.Message;
import com.amayadream.webchat.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private IMessageDao messageDao;

    @Override
    public List<Message> selectMessageByUserid(String userid, int page, int pageSize) {
        int start = (page - 1) * pageSize;
        return messageDao.selectMessageByUserid(userid, start, pageSize);
    }

    @Override
    public boolean insert(Message message) {
        return messageDao.insert(message);
    }

    @Override
    public boolean delete(String mid) {
        return messageDao.delete(mid);
    }

    @Override
    public boolean deleteThisUser(String userid) {
        return messageDao.deleteThisUser(userid);
    }
}
