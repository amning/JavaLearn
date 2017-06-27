package service;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 王宁 on 2017/6/6.
 */
@Service(value ="service")
public class UserService {
    //1.定义dao类型的属性
    //在dao的属性上完成对象的注入

    @Resource(name = "dao")//自动装配
    //name 属性值写注解创建dao对象value值
    private UserDao userDao;
    //注解方式不需要set方法
    public void add(){
        System.out.println("service...");
        userDao.add();
    }
}
