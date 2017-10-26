package com.cx.ttshop.service;

import com.cx.common.dto.Page;
import com.cx.common.dto.Result;
import com.cx.ttshop.pojo.vo.TbItemParamCustomer;

public interface ItemParamService {
    Result<TbItemParamCustomer> listItemParams(Page page);

    int saveItemParam(Long cid,String paramData);
}
