package com.master.captain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String navToIndex() {
        return "page-memory";
    }

    @RequestMapping(value = {"/publish"}, method = RequestMethod.GET)
    public String navToPublish() {
        return "page-publish";
    }

    @RequestMapping(value = {"/memory"}, method = RequestMethod.GET)
    public String navToMemory() {
        return "page-memory";
    }

    @RequestMapping(value = {"/pad"}, method = RequestMethod.GET)
    public String navToPad() {
        return "page-pad";
    }

    @RequestMapping(value = {"/health"}, method = RequestMethod.GET)
    public String navToHealth() {
        return "page-health";
    }

    @RequestMapping(value = {"/photography"}, method = RequestMethod.GET)
    public String navToPhotography() {
        return "page-photography";
    }


    @RequestMapping(value = {"/getContent"}, method = RequestMethod.GET)
    public String navToGetContent() {
        return "getContent";
    }

    @RequestMapping(value = {"/imageUp"}, method = RequestMethod.POST)
    public String navToImageUp() {
        return "imageUp";
    }

}