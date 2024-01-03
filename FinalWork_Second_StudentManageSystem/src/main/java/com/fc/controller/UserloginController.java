package com.fc.controller;

import com.fc.entity.Userlogin;
import com.fc.service.UserLoginService;
import com.fc.vo.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserloginController {
    @Autowired
    private UserLoginService userloginService;

    /**
     * 登录
     *
     * @param userlogin
     * @param mv
     * @param session
     * @return
     */
    @PostMapping("login")
    public ModelAndView login(Userlogin userlogin, ModelAndView mv, HttpSession session) {
        // 通过vo封装获取账户密码
        MessageVO vo = userloginService.login(userlogin.getUsername(), userlogin.getPassword());
        //admin login
        //账户密码存到session中
        session.setAttribute("userlogin", vo.getData());

        mv.addObject("resultInfo", vo);

        mv.setViewName("redirect:/admin/showStudent");

        return mv;
    }

    /**
     * 退出登录
     *
     * @param session
     * @param response
     * @param mv
     * @return
     */
    @GetMapping("logout")
    public ModelAndView logout(HttpSession session, HttpServletResponse response, ModelAndView mv) {

        Cookie cookie = new Cookie("JSESSIONID", null);

        // 立即销毁cookie
        cookie.setMaxAge(0);

        response.addCookie(cookie);

        session.removeAttribute("userlogin");

        // 销毁session
        session.invalidate();

        // 重定向到登录页面
        mv.setViewName("redirect:/login.jsp");
        return mv;
    }


}
