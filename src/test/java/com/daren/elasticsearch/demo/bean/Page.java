package com.daren.elasticsearch.demo.bean;

import java.util.List;

/**
 * 作者：韩家富
 * 描述：
 */
public class Page<T> {
    private Long total;
    private List<T> pageInfo;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(List<T> pageInfo) {
        this.pageInfo = pageInfo;
    }
}
