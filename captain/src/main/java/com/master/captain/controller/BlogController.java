package com.master.captain.controller;

import com.master.captain.model.Blog;
import com.master.captain.service.BlogService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;

@Controller
@RequestMapping("blog")
public class BlogController {

    private static final Logger logger = Logger.getLogger(BlogController.class);

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/save")
    @ResponseBody
    public Serializable save(HttpSession session, @RequestBody Blog blog) {
        logger.info(blog);
        Serializable id = blogService.save(blog);
        logger.info(id);
        return id;
    }

    @RequestMapping(value = "/load")
    @ResponseBody
    public List<Blog> load() {
        return blogService.load();
    }

}