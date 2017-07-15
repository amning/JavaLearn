package hello.dao;

import hello.entity.User;

import java.util.List;

/**
 * Created by 王宁 on 2017/7/11.
 */
public interface UserDao {
public User getUserById(int id);
public List<User> selectUsers(String userName);
public void addUser(User user);
public void updateUser(User user);
public void deleteUser(int id);

    void delUserById();

    void getUserByName();

    void getAll();
//public List<Article> getUserArticles(int id);
}
