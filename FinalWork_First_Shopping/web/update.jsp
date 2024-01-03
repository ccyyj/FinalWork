<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<%
    Class.forName("com.mysql.jdbc.Driver");
    String db_url = "jdbc:mysql://localhost:3306/web_test?&useSSL=false&serverTimezone=UTC" ;
    String user = "root";
    String pwd = "goodgoodstudy";

    Connection conn= DriverManager.getConnection(db_url,user,pwd);
    Statement stmt = conn.createStatement();
    String sql= "UPDATE goods SET gPrice='2499.00' where gName='红米K30Pro'";
    int i = stmt.executeUpdate(sql);//修改时使用executeUpdate方法，返回值为修改的行数
    out.println("成功修改"+i+"行数据");
    stmt.close();
    conn.close();
%>
</body>
</html>