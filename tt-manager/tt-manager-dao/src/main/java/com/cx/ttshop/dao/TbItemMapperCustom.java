package com.cx.ttshop.dao;

import com.cx.common.dto.Page;
import com.cx.ttshop.pojo.po.TbItem;

import java.util.List;

public interface TbItemMapperCustom{
    //分页查询
    List<TbItem> selectByPage(Page page);
   long countItems();
}
