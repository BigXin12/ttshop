package com.cx.ttshop.web;

import com.cx.ttshop.pojo.po.TbItem;
import com.cx.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("prototype")
public class ItemAction {

    @Autowired
    private ItemService service;

    @RequestMapping(value = "/item/{TbItem.id}",method = RequestMethod.GET)
    @ResponseBody
    public TbItem getById(Long ItemId){
        System.out.println(ItemId);
        TbItem tbItem = service.getById(ItemId);
        return tbItem;
    }

}
