package com.cx.ttshop.web;

import com.cx.ttshop.pojo.po.TbItem;
import com.cx.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("prototype")
public class ItemAction {

    @Autowired
    private ItemService service;

    @ResponseBody
    @RequestMapping(value = "/item/{itemId}",method = RequestMethod.GET)
    //    spring mvc中的@PathVariable是用来获得请求url中的动态参数的
    public TbItem getById(@PathVariable Long itemId){
        System.out.println(itemId);
        TbItem tbItem = service.getById(itemId);
        return tbItem;
    }

}
