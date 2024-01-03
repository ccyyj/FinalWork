package com.fc.dao;

import com.fc.entity.Student;

import java.util.List;

import com.fc.vo.StudentVO;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper {

    /**
     * 查询全部
     *
     * @param o
     * @return
     */
    List<StudentVO> findAll(Object o);

    /**
     * 名字查找
     *
     * @param findStudentByName
     * @return
     */
    List<StudentVO> selectByExample(String findStudentByName);

    /**
     * 新增学生
     *
     * @param student
     * @return
     */
    int insertSelective(Student student);

    /**
     * 根据id查找学生
     *
     * @param userid
     * @return
     */
    Student getById(Integer userid);

    /**
     * 更新学生信息
     *
     * @param record
     */
    void updateByPrimaryKey(Student record);

    /**
     * 删除学生
     *
     * @param id
     */
    void deleteByPrimaryKey(Integer id);
}