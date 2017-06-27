package tmall.dao;

import tmall.bean.Category;
import tmall.bean.User;
import tmall.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王宁 on 2017/5/16.
 */
public class UserDao {
        public void add(User bean){
            String sql = "INSERT into user VALUES (null,?,?)";
            try(Connection c = DBUtil.getConnection();
                PreparedStatement s =c.prepareStatement(sql);
            ){
                s.setString(1,bean.getName());
                s.setString(2,bean.getPassword());
                s.execute();
                ResultSet rs = s.getGeneratedKeys();
                if(rs.next()){
                    int id =rs.getInt(1);
                    bean.setId(id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        public void delete(int id){
            try(Connection c = DBUtil.getConnection();
                Statement s = c.createStatement();){
                String sql = "delete FROM  category where id = "+id;
                s.execute(sql);
            }catch (SQLException e ){
            }
        }
        public void update(User bean){
            String sql= "update user set name = ?,password = ?, where id = ? ";
            try(Connection c = DBUtil.getConnection();
                PreparedStatement ps = c .prepareStatement(sql);
            ){

                ps.setString(1,bean.getName());
                ps.setString(2,bean.getPassword());
                ps.setInt(3,bean.getId());

                ps.execute();
            }catch (SQLException e ){
                e.printStackTrace();
            }
        }
        public List<User> list(int start, int count){
            List<User> beans = new ArrayList<User>();
            String sql = "SELECT *FROM category order by id DESC limit ?,?";
            try(Connection c = DBUtil.getConnection();
                PreparedStatement p = c.prepareStatement(sql);) {
                p.setInt(1,start);
                p.setInt(2,count);
                ResultSet rs = p.executeQuery();

                while (rs.next()){
                    User bean = new User();
                    int id = rs.getInt(1);

                    String name =rs.getString("name");
                    bean.setName(name);
                    String password = rs.getString("password");
                    bean.setId(id);
                    bean.setId(id);
                    beans.add(bean);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            return beans;
        }
        public User get(int id){
            User bean = null;
            try(Connection c = DBUtil.getConnection();
                Statement s = c.createStatement();
            ) {
                String sql = "SELECT *FROM user where id = "+id;
                ResultSet rs = s.executeQuery(sql);
                if(rs.next()){
                    bean = new User();
                    String name = rs.getString("name");
                    bean.setName(name);
                    String password = rs.getString("password");
                    bean.setPassword(password);
                    bean.setId(id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return bean;
        }
        /*
        在业务上，注册的时候，需要判断某个用户是否已经存在，账号密码是否正确等操作，
        UserDAO特别提供如下方法进行支持：根据用户名获取对象
         */
        public User get(String name){
            User bean = null;
            String sql="SELECT * from user where name = ?";
            try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);) {
                ps.setString(1,name);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    bean=new User();
                    int id = rs.getInt("id");
                    bean.setName(name);
                    String password = rs.getString("password");
                    bean.setPassword(password);
                    bean.setId(id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return bean;
        }
        public List<User> list(){
            return list(0,Short.MAX_VALUE);
        }
        /*
        根据账号和密码获取对象，
        这才是合理的判断账号密码是否正确的方式，
        而不是一下把所有的用户信息查出来，在内存中进行比较。
         */
        public User get(String name,String password){
            User bean= null;
            String sql = "SELECT * FROM user WHERE name =? and password =?";
            try(Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);) {
                ps.setString(1,name);
                ps.setString(2,password);
                ResultSet rs = ps.executeQuery();

                if(rs.next()){
                    bean = new User();
                    int id = rs.getInt("id");
                    bean.setName(name);
                    bean.setPassword(password);
                    bean.setId(id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return bean;
        }
        /*
        以boolean形式返回某个用户名是否已经存在
         */
        public boolean isExist(String name ){
            User user = get(name);
            /*
            boolean isExist=false;
            if(user!=null){
                isExist = true;
            }
            */
            return user!=null;//isExist;
        }
        public int getTotal(){
            int total = 0;
            try (Connection c = DBUtil.getConnection();
                 Statement s = c.createStatement();){
                String sql = "SELECT COUNT (*) FROM user";
                ResultSet rs = s.executeQuery(sql);
                while (rs.next()){
                    total=rs.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return total;
        }

       public static void main(String[] args) {


        }
    }

