<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    Class.forName("com.mysql.jdbc.Driver");
    String db_url = "jdbc:mysql://localhost:3306/web_test?&useSSL=false&serverTimezone=UTC" ;
    String user = "root";
    String pwd = "goodgoodstudy";
    Connection conn= DriverManager.getConnection(db_url,user,pwd);

    String gName=request.getParameter("gName");
    String gPrice=request.getParameter("gPrice");
    String sql= "INSERT INTO goods(gName,gPrice)VALUES(?,?)";
    PreparedStatement psmt=conn.prepareStatement(sql);
    psmt.setString(1,gName);
    psmt.setString(2,gPrice);
    int i = psmt.executeUpdate();
    out.println("成功添加"+i+"行数据");
    psmt.close();
    conn.close();
%>
</body>
</html>