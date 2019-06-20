package com.tl.controller;

import com.tl.pojo.TbItem;
import com.tl.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
    商品管理Controller
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    //@PathVariable 根据路径取Id
    public TbItem getItemById(@PathVariable Long itemId){
        TbItem item = itemService.getItemById(itemId);
        return item;
    }

}
