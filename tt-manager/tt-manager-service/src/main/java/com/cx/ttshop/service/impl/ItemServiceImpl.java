package com.cx.ttshop.service.impl;

import com.cx.common.dto.Page;
import com.cx.common.dto.Result;
import com.cx.ttshop.dao.TbItemMapper;
import com.cx.ttshop.dao.TbItemMapperCustom;
import com.cx.ttshop.pojo.po.TbItem;
import com.cx.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper map;
    @Autowired
    private TbItemMapperCustom map2;

    @Override
    public TbItem getById(Long itemId) {
        TbItem item = map.selectByPrimaryKey(itemId);
        return item;
    }

    @Override
    public List<TbItem> itemList() {
        return map.selectByExample(null);
    }

    @Override
    public Result<TbItem> itemListByPage(Page page) {
        List<TbItem> list = map2.selectByPage(page);
        long count  = map2.countItems();

        Result<TbItem> result = new Result<TbItem>();
        result.setRows(list);
        result.setTotal(count);

        return result;
    }
}
