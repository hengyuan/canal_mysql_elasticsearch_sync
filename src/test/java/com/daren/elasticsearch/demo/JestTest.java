package com.daren.elasticsearch.demo;

import com.daren.elasticsearch.demo.bean.GoodInfo;
import com.daren.elasticsearch.demo.bean.Page;
import com.daren.elasticsearch.demo.common.Criteria;
import com.daren.elasticsearch.demo.common.EsJestClient;
import com.daren.elasticsearch.demo.dao.impl.GoodInfoDaoImpl;
import io.searchbox.client.JestClient;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：韩家富
 * 描述：
 */
public class JestTest {
    @Test
    public void test(){
        //根据id获取
        JestClient client = EsJestClient.getClient();
        GoodInfoDaoImpl goodInfoDao = new GoodInfoDaoImpl(client);
        GoodInfo goodInfo = goodInfoDao.seachById(981161);
        System.out.println(goodInfo.getDarenNoteTitle());
        //带分页的查询
        Criteria criteria1 = new Criteria("darenNoteTitle","手");
        Criteria criteria2 = new Criteria("darenNoteReason","手");
        List<Criteria> criterias = new ArrayList<>();
        criterias.add(criteria1);
        criterias.add(criteria2);
        Page<GoodInfo> goods = goodInfoDao.search(criterias,1,1);
        System.out.println("total:"+goods.getTotal());
        for(GoodInfo good : goods.getPageInfo()){
            System.out.println("title:"+good.getDarenNoteTitle()+" reson:"+goodInfo.getDarenNoteReason());
        }
    }
}
