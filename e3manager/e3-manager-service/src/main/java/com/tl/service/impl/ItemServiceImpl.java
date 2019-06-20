package com.tl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tl.common.pojo.EasyUIDataGridResult;
import com.tl.mapper.TbItemMapper;
import com.tl.pojo.TbItem;
import com.tl.pojo.TbItemExample;
import com.tl.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
    商品管理
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public TbItem getItemById(Long itemId) {
        //根据主键查询
        //TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);

        //根据条件查询
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(itemId);
        //执行查询
        List<TbItem> list = itemMapper.selectByExample(example);
        if (list != null && list.size()>0){
            return list.get(0);
        }

        return null;
    }

    @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {
        //设置分页信息
        PageHelper.startPage(page,rows);
        //执行查询
        TbItemExample example = new TbItemExample();
        List<TbItem> list = itemMapper.selectByExample(example);
        //创建一个返回值对象
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        //取分页结果
        result.setRows(list);
        //取总记录数
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        result.setTotal(total);
        return result;
    }
}
