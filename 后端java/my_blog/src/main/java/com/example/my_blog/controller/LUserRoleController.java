package com.example.my_blog.controller;

import com.example.my_blog.common.Result;
import com.example.my_blog.model.LUserRole;
import com.example.my_blog.service.LUserRoleService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/12/12
 */
@RestController
public class LUserRoleController {
    @Autowired
    LUserRoleService lUserRoleService;

    @RequiresRoles({"admin"})
    @PostMapping("/userRole/add")
    public Result add(@RequestBody LUserRole lUserRole){
        if (lUserRoleService.addUserRole(lUserRole)){
            return Result.success().code(200).message("添加成功");
        }else {
            return Result.error().code(400).message("添加失败");
        }
    }

    @RequiresRoles({"admin"})
    @PostMapping ("/userRole/delete")
    public Result delete(@RequestBody LUserRole lUserRole){
        if (lUserRoleService.deleteById(lUserRole)){
            return Result.success().code(200).message("删除成功");
        }else {
            return Result.error().code(400).message("删除失败");
        }
    }
}
