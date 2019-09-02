package com.qingcheng.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果
 * @author wxy
 * @date 2019/9/2
 * @time 19:41
 */
public class PageResult<T> implements Serializable {
    private Long total;//记录数
    private List<T> rows;//结果集

    public PageResult() {
    }

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
