package jdbc.DAO;

import jdbc.Hero;

import java.sql.*;
import java.util.List;

/**
 * Created by 王宁 on 2017/4/18.
 */
public class HeroDao implements DAO{
    HeroDao(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("初始化成功");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demobase?characterEncoding=UTF-8",
                "root","wangning");
    }
    public int getTotal(){
        int total =0;
        try(Connection c =getConnection();
            Statement s = c.createStatement();
            ){
            String sql = "select count (*) from hero";

            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                total = rs.getInt(1);
            }
            System.out.println("total:"+total);

        }catch (SQLException e ){
                e.printStackTrace();
        }
    }
    @Override
    public void add(Hero hero) {
        String sql ="insert into hero values(null,?,?,?)";

        try(Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement(sql);){

        }catch(SQLException e){
                e.printStackTrace();
        }


    }

    @Override
    public void update(Hero hero) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Hero get(int id) {
        return null;
    }

    @Override
    public List<Hero> list() {
        return null;
    }

    @Override
    public List<Hero> list(int start, int count) {
        return null;
    }
}
