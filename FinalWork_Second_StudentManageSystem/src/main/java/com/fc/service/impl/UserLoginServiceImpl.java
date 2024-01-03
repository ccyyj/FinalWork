package com.fc.service.impl;

import com.fc.dao.UserloginMapper;
import com.fc.entity.Userlogin;
import com.fc.service.UserLoginService;
import com.fc.vo.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserloginMapper userloginMapper;

    @Override
    public MessageVO login(String username, String password) {

        MessageVO vo = new MessageVO();

        vo.setCode(-1);
        vo.setMessage("登录失败，当前用户名不存在");
        vo.setSuccess(false);
        vo.setData(null);

        List<Userlogin> userlogins = userloginMapper.selectByExample(username);

        // 能查出来说明用户名是存在的
        if (userlogins.size() > 0) {
            Userlogin userlogin = userlogins.get(0);

            // 如果密码相同
            if (userlogin.getPassword().equals(password)) {
                vo.setSuccess(true);
                vo.setMessage("登录成功！");
                vo.setCode(200);
                vo.setData(userlogin);

                // 密码不要传给前端
                userlogin.setPassword(null);
            } else {

                vo.setCode(-200);
                vo.setMessage("登录失败，请输入正确的密码");
                vo.setSuccess(false);
                vo.setData(null);
            }
        }

        return vo;
    }

}




