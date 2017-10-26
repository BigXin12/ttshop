package com.cx.common.dto;

import java.util.List;

/**
 * 专门用于easyui的datagrid通用分页类(响应参数)
 * User: DHC
 * Date: 2017/10/18
 * Time: 15:33
 * Version:V1.0
 */
public class Result<T> {
    //符合查询条件的总条数
    private long total;
    //分页后的某页查询出来的数据集合
    private List<T> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
