package com.action;

import com.entity.Category;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.service.CategoryService;


import java.util.List;

/**
 * Created by 王宁 on 2017/7/21.
 */

    @Namespace("/")
    @ParentPackage("basicstruts")
    @Results(
            {
                    @Result(name = "listCategory",location="/admin/listCategory.jsp"),
            }
    )
    public class CategoryAction {
        @Autowired
        CategoryService categoryService;
        List<Category> categories;

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Action("categorylist")
    public String list(){
            categories = categoryService.list();
            System.out.println(categories);
            return "listCategory";
        }
    }
