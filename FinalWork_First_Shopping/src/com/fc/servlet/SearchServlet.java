package com.fc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fc.exercise.Goods;
import net.sf.json.JSONArray;


@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SearchServlet() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-type", "text/plain;charset=utf-8");
        String goodsname=request.getParameter("goodsname");
        ArrayList<Goods> goodsList  = null;
        if(goodsname!=null&&goodsname.equals("华为")) {
            //此处为了演示，假设搜索的是华为手机商品
            Goods goods1=new Goods();
            Goods goods2=new Goods();
            goods1.setGname("华为P30");
            goods1.setGid(1001);
            goods1.setGprice(3000.00);
            goods2.setGname("华为P40");
            goods2.setGid(1002);
            goods2.setGprice(4000.00);
            goodsList=new ArrayList<Goods>();
            goodsList.add(goods1);
            goodsList.add(goods2);
        }
        JSONArray goodsListJsonObject = new JSONArray();
        if(goodsList!=null&&goodsList.size()!=0) {
            //将JAVA集合对象转换为JSON数组
            goodsListJsonObject = JSONArray.fromObject(goodsList);
        }
        //将JSON数组对象转换为字符串
        String resultString=goodsListJsonObject.toString();
        PrintWriter out=response.getWriter();
        //向前端页面返回响应，格式为JSON字符串
        out.print(resultString);
        out.flush();
        out.close();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

}
