package com.cx.ttshop.web;

import com.cx.common.dto.Order;
import com.cx.common.dto.Page;
import com.cx.common.dto.Result;
import com.cx.ttshop.pojo.po.TbItem;
import com.cx.ttshop.pojo.vo.TbItemCustom;
import com.cx.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * 展示商品列表
     * @param page
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/items")
    public Result<TbItemCustom> itemsList(Page page, Order order){
        return service.listItemByPage(page,order);
    }


    /**
     * 批量删除商品
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/item/batch",method = RequestMethod.POST)
    public int batchRemoveItem(@RequestParam("ids[]") List<Long> ids){
        return service.updateItemsByIds((byte)3,ids);
    }

    /**
     * 批量上架商品
     */
    @ResponseBody
    @RequestMapping(value = "/item/up",method = RequestMethod.POST)
    public int batchUpItem(@RequestParam("ids[]") List<Long> ids){
        return service.updateItemsByIds((byte)1,ids);
    }

    /**
     * 批量下架商品
     */
    @ResponseBody
    @RequestMapping(value = "/item/down",method = RequestMethod.POST)
    public int batchDownItem(@RequestParam("ids[]") List<Long> ids){
        return service.updateItemsByIds((byte)2,ids);
    }

}
