package com.fc.servlet;

import com.fc.dao.GoodsDao;
import com.fc.exercise.Cart;
import com.fc.exercise.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        String gid=req.getParameter("gid");
        String gcount=req.getParameter("gcount");
        if(gid!=null&&gcount!=null) {
            Goods goods=new Goods();
            GoodsDao goodsdao=new GoodsDao();
//通过GoodsDao获取商品信息，并封装成一个商品对象
            try {
                goods=goodsdao.setGoods(Integer.parseInt(gid));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            goods.setGcount(Integer.parseInt(gcount));
            HttpSession session=req.getSession();
            Cart cart=(Cart)session.getAttribute("cart");//读取session中cart属性值
            if(cart!=null) {/*如果cart属性值不为空，则不是第一次添加，直接调用cart对象的addGoods方法*/
                cart.addGoods(goods);
            }else {/*如果为空，表示当前是第一次添加商品，应先新建一个购物车对象再添加商品*/
                cart=new Cart();
                cart.addGoods(goods);
            }
            session.setAttribute("cart", cart);
            resp.getWriter().println("添加成功");
            resp.getWriter().println("<a href='cart.jsp'> 查看购物车</a>");
            resp.getWriter().println("<a href='javascript:history.back(-1)'> 返回上一页</a>");
        }else {
            resp.getWriter().println("参数不正确");
            resp.getWriter().println("<a href='javascript:history.back(-1)'> 返回上一页</a>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
