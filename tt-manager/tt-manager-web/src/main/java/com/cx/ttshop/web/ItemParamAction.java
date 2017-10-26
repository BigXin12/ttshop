package com.cx.ttshop.web;

import com.cx.common.dto.Page;
import com.cx.common.dto.Result;
import com.cx.ttshop.pojo.vo.TbItemParamCustomer;
import com.cx.ttshop.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("prototype")
public class ItemParamAction {

    @Autowired
    private ItemParamService itemParamService;

    @RequestMapping("/itemParams")
    @ResponseBody
    public Result<TbItemParamCustomer> listItemParams(Page page){
        Result<TbItemParamCustomer> rs = itemParamService.listItemParams(page);
        return rs;
    }

    @RequestMapping("itemParam/{cid}")
    @ResponseBody
    public int saveItemParam(@PathVariable("cid") Long cid, @RequestParam("paramData") String paramData){
        int count = itemParamService.saveItemParam(cid, paramData);
        return count;
    }


}
