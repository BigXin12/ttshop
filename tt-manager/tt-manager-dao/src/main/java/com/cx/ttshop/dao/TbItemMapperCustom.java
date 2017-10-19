package com.cx.ttshop.dao;

import com.cx.common.dto.Page;
import com.cx.ttshop.pojo.po.TbItem;
import com.cx.ttshop.pojo.vo.TbItemCustom;

import java.util.List;

public interface TbItemMapperCustom{
    //分页查询

   long countItems();
   List<TbItemCustom> listItemByPage(Page page);

}
