package service;

import dao.CategoryDAO;
import dao.ConfigDAO;
import dao.RecordDAO;
import entity.Category;
import entity.Config;
import entity.Record;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * Created by 王宁 on 2017/5/2.
 */
public class CategoryService {
    CategoryDAO ctdao= new CategoryDAO();
    RecordDAO rcdao = new RecordDAO();
    public List<Category> list(){
        List<Category> cs = ctdao.list();
        for(Category c:cs){
            List<Record> rs = rcdao.list();
            c.recordNumber = rs.size();
        }
        Collections.sort(cs,(c1,c2)->c2.recordNumber-c1.recordNumber);//Lambda表达式- -不是很懂

        return cs;
    }

    public void add(String name) {
        Category c = new Category();
        c.setName(name);
        ctdao.add(c);
    }

    public void update(int id, String name){
        Category c = new Category();
        c.setName(name);
        c.setId(id);
        ctdao.update(c);

    }

    public void delete(int id) {

        ctdao.delete(id);

    }
}
