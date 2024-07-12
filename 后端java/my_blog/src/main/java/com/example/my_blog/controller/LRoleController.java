package com.example.my_blog.controller;

import com.example.my_blog.common.Result;
import com.example.my_blog.common.ResultInfo;
import com.example.my_blog.dto.LRoleIsDisableDto;
import com.example.my_blog.model.LRole;
import com.example.my_blog.service.LRoleService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/12/10
 */
@RestController
public class LRoleController {
    @Autowired
    LRoleService lRoleService;

    @GetMapping("/role/roleList")
    public Result list(){
        return  Result.success().data(lRoleService.roleList()).codeAndMessage(ResultInfo.SUCCESS);
    }

    @RequiresRoles({"admin"})
    @PostMapping("/role/add")
    public Result add(@RequestBody LRole lRole){
        lRole.setCreateTime(new Date());
        lRole.setIsDisable(0);
        if (lRoleService.addRole(lRole)){
            return Result.success().codeAndMessage(ResultInfo.SUCCESS);
        }else {
            return Result.error().codeAndMessage(ResultInfo.FAILED);
        }
    }

    @RequiresRoles({"admin"})
    @GetMapping("/role/delete/{id}")
    public Result delete(@PathVariable("id") Integer id){
        if (lRoleService.deleteById(id)){
            return Result.success().codeAndMessage(ResultInfo.SUCCESS);
        }else {
            return Result.error().codeAndMessage(ResultInfo.FAILED);
        }
    }

    @RequiresRoles({"admin"})
    @PostMapping("/role/updateIsDisable")
    public Result add(@RequestBody LRoleIsDisableDto lRoleIsDisable){
        if (lRoleService.updateIsDisable(lRoleIsDisable)){
            return Result.success().codeAndMessage(ResultInfo.SUCCESS);
        }else {
            return Result.error().codeAndMessage(ResultInfo.FAILED);
        }
    }
}
