package com.tl.service;

import com.tl.common.pojo.EasyUITreeNode;

import java.util.List;

public interface ItemCatService {
    //查询商品分类类目
    List<EasyUITreeNode> getItemCatList(long parentId);
}
