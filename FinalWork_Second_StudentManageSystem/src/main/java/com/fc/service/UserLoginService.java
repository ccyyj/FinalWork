package com.fc.service;

import com.fc.vo.MessageVO;

public interface UserLoginService {
    /**
     * 登录查询
     *
     * @param username
     * @param password
     * @return
     */
    MessageVO login(String username, String password);

}
