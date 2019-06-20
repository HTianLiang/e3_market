package com.tl.controller;

import com.tl.common.pojo.EasyUITreeNode;
import com.tl.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*
    商品分类管理
 */
@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    //显示商品分类类目
    @RequestMapping("/item/cat/list")
    @ResponseBody
    /*
        @RequestParam(name = "id",defaultValue = "0") 指定传入参数名为：id.
        因第一次请求没有id值，所有设置默认值为：0
     */
    public List<EasyUITreeNode> getItemCatList(@RequestParam(name = "id",defaultValue = "0")Long parentId){
        //调用服务查询节点列表
        List<EasyUITreeNode> list = itemCatService.getItemCatList(parentId);
        return list;
    }

}
