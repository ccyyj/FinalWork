package com.fc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.fc.dao.StudentMapper;
import com.fc.entity.Student;
import com.fc.service.StudentService;
import com.fc.vo.ResultVO;
import com.fc.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 查询全部学生
     *
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<StudentVO> page(Integer page, Integer pageSize) {
        //开启分页
        PageHelper.startPage(page, pageSize);

        //获取学生集合
        List<StudentVO> list = studentMapper.findAll(null);
        //把集合放入分页里
        return new PageInfo<>(list);
    }

    /**
     * chaxunxues1
     *
     * @param findStudentByName
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<StudentVO> findByName(String findStudentByName, Integer page, Integer pageSize) {
        //开启分页
        PageHelper.startPage(page, pageSize);

        List<StudentVO> list = studentMapper.selectByExample(findStudentByName);

        System.out.println(list);

        //PageInfo<Student> studentPage = new PageInfo(list);
        return new PageInfo<StudentVO>(list);
    }

    @Override
    public ResultVO add(Student student) {
        ResultVO resultVO = new ResultVO();

        int affectedRows = studentMapper.insertSelective(student);

        if (affectedRows > 0) {
            resultVO.setErrorMsg("添加成功");
            resultVO.setFlag(true);
        } else {
            resultVO.setErrorMsg("添加失败");
            resultVO.setFlag(false);
        }
        return resultVO;
    }

    @Override
    public Student getByid(Integer userid) {
       return studentMapper.getById(userid);
    }

    @Override
    public void updateById(Integer userid, Student student) {
         studentMapper.updateByPrimaryKey(student);
    }

    @Override
    public void removeById(Integer id) {
        studentMapper.deleteByPrimaryKey(id);
    }
}
