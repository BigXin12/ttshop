package com.cx.common.dto;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String sort;
    private String order;
    private String orderParams;

    public void setOrderParams(String orderParams) {
        this.orderParams = orderParams;
    }

    public List<String> getOrderParams() {
        String[] sort = this.sort.split(",");
        String[] order = this.order.split(",");
        List<String> list = new ArrayList<String>();
        for(int i=0;i<sort.length;i++){
            String temp = sort[i]+" "+order[i];
            list.add(temp);
        }
        return list;
    }


    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
