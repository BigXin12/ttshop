package com.cx.ttshop.service;

import com.cx.common.dto.Order;
import com.cx.common.dto.Page;
import com.cx.common.dto.Result;
import com.cx.ttshop.pojo.po.TbItem;
import com.cx.ttshop.pojo.vo.TbItemCustom;
import com.cx.ttshop.pojo.vo.TbItemQuery;

import java.util.List;

public interface ItemService {
    TbItem getById(Long itemId);
    Result<TbItemCustom> listItemByPage(Page page, Order order, TbItemQuery query);
    int updateItemsByIds(byte b,List<Long> ids);

}
