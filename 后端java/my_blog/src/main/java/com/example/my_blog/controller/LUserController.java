package com.example.my_blog.controller;

import com.example.my_blog.common.Result;
import com.example.my_blog.common.ResultInfo;
import com.example.my_blog.dto.LRoleIsDisableDto;
import com.example.my_blog.dto.LoginDto;
import com.example.my_blog.dto.UserDto;
import com.example.my_blog.model.LUser;
import com.example.my_blog.service.LUserService;
import com.example.my_blog.utils.JWTUtil;
import com.example.my_blog.utils.UserTokenUtil;
import com.example.my_blog.vo.UserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/12/9
 */
@RestController
public class LUserController {
    @Autowired
    LUserService lUserService;

    @Resource
    private UserTokenUtil tokenUtil;

    @GetMapping("/user/userList")
    public Result list(){
        return Result.success().data(lUserService.getUserList()).codeAndMessage(ResultInfo.SUCCESS);
    }

//    创建用户
    @RequiresRoles({"admin"})
    @PostMapping("/user/add")
    public Result add(@RequestBody UserDto userDto){
        userDto.setCreateTime(new Date());
//        System.out.println(userDto);
        if (lUserService.addUser(userDto)){
            return Result.success().codeAndMessage(ResultInfo.SUCCESS);
        }else {
            return Result.error().code(400).message("创建用户失败，错误原因：用户名已经存在！");
        }
    }

    @RequiresRoles({"admin"})
    @GetMapping("/user/delete/{id}")
    public Result delete(@PathVariable("id") Integer id){
        if (lUserService.deleteById(id)){
            return Result.success().codeAndMessage(ResultInfo.SUCCESS);
        }else {
            return Result.error().codeAndMessage(ResultInfo.FAILED);
        }
    }

    @PostMapping("/login")
    public Result login(@RequestBody LoginDto loginDto) {
        Subject subject = SecurityUtils.getSubject();
        UserVo user = lUserService.getUserByName(loginDto.getUsername());
        if (user==null) {
            return Result.error().code(400).message("用户名不存在");
        }
        try{
            subject.login(new UsernamePasswordToken(loginDto.getUsername(), loginDto.getPassword()));
            HashMap m=new HashMap();
            m.put("id",user.getId());
            m.put("token",tokenUtil.createToken(loginDto.getUsername()));
            return Result.success().data(m).code(200).message("登录成功");
        }catch (IncorrectCredentialsException e){
            return Result.error().code(400).message("密码错误");
        }
    }

    @GetMapping("/user/{id}")
    public Result getById(@PathVariable("id") Integer id){
        LUser userById = lUserService.getUserById(id);
        HashMap m=new HashMap();
        m.put("image",userById.getUserQq());
        m.put("nickname",userById.getNickname());
        return Result.success().data(m).codeAndMessage(ResultInfo.SUCCESS);
    }


    @RequiresRoles({"admin"})
    @GetMapping("/getRoles")
    public Result getAl(String username){
        return Result.success().data(lUserService.getUserByNameAndRolesAndPs(username)).codeAndMessage(ResultInfo.SUCCESS);
    }

}
