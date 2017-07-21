package test;

import com.dao.DAOImpl;

import com.entity.Category;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by 王宁 on 2017/7/21.
 */
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration("classpath:applicationContext.xml")
    public class TestDemo {
        @Autowired
        DAOImpl dao;

        @Test
        public void delete() {
            DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
            List<Category> cs = (List<Category>) dao.findByCriteria(dc);
            for (Category c : cs) {
                System.out.println(c);
            }
        }

        @Test
        public void test() {
//            DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
//            List<Category> cs = (List<Category>) dao.findByCriteria(dc);
//
                    Category c = new Category();
                    c.setName("测试分类");
               dao.save(c);

        }
    }

