package com.master.captain.dao.impl;

import com.master.captain.dao.AbstractDao;
import com.master.captain.dao.CategoryDao;
import com.master.captain.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDaoImpl extends AbstractDao<Category> implements CategoryDao {

    @Override
    public List<Category> load() {
        return super.load(Category.class);
    }

}