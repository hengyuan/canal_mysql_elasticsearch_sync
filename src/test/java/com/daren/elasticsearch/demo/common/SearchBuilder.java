package com.daren.elasticsearch.demo.common;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.util.List;

import static com.daren.elasticsearch.demo.common.SearchType.MATCH;
import static com.daren.elasticsearch.demo.common.SearchType.TERM;

/**
 * 作者：韩家富
 * 描述：
 */
public class SearchBuilder {
    public static SearchSourceBuilder buildTermSearch(List<Criteria> criterias, Integer from, Integer size) {
        return buildSearch(criterias, TERM).from(from).size(size);
    }

    public static SearchSourceBuilder buildMatchSearch(List<Criteria> criterias, Integer from, Integer size) {
        return buildSearch(criterias, MATCH).from(from).size(size);
    }

    private static SearchSourceBuilder buildSearch(List<Criteria> criterias, SearchType searchType) {
        //指定查询的库表
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        if (criterias != null && !criterias.isEmpty()) {
            //构建查询条件必须嵌入filter中！
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
            for (Criteria c : criterias) {
                switch (searchType) {
                    case TERM:
                        boolQueryBuilder.filter(QueryBuilders.termQuery(c.getFieldName(), c.getFieldValue()));
                    case MATCH:
                        boolQueryBuilder.filter(QueryBuilders.matchQuery(c.getFieldName(), c.getFieldValue()));
                }
            }
            searchSourceBuilder.query(boolQueryBuilder);
        }
        return searchSourceBuilder;
    }
}
