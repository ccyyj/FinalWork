package com.fc.controller;

import com.github.pagehelper.PageInfo;
import com.fc.entity.College;
import com.fc.entity.Student;
import com.fc.service.CollegeService;
import com.fc.service.StudentService;
import com.fc.vo.ResultVO;
import com.fc.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CollegeService collegeService;

    /**
     * 查询全部
     *
     * @param page
     * @param pageSize
     * @param mv
     * @return
     */
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "showStudent")
    public ModelAndView showStudent(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                    ModelAndView mv) {

        PageInfo<StudentVO> pageInfo = studentService.page(page, pageSize);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("forward:/pages/admin/showStudent.jsp");

        return mv;
    }


    /**
     * 学生姓名模糊查询
     *
     * @param findByName
     * @param page
     * @param pageSize
     * @param mv
     * @return
     */
    @PostMapping("selectStudent")
    public ModelAndView selectStudent(String findByName,
                                      @RequestParam(value = "page", defaultValue = "1") Integer page,
                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                      ModelAndView mv) {

        //String findStudentByName = request.getParameter("findStudentByName");

        System.out.println(findByName);

        PageInfo<StudentVO> pageInfo = studentService.findByName(findByName, page, pageSize);

        mv.addObject("pageInfo", pageInfo);

        mv.setViewName("forward:/pages/admin/showStudent.jsp");

        return mv;
    }


    /**
     * 添加学生信息界面
     *
     * @param mv
     * @return
     */
    @GetMapping("addStudent")
    public ModelAndView addStudentShow(ModelAndView mv) {

        List<College> list = collegeService.findAll();

        mv.addObject("collegeList", list);

        mv.setViewName("forward:/pages/admin/addStudent.jsp");

        return mv;
    }


    /**
     * 添加学生信息
     *
     * @param student
     * @param mv
     * @return
     */
    @PostMapping("addStudent")
    public ModelAndView addStudent(Student student, ModelAndView mv) {

        Student stu = studentService.getByid(student.getUserid());

        if (stu != null) {
            mv.addObject("message", "学号重复");
            //添加失败后转发到指定位置
            mv.setViewName("forward:/pages/error.jsp");
        }

        ResultVO resultVO = studentService.add(student);
        if (resultVO.getFlag() == true)
            //添加成功后重定向
            mv.setViewName("redirect:/admin/showStudent");
        else
            mv.setViewName("forward:/pages/error.jsp");
        return mv;
    }


    /**
     * 根据查询
     *
     * @param id
     * @param mv
     * @return
     * @throws Exception
     */
    @GetMapping("editStudent")
    public ModelAndView editStudentShow(Integer id, ModelAndView mv) throws Exception {
        if (id == null) {

            mv.setViewName("redirect:/admin/showStudent");

            return mv;
        }


        //查询所有系别
        List<College> list = collegeService.findAll();

        //查找学生
        Student student = studentService.getByid(id);

        mv.addObject("collegeList", list);
        mv.addObject("student", student);

        mv.setViewName("forward:/pages/admin/editStudent.jsp");

        return mv;

    }


    /**
     * 修改学生信息
     *
     * @param student
     * @param mv
     * @return
     */
    @PostMapping("editStudent")
    public ModelAndView editStudent(Student student, ModelAndView mv) {

        studentService.updateById(student.getUserid(), student);

        mv.setViewName("redirect:/admin/showStudent");

        return mv;
    }


    /**
     * 删除学生
     *
     * @param id
     * @param mv
     * @return
     */
    @GetMapping("removeStudent")
    public ModelAndView removeStudent(Integer id, ModelAndView mv) {
        if (id == null) {
            mv.setViewName("redirect:/admin/showStudent");

            return mv;
        }

        studentService.removeById(id);

        mv.setViewName("redirect:/admin/showStudent");

        return mv;
    }
}