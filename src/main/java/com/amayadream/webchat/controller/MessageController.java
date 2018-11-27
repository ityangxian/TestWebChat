package com.amayadream.webchat.controller;

import com.amayadream.webchat.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private IMessageService messageService;

    @RequestMapping(value = "/getMessage/{userid}")
    public List getMessage(@PathVariable String userid,
                           @RequestParam(defaultValue = "1") String pageNumber,
                           @RequestParam(defaultValue = "5") String pageSize) {
        return messageService.selectMessageByUserid(
                userid,
                Integer.parseInt(pageNumber),
                Integer.parseInt(pageSize));
    }

}
