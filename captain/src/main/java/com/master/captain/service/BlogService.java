package com.master.captain.service;

import com.master.captain.model.Blog;

import java.io.Serializable;
import java.util.List;

public interface BlogService {

    Serializable save(Blog blog);

    List<Blog> load();

}