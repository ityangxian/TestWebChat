package com.amayadream.webchat.controller;

import com.amayadream.webchat.pojo.Log;
import com.amayadream.webchat.service.ILogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author :  Amayadream
 * Date   :  2016.01.10 00:23
 * TODO   :
 */
@Controller
@RequestMapping(value = "")
public class LogController {

    @Resource
    private ILogService logService;

    @RequestMapping(value = "{userid}/log")
    public ModelAndView selectAll(@PathVariable("userid") String userid,
                                  @RequestParam(defaultValue = "1") int page,
                                  @RequestParam(defaultValue = "5") int pageSize) {
        ModelAndView view = new ModelAndView("log");
        List<Log> list = logService.selectLogByUserid(userid, page, pageSize);
        int count = logService.selectCountByUserid(userid, pageSize);
        view.addObject("list", list);
        view.addObject("count", count);
        return view;
    }

    @ResponseBody
    @RequestMapping(value = "/{userid}/getLogCount", method = RequestMethod.GET)
    public int getLogCount(@PathVariable String userid) {
        if (userid != null && userid.length() != 0) {
            return logService.getLogCount(userid);
        }
        return 0;
    }
}
