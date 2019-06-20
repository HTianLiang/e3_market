package com.tl.pageHelper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tl.mapper.TbItemMapper;
import com.tl.pojo.TbItem;
import com.tl.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PageHelperTest {

    @Test
    public void testPageHelper() throws Exception{
        //初始化spring容器
        ApplicationContext acx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        //从容器获得Mapper代理对象
        TbItemMapper itemMapper = acx.getBean(TbItemMapper.class);
        //执行sql语句之前设置分页信息 使用PageHelper的startPage方法
        PageHelper.startPage(1,10);
        //执行查询
        TbItemExample itemExample = new TbItemExample();
        List<TbItem> list = itemMapper.selectByExample(itemExample);
        //取分页信息，PageInfo
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo.getTotal());
        System.out.println(pageInfo.getPages());
        System.out.println(list.size());
    }

}
