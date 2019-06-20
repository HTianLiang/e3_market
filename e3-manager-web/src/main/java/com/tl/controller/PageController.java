package com.tl.controller;

import com.tl.common.pojo.EasyUIDataGridResult;
import com.tl.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
    页面跳转Controller
 */
@Controller
public class PageController {

    @Autowired
    private ItemService itemService;

    //显示后台管理系统首页
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    //显示新增、查询...功能页面
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }

    //查询商品功能
    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page,Integer rows){
        //调用服务查询商品列表
        EasyUIDataGridResult result = itemService.getItemList(page, rows);
        return result;
    }

}
