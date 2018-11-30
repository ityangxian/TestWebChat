package com.amayadream.webchat.controller;

import com.amayadream.webchat.pojo.Message;
import com.amayadream.webchat.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private IMessageService messageService;

    @RequestMapping(value = "{userid}/message")
    public ModelAndView getMessage(@PathVariable("userid") String userid,
                                   @RequestParam(defaultValue = "1") int page,
                                   @RequestParam(defaultValue = "5") int pageSize,
                                   @RequestParam(defaultValue = "") String to) {
        ModelAndView view = new ModelAndView("message");
        List<Message> list = messageService.selectMessageByUserid(userid, page, pageSize);
        int count = messageService.selectCountByUserid(userid, pageSize);
        List<Message> toList = messageService.selectMessageGroupByTo(userid);
        view.addObject("toList", toList);
        view.addObject("list", list);
        view.addObject("count", count);
        return view;
    }

    @RequestMapping(value = "/{userid}/getMessageCount", method = RequestMethod.GET)
    public int getMessageCount(@PathVariable String userid) {
        if (userid != null && userid.length() != 0) {
            return messageService.selectCount(userid);
        }
        return 0;
    }

}
