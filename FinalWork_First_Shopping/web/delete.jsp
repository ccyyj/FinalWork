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
    String sql= "DELETE FROM goods where gName='红米K30Pro';";
    int i = stmt.executeUpdate(sql);//删除使用executeUpdate方法，返回值为删除行数
    out.println("成功删除"+i+"行数据");
    stmt.close();
    conn.close();
%>
</body>
</html>