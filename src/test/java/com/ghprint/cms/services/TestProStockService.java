package com.ghprint.cms.services;

import com.ghprint.cms.model.production.TCustomerInfo;
import com.ghprint.cms.model.stock.TProductionStock;
import com.ghprint.cms.pagination.DataGridResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/3/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestProStockService {

    @Autowired
    private  ProStockService proStockService;

    @Test
    public  void testaddProStocks(){
        TProductionStock productionStock =  new TProductionStock( 1, "12200424", "500ml金色热缩套","金",23,231, 32,4,98.54f, 98.54f);
        Integer record = proStockService.addProStock(productionStock);
        System.out.println(record);
    }

    @Test
    public  void testgetProStocklist(){
       DataGridResult dataGridResult = proStockService.selectProStocks("color","金",2,1);
        List list = dataGridResult.getRows();
        Iterator<TProductionStock> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    @Test
    public  void testupdataStocksum(){
       Integer sum =   proStockService.updataStocksum(1,300);
        System.out.println(sum);
    }
}
