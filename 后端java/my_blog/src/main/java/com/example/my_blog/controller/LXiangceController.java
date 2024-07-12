package com.example.my_blog.controller;

import com.example.my_blog.common.Page;
import com.example.my_blog.common.Result;
import com.example.my_blog.dto.XiangCeDto;
import com.example.my_blog.model.LXiangce;
import com.example.my_blog.service.LXiangceService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/xc")
public class LXiangceController {
    @Autowired
    LXiangceService lXiangceService;

    @RequiresRoles({"admin"})
    @PostMapping("/add")
    public Result addXiangCe(@RequestBody LXiangce lXiangce){
        lXiangce.setXcCtime(new Date());
        lXiangce.setXcDelete(0);
        if (lXiangceService.addXC(lXiangce)){
            return Result.success().code(200).message("添加成功");
        }else {
            return Result.error().code(400).message("添加失败");
        }
    }

//后台管理系统获取的相册列
    @GetMapping("/allList")
    public Result getAllList(@RequestParam("search") String search){
        return Result.success().data(lXiangceService.getXiangCeList(search)).code(200).message("获取成功");
    }

    @RequiresRoles({"admin"})
    @PostMapping("/update")
    public Result updateXiangCe(@RequestBody LXiangce lXiangce){
        if (lXiangceService.updateXiangce(lXiangce)){
            return Result.success().code(200).message("修改成功");
        }else {
            return Result.error().code(400).message("失败");
        }
    }

//    @GetMapping("/list")
//    public Result getList(String search){
//        return Result.success().data(lXiangceService.getList(search)).code(200).message("获取成功");
//    }

    @GetMapping({"/list/{xcType}", "/list"})
    public Result getListByType(@PathVariable(value = "xcType",required = false) Integer xcType,@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        return Result.success().data(lXiangceService.getListByTypeId(xcType,pageNum,pageSize)).code(200).message("获取成功");
    }

    @RequiresRoles({"admin"})
    @PostMapping("/upDelete")
    public Result deleteXiangce(@RequestBody XiangCeDto xiangCeDto){
        if (lXiangceService.updateXiangceDelete(xiangCeDto)){
            return Result.success().code(200).message("删除成功");
        }else {
            return Result.error().code(400).message("失败");
        }
    }

    @RequiresRoles({"admin"})
    @PostMapping("/hsxc")
    public Result HuiShouXiangce(@RequestBody XiangCeDto xiangCeDto){
        if (lXiangceService.updateXiangceDelete(xiangCeDto)){
            return Result.success().code(200).message("回收成功");
        }else {
            return Result.error().code(400).message("失败");
        }
    }

    @RequiresRoles({"admin"})
    @GetMapping("/delete/{id}")
    public Result deleteXiangce(@PathVariable("id") Integer id){
        if (lXiangceService.foreverDeleteXiangce(id)){
            return Result.success().code(200).message("删除成功");
        }else {
            return Result.error().code(400).message("删除失败");
        }
    }

}
