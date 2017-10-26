package com.cx.ttshop.dao;

import com.cx.ttshop.pojo.vo.TbItemParamCustomer;

import java.util.List;
import java.util.Map;

public interface TbItemParamCustomMapper {
    List<TbItemParamCustomer> listItemParamsByPage(Map<String, Object> map);

    long countItemParams(Map<String, Object> map);
}
