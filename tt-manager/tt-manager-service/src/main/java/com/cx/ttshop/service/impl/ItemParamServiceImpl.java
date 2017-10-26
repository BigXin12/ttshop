package com.cx.ttshop.service.impl;

import com.cx.common.dto.Page;
import com.cx.common.dto.Result;
import com.cx.ttshop.dao.TbItemParamCustomMapper;
import com.cx.ttshop.dao.TbItemParamMapper;
import com.cx.ttshop.pojo.po.TbItemParam;
import com.cx.ttshop.pojo.vo.TbItemParamCustomer;
import com.cx.ttshop.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemParamServiceImpl implements ItemParamService{
    @Autowired
    private TbItemParamMapper tbItemParamMapper;
    @Autowired
    private TbItemParamCustomMapper tbItemParamMapperCustom;

    @Override
    public Result<TbItemParamCustomer> listItemParams(Page page) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("page", page);
        List<TbItemParamCustomer> list = tbItemParamMapperCustom.listItemParamsByPage(map);
        long counts = tbItemParamMapperCustom.countItemParams(map);
        Result<TbItemParamCustomer> rs = new Result<>();
        rs.setTotal(counts);
        rs.setRows(list);
        return rs;
    }

    @Override
    public int saveItemParam(Long cid, String paramData) {
        TbItemParam tbItemParam = new TbItemParam();
        tbItemParam.setItemCatId(cid);
        tbItemParam.setParamData(paramData);
        tbItemParam.setCreated(new Date());
        tbItemParam.setUpdated(new Date());
        return tbItemParamMapper.insert(tbItemParam);
    }
}
