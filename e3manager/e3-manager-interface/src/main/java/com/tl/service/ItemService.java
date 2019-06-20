package com.tl.service;

import com.tl.common.pojo.EasyUIDataGridResult;
import com.tl.pojo.TbItem;

public interface ItemService {
    //根据Id查询商品信息（测试）
    TbItem getItemById(Long itemId);
    //查询分页
    EasyUIDataGridResult getItemList(int page, int rows);
}
