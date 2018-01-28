package com.master.captain.dao.impl;

import com.master.captain.dao.AbstractDao;
import com.master.captain.dao.BlogDao;
import com.master.captain.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogDaoImpl extends AbstractDao<Blog> implements BlogDao {

    @Override
    public List<Blog> load() {
        return super.load(Blog.class);
    }

}