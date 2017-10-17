package com.cx.ttshop.service.impl;

import com.cx.ttshop.dao.TbItemMapper;
import com.cx.ttshop.pojo.po.TbItem;
import com.cx.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper map;

    @Override
    public TbItem getById(Long itemId) {
        TbItem item = map.selectByPrimaryKey(itemId);
        return item;
    }
}
