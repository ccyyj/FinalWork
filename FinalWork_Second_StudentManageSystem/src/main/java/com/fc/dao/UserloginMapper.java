package com.fc.dao;

import com.fc.entity.Userlogin;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UserloginMapper {

    /**
     * 根据名字查询用户
     *
     * @param username
     * @return
     */
    List<Userlogin> selectByExample(String username);

}