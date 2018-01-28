package com.master.captain.service.impl;

import com.master.captain.dao.BlogDao;
import com.master.captain.model.Blog;
import com.master.captain.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Override
    public Serializable save(Blog blog) {
        return blogDao.save(blog);
    }

}