package DAO;

import Bean.Hero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Class.forName;

/**
 * Created by 王宁 on 2017/4/21.
 * 准备一个HeroDAO，提供增加，删除，修改，查询等常规数据库操作方法
 */
public class HeroDAO {

    public HeroDAO() {
        //数据库初始化
        try {

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库初始化成功");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
        //建立数据库连接
        public Connection getConnection () throws SQLException{
            System.out.println("数据链接成功");
            return
                    DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/demobase?characterEncoding=UTF-8",
                            "root","wangning");

    }
    /*
    获取数据库元素总数
     */
    public int getTotal(){
        int total = 0;
        //建立数据库读取连接
        try(Connection c = getConnection();
            Statement s = c.createStatement();){
            String sql= "SELECT COUNT (*) FROM hero";
            ResultSet resultSet = s.executeQuery(sql);
            while (resultSet.next()){
                total= resultSet.getInt(1);
            }
            System.out.println("getTotal()SQL写入成功");
            System.out.println("total:"+total);

        }catch (SQLException e){
                e.printStackTrace();
        }
        return total;
    }
    /*
    增
     */
    public void add(Hero hero){
        String sql= "INSERT INTO hero VALUES (NULL ,?,?,?)";
        try(Connection c = getConnection();
           PreparedStatement ps = c.prepareStatement(sql)){
           ps.setString(1,hero.name);
           ps.setFloat(2,hero.hp);
           ps.setInt(3,hero.damage);
          // ps.setInt(4,hero.id);
           ps.execute();

           ResultSet rs = ps.getGeneratedKeys();
           if(rs.next()){
               int id = rs.getInt(1);
               hero.id=id;
           }
            System.out.println("数据库元素添加成功");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    /*
    改
     */
    public void upDate(Hero hero){
        String sql= "UPDATE hero SET name =?,hp=?,damage=?,where id =?";
        try(Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){
            ps.setString(1,hero.name);
            ps.setFloat(2,hero.hp);
            ps.setInt(3,hero.damage);
            ps.setInt(4,hero.id);
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                int id = rs.getInt(1);
                hero.id=id;
            }
            System.out.println("数据库更新成功");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /*
        根据id删除元素
    */
    public void delete(int id){
       try(Connection c = getConnection();
            Statement s = c.createStatement();){
            String sql= "DELETE FROM hero where id="+id;
           s.execute(sql);
           System.out.println("数据库元素： "+id+"  删除成功");
        }catch (SQLException e) {
           e.printStackTrace();
       }
    }
    /*
     根据id获取元素
 */
    public Hero get(int id){
        Hero hero=null;
        //建立数据库读取连接
        try(Connection c = getConnection();
            Statement s = c.createStatement();){
            String sql= "SELECT *FROM hero where id="+id;
            ResultSet resultSet = s.executeQuery(sql);
            if(resultSet.next()){
                hero = new Hero();
                hero.id= resultSet.getInt(1);
                hero.name = resultSet.getString(2);
                hero.hp = resultSet.getFloat(3);
                hero.damage = resultSet.getInt(4);
            }

            System.out.println("数据库元素： "+id+"  获取成功");
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return hero;
    }
    public List<Hero> list(){
        return list(0,Short.MAX_VALUE);
    }

    private List<Hero> list(int start, int count) {
        List<Hero> heros = new ArrayList<Hero>();

        String sql = "select * from hero order by id desc limit ?,? ";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Hero hero = new Hero();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                hero.id = id;
                hero.name = name;
                hero.hp = hp;
                hero.damage = damage;
                heros.add(hero);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        System.out.println("数据库列表成功");
        return heros;

    }

}
