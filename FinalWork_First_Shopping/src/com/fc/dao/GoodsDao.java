package com.fc.dao;

import com.fc.exercise.Goods;

import java.sql.*;

public class GoodsDao {
    public Goods setGoods(int gid) throws ClassNotFoundException {
        Goods goods = new Goods();

        Class.forName("com.mysql.jdbc.Driver");
        String db_url = "jdbc:mysql://localhost:3306/web_test?&useSSL=false&serverTimezone=UTC" ;
        String user = "root";
        String pwd = "goodgoodstudy";
        Connection connection =null;//建立数据的连接
        Statement statement = null; //数据库的操作对象
        ResultSet resultSet= null;//数据库的结果集

        try {
            connection = DriverManager.getConnection(db_url, user, pwd);
            statement = connection.createStatement();

            String sql = "select gName , gPrice from goods where gid = " + "'" + gid + "'";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                goods.setGid(gid);
                goods.setGname(resultSet.getString("gName"));
                goods.setGprice(resultSet.getDouble("gPrice"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
        }
        return goods;
    }

}
