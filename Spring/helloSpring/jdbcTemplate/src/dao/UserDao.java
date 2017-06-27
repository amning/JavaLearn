package dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by 王宁 on 2017/6/6.
 */

public class UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
    }
    public void add(){
       String sql="INSERT INTO _user values(null,?,?)";
       jdbcTemplate.update(sql,"任磊","111");
    }
}
