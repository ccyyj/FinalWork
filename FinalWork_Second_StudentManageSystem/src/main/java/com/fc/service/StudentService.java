package com.fc.service;

import com.github.pagehelper.PageInfo;
import com.fc.entity.Student;

import com.fc.vo.ResultVO;
import com.fc.vo.StudentVO;

public interface StudentService {

    /**
     * 查询全部学生
     *
     * @param page
     * @param pageSize
     * @return
     */
    PageInfo<StudentVO> page(Integer page, Integer pageSize);

    /**
     * 查询学生
     *
     * @param findStudentByName
     * @param page
     * @param pageSize
     * @return
     */
    PageInfo<StudentVO> findByName(String findStudentByName, Integer page, Integer pageSize);

    /**
     * 新增学生
     *
     * @param student
     * @return
     */
    ResultVO add(Student student);

    /**
     * 根据id查询学生
     *
     * @param userid
     * @return
     */
    Student getByid(Integer userid);

    /**
     * 更新学生信息
     *
     * @param userid
     * @param student
     */
    void updateById(Integer userid, Student student);

    /**
     * 删除学生
     *
     * @param id
     */
    void removeById(Integer id);
}
