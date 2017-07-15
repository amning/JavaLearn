package hello.service;

import hello.entity.User;
import hello.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王宁 on 2017/7/13.
 */
public class UserService {
    public int addUser( User user){
        SqlSession sqlSession = null;
        int result=0;
        try {
            sqlSession = MybatisUtil.getSession();
            String statment="hello.entity.userMapper.addUser";
            result = sqlSession.insert(statment, user);
            sqlSession.commit();
            return result;
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("异常");
        }finally {
            sqlSession.close();
        }
        return result;
    }
    public int delUser(int id){
        SqlSession sqlSession = null;
        int result=0;
        try {
            sqlSession = MybatisUtil.getSession();
            String statment="hello.entity.userMapper.delUserById";
            result = sqlSession.delete(statment, id);
            sqlSession.commit();
            return result;
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("异常");
        }finally {
            sqlSession.close();
        }
        return result;
    }
    public List<User> getAll(){
        List<User> users = new ArrayList<User>();
        SqlSession sqlSession = null;
        int result=0;
        try {
            sqlSession = MybatisUtil.getSession();
            String statment="hello.entity.userMapper.getAll";
            users = sqlSession.selectList(statment);
            sqlSession.commit();
            return users;
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("异常");
        }finally {
            sqlSession.close();
        }
        return users;
    }
    public List<User> getUserByName(String username){
        List<User> users = new ArrayList<User>();
        SqlSession sqlSession = null;
        int result=0;
        try {
            sqlSession = MybatisUtil.getSession();
            String statment="hello.entity.userMapper.getUserByName";
            users = sqlSession.selectList(statment,username);
            sqlSession.commit();
            return users;
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("异常");
        }finally {
            sqlSession.close();
        }
        return users;
    }
    public void updateUser(User user){

        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSession();
            String statment="hello.entity.userMapper.updateUser";
            sqlSession.update(statment,user);
            //sqlSession.commit();

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("异常");
        }finally {
            sqlSession.close();
        }
     }
}
