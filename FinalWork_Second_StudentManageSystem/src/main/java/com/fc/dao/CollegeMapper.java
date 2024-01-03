package com.fc.dao;

import com.fc.entity.College;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollegeMapper {
    /**
     * 查询全部课程
     *
     * @return
     */
    List<College> selectByExample();
}