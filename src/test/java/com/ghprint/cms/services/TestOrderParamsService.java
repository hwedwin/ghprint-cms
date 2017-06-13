package com.ghprint.cms.services;

import com.ghprint.cms.model.order.OrderParams;
import com.ghprint.cms.model.order.TOrderParams;
import com.ghprint.cms.pagination.DataGridResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;

/**
 * Created by lipeiting on 2017/6/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestOrderParamsService {

    @Autowired
    private  OrderParamsService orderParamsService;

    @Test
    public void testSelectlist(){
        DataGridResult orderList = orderParamsService.selectOrderParamsList(null,null, 1, 10);
        List list = orderList.getRows();
        Iterator<OrderParams> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    @Test
    public  void  testaddOrderParams(){
        TOrderParams orderParams = new TOrderParams(1,6,2,0.005f,0.005f,0.005f,"note");
        Integer params = orderParamsService.addOrderParams(orderParams);
    }

    @Test
    public  void testdelOrderParams(){
        orderParamsService.delOrderParams(2);
    }

    @Test
    public  void updateOrderParams(){
        OrderParams params = orderParamsService.getOrderParamsById(1);
        System.out.println(params);
        params.setHeight(0.008f);
    }

    @Test
    public  void testselectAllist(){
        List<TOrderParams> list = orderParamsService.selectAllist();
        Iterator<TOrderParams> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

}
