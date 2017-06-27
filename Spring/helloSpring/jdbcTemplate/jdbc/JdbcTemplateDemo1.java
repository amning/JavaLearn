package jdbc;

import bean.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.beans.PropertyVetoException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

/**
 * Created by 王宁 on 2017/6/8.
 */
public class JdbcTemplateDemo1 {

    public void list()  {

    }
    public void update(){
        //设置数据库信息
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/demobase");
        dataSource.setUsername("root");
        dataSource.setPassword("wangning");
        //创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql= "UPDATE _user set password=? where username=?";
        int rows=jdbcTemplate.update(sql,"ll333l","lei");
        if(rows==1)
            System.out.println("密码修改成功");
        else
            System.out.println("用户名不存在");
    }
    //@Test
    public void add(String userName,String password){
        //设置数据库信息
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/demobase");
        dataSource.setUsername("root");
        dataSource.setPassword("wangning");
        //创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //调用jdbcTemplate方法
        String sql="INSERT INTO _user values(?,?)";

        int rows=jdbcTemplate.update(sql,userName,password);
        System.out.println(rows);
    }

    public void delete(){
        //String username="lucy";
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/demobase");
        dataSource.setUsername("root");
        dataSource.setPassword("wangning");
        //创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //调用jdbcTemplate方法
        String sql="DELETE FROM _user where username=?";
        int rows=jdbcTemplate.update(sql,"lucy");
        System.out.println(rows);
    }
    //查询返回某个值

    public void allCount(){
        //String username="lucy";
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/demobase");
        dataSource.setUsername("root");
        dataSource.setPassword("wangning");
        //创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //调用jdbcTemplate方法
        String sql="SELECT COUNT(*) FROM _user";
        int count = jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println(count);
    }
    //查询单个数据库值

    public void count(String name){
        //String username="lucy";
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/demobase");
        dataSource.setUsername("root");
        dataSource.setPassword("wangning");
        //创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //调用jdbcTemplate方法
        String sql="SELECT * FROM _user where username=?";

        User user=jdbcTemplate.queryForObject(sql, new Row(),name);
       System.out.println(user);
    }
    public void countList(){
        //String username="lucy";
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/demobase");
        dataSource.setUsername("root");
        dataSource.setPassword("wangning");
        //创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //调用jdbcTemplate方法
        String sql="SELECT * FROM _user ";

        List<User> list =jdbcTemplate.query(sql,new Row());
        //System.out.println(list);
        for(User user:list){
            System.out.println(user.getUsername());
        }
    }
    public static void main(String[] args) {
        JdbcTemplateDemo1 demo=new JdbcTemplateDemo1();
      //  demo.add("lei","124");
      //demo.add("ad","452");
       demo.countList();
    }

}
class Row implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        String username=resultSet.getString("username");
        String password=resultSet.getString("password");

        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}