package com.master.captain.controller;

import com.master.captain.model.Category;
import com.master.captain.service.CategoryService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {

    private static final Logger logger = LogManager.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/load")
    @ResponseBody
    public List<Category> load() {
        logger.info("Loading categories....");
        return categoryService.loadCategories();
    }

}