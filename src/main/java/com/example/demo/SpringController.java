package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.webService.entity.Student;
import com.example.demo.webService.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Spring 前端控制
 * <p>
 * 通过这个返回正确，作对比
 */
@Controller
@Api(value = "SpringController", tags = { "用户管理接口" }, description = "测试Swagger")
public class SpringController {

    @Autowired
    private StudentService studentRestfulService;

    @ResponseBody
    @Produces({MediaType.APPLICATION_JSON + "charset='utf-8'"})
    @ApiOperation(value = "根据ID获取用户信息", notes = "根据ID获取用户信息")
    @RequestMapping(value = "getById/{id}", method = RequestMethod.GET)
    public String getStudent(@PathVariable("id") Integer id) {
        Student student = studentRestfulService.getStudent(id);
        Object json = JSONObject.toJSON(student);
        return json.toString();
    }

    @ResponseBody
    @ApiOperation(value = "获取用户信息列表", notes = "获取用户信息列表")
    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public Collection<Student> findAll() {
        return studentRestfulService.findAll();
    }

    @ResponseBody
    @ApiOperation(value = "根据ID删除用户", notes = "根据ID删除用户")
    @RequestMapping(value = "deleteById/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable("id") Integer id) {
        int result=studentRestfulService.deleteById(id);
        if (result >= 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }

    }

    @ResponseBody
    @ApiOperation(value = "增加新用户", notes = "增加新用户")
    @RequestMapping(value = "putStudent", method = RequestMethod.POST)
    public String putStudent(@RequestBody Student student) {
        int result=studentRestfulService.putStudent(student);
        if (result >= 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @ResponseBody
    @ApiOperation(value = "修改用户信息", notes = "修改用户信息")
    @RequestMapping(value = "UpdateStudent", method = RequestMethod.POST)
    public String UpdateById(@RequestBody Student student) {
        int result=studentRestfulService.UpdateStudent(student);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }
}
