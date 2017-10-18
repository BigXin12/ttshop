package com.cx.ttshop.service;

import com.cx.common.dto.Page;
import com.cx.common.dto.Result;
import com.cx.ttshop.pojo.po.TbItem;

import java.util.List;

public interface ItemService {
    TbItem getById(Long itemId);
    List<TbItem> itemList();
    Result<TbItem> itemListByPage(Page page);
}
