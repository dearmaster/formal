package com.master.captain.service.impl;

import com.master.captain.dao.CategoryDao;
import com.master.captain.model.Category;
import com.master.captain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> loadCategories() {
        return categoryDao.load();
    }

}