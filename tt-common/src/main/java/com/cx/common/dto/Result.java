package com.cx.common.dto;

import java.util.List;

/**
 * 用于easyUI的datagrid通用分页类（响应参数）
 * @param <T>
 */
public class Result<T> {
    private long total;
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
