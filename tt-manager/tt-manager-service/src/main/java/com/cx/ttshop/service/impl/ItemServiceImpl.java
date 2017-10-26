package com.cx.ttshop.service.impl;

import com.cx.common.dto.Order;
import com.cx.common.dto.Page;
import com.cx.common.dto.Result;
import com.cx.common.utils.IDUtils;
import com.cx.ttshop.dao.TbItemDescMapper;
import com.cx.ttshop.dao.TbItemMapper;
import com.cx.ttshop.dao.TbItemMapperCustom;
import com.cx.ttshop.pojo.po.TbItem;
import com.cx.ttshop.pojo.po.TbItemDesc;
import com.cx.ttshop.pojo.po.TbItemDescExample;
import com.cx.ttshop.pojo.po.TbItemExample;
import com.cx.ttshop.pojo.vo.TbItemCustom;
import com.cx.ttshop.pojo.vo.TbItemQuery;
import com.cx.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper map;
    @Autowired
    private TbItemMapperCustom map2;
    @Autowired
    private TbItemDescMapper tbItemDescMapper;

    @Override
    public TbItem getById(Long itemId) {
        TbItem item = map.selectByPrimaryKey(itemId);
        return item;
    }

    @Override
    public Result<TbItemCustom> listItemByPage(Page page,Order order,TbItemQuery query) {
        Map<String,Object> m = new HashMap<String,Object>();
        m.put("page",page);
        m.put("order",order);
        m.put("query",query);
        List<TbItemCustom> list = map2.listItemByPage(m);
        long count = map2.countItems(m);

        Result<TbItemCustom> result = new Result<TbItemCustom>();
        result.setRows(list);
        result.setTotal(count);

        return result;
    }

    @Override
    public int updateItemsByIds(byte b,List<Long> ids) {
        TbItem record  = new TbItem();
        record.setStatus(b);
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return map.updateByExampleSelective(record,example);
    }

    @Override
    @Transactional
    public int saveItem(TbItem tbItem, String desc) {
        long id = IDUtils.getItemId();
        tbItem.setId(id);
        tbItem.setStatus((byte)1);
        tbItem.setCreated(new Date());
        tbItem.setUpdated(new Date());
        int count = map.insert(tbItem);

        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemId(id);
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setCreated(new Date());
        tbItemDesc.setUpdated(new Date());
        count += tbItemDescMapper.insert(tbItemDesc);

        return count;
    }
}
