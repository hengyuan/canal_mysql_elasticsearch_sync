package com.daren.elasticsearch.demo.dao.impl;

import com.daren.elasticsearch.demo.bean.GoodInfo;
import com.daren.elasticsearch.demo.bean.GoodInfoDB;
import com.daren.elasticsearch.demo.bean.Page;
import com.daren.elasticsearch.demo.common.Criteria;
import com.daren.elasticsearch.demo.common.SearchBuilder;
import com.daren.elasticsearch.demo.dao.IGoodsInfoDao;
import io.searchbox.client.JestClient;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Get;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

import java.io.IOException;
import java.util.List;

/**
 * 作者：韩家富
 * 描述：
 */
public class GoodInfoDaoImpl implements IGoodsInfoDao {
    private JestClient client;

    public GoodInfoDaoImpl(JestClient client) {
        this.client = client;
    }

    @Override
    public GoodInfo seachById(long id) {
        try {
            DocumentResult result = client.execute(new Get.Builder(GoodInfoDB.INDICES, String.valueOf(id))
                    .type(GoodInfoDB.TYPE).build());
            return result.getSourceAsObject(GoodInfo.class);
        } catch (IOException e) {
            throw new RuntimeException("searchById exception", e);
        }
    }

    @Override
    public Page<GoodInfo> search(List<Criteria> criterias, Integer pageNum, Integer pageSize) {
        int from = (pageNum-1)*pageSize;
        try {
            SearchResult result = client.execute(new Search.Builder(SearchBuilder.buildMatchSearch(criterias, from, pageSize)
                    .toString())
                    // multiple index or types can be added.
                    .addIndex(GoodInfoDB.INDICES)
                    .addType(GoodInfoDB.TYPE)
                    .build());
            Long total = result.getTotal();
            List<GoodInfo>  goodInfos = result.getSourceAsObjectList(GoodInfo.class, false);
            Page<GoodInfo> page = new Page<>();
            page.setTotal(total);
            page.setPageInfo(goodInfos);
            return page;
        } catch (Exception e) {
            throw new RuntimeException("search exception", e);
        }
    }
}
