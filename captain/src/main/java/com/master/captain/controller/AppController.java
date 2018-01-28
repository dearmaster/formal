package com.master.captain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String navToIndex() {
        return "index";
    }

    @RequestMapping(value = {"/publish"}, method = RequestMethod.GET)
    public String navToPublish() {
        return "publish";
    }

}