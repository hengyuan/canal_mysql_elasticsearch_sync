package com.daren.elasticsearch.demo.dao;

import com.daren.elasticsearch.demo.bean.GoodInfo;
import com.daren.elasticsearch.demo.bean.Page;
import com.daren.elasticsearch.demo.common.Criteria;

import java.util.List;

/**
 * 作者：韩家富
 * 描述：
 */
public interface IGoodsInfoDao {
    GoodInfo seachById(long id);
    Page<GoodInfo> search(List<Criteria> criterias, Integer from, Integer size);
}
