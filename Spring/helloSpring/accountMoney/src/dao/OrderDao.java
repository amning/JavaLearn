package dao;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by 王宁 on 2017/6/10.
 */
public class OrderDao {
    private JdbcTemplate jdbcTemplate;
    public void add(){
        System.out.println("dao.add");
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //增加钱数

    public void lessMoney(int money,String lessMoneyName){
        String sql="UPDATE _user set money=money-? where username=?";
        jdbcTemplate.update(sql,money,lessMoneyName);
    }
    //减少钱数
    public void moreMoney(int money,String moreMoneyName){
        String sql="UPDATE _user set money=money+? where username=?";
        jdbcTemplate.update(sql,money,moreMoneyName);
    }
}
