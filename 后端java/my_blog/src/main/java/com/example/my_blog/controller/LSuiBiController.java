package com.example.my_blog.controller;

import com.example.my_blog.common.Result;
import com.example.my_blog.common.ResultInfo;
import com.example.my_blog.model.LSuibi;
import com.example.my_blog.service.LSuiBiService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/suibi")
public class LSuiBiController {
    @Autowired
    LSuiBiService lSuiBiService;

    @GetMapping("/getAll")
    public Result getByText(String search){
        return Result.success().code(200).message("ok").data(lSuiBiService.getAll(search));
    }

    @RequiresRoles({"admin"})
    @PostMapping("add")
    public Result addSuiBi(@RequestBody LSuibi lSuibi){
        lSuibi.setSuibiCtime(new Date());
        if(lSuiBiService.addSuiBi(lSuibi)){
            return Result.success().code(200).message("添加成功");
        }else {
            return Result.error().code(400).message("失败");
        }
    }

    @RequiresRoles({"admin"})
    @PostMapping("/update")
    public Result updateSuiBi(@RequestBody LSuibi lSuibi){
        if(lSuiBiService.updateSuiBi(lSuibi)){
            return Result.success().code(200).message("修改成功");
        }else {
            return Result.error().code(400).message("失败");
        }
    }

    @RequiresRoles({"admin"})
    @GetMapping("/delete")
    public Result deleteSuiBi(@RequestParam("id") Integer id){
        if (lSuiBiService.deleteSuiBi(id)){
            return Result.success().codeAndMessage(ResultInfo.SUCCESS);
        }else {
            return Result.error().codeAndMessage(ResultInfo.FAILED);
        }
    }

}
